package ca.qc.bdeb.inf203.animation;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static ca.qc.bdeb.inf203.animation.Main.WIDTH;

public class Partie {
    private boolean modeDebugage = false;
    Squelette personnage = new Squelette();
    Oeil oeil = new Oeil();
    ArrayList<Monstres> listeMonstres = new ArrayList<>();
    ArrayList<Magie> listMagie = new ArrayList<>();
    private boolean coolDownMagie = false;
    private double deltaTimeMagie = 0;

    public static int getNiveau() {
        return niveau;
    }

    private Random random = new Random();
    private static int niveau = 1;
    private int nombreMonstresMorts = 0;
    private int score = 0;
    private boolean afficherMonstres = false;
    private boolean partieEncours = true;
    //compte le temps de la partie
    //delai monstres normaux
    private double delai = 0;
    //delai generation monstres speciaux
    private double delai2 = 0;

    private double delai4 = 0;

    private boolean prochainNiv = false;
    private Image imgVie = new Image("squelette.png");

    /**
     * Méthode qui gère toute la logique du jeu Squelette Espiègle
     *
     * @param deltaTemps      Le temps entre Chaque Animation
     * @param deltaTimeDepart Le temps depuis le début de l'animation
     * @param context         Permet de dessiner dans le canvas
     * @return une valeur booléenne pour indiquer au Main que la partie est Terminée
     */
    public boolean jouer(double deltaTemps, double deltaTimeDepart, GraphicsContext context) {
        debugMode(context);
        //délai avant de permettre la génération de monstres
        delai += deltaTemps;
        //délai pour générer les monstres en 3 secondes
        delai2 += deltaTemps;



        if (personnage.getNombreVies() == 0) {
            partieEncours = false;
        }
        if (partieEncours) {
            //affiche le niveau pendant 3 secondes au début du programme et à chaque passage de niveau
            if (deltaTimeDepart * 1e-9 < 3 || prochainNiv) {
                afficherNiv(context);
            }
            //dessiner les vies
            for (int i = 0; i < personnage.getNombreVies(); i++) {
                imgVie = ImageHelpers.colorize(imgVie, Color.VIOLET);
                context.drawImage(imgVie, (Main.WIDTH / 2) - 60 + (i * 45), 130, 45, 45);
            }
            //afficher les Scores
            afficherScore(context);
            //update la physique du squelette et le dessiner
            personnage.updatePhysique(deltaTemps, deltaTimeDepart);
            personnage.draw(context);
            if (deltaTimeMagie < deltaTimeDepart) {
                coolDownMagie = false;
            }
            //permettre de tirer la magie que tous les 0,6 secondes
            if (verifMagie() && !coolDownMagie) {
                listMagie.add(new Magie(personnage.getX() + 24, personnage.getY()));
                coolDownMagie = true;
                deltaTimeMagie = deltaTimeDepart + 6 * 1e8;
            }
            //dessine la magie
            for (Magie magie : listMagie
            ) {
                magie.updatePhysique(deltaTemps);
                magie.draw(context);

            }
            if (deltaTimeDepart * 1e-9 > 3) {
                if (delai > 3) {
                    delai = 0;
                    prochainNiv = false;
                    afficherMonstres = true;
                }
                if (afficherMonstres) {
                    //ajouter les monstres tous les 3 secondes()
                    //On ne met pas==0, car nano secondes ne pourrons jamais être exactement ça
                    if (delai == 0) {
                        listeMonstres.add(new Monstres());
                        if (delai2 >= 5 && niveau >= 2) {
                            delai2 = 0;
                            // ajouter les 2 monstres spéciaux
                            if (random.nextDouble() < 0.5) {
                                Oeil oeil = new Oeil();
                                oeil.positionHazard(true,true);
                                listeMonstres.add(oeil);
                            } else {
                                Bouche bouche = new Bouche();
                                bouche.positionHazard(true,true);
                                listeMonstres.add(bouche);
                            }


                        }
                    }
                    /*if (delai3 > 0.5 && delai3 < 0.75) {
                        oeil.setAvancer(false);
                    } else if (delai3 < 0.5) {
                        oeil.setAvancer(true);
                    } else delai3 = 0;*/

                    //update la physique de tous les monstres et les dessiner
                    UpdateListes(context, deltaTemps, deltaTimeDepart, listeMonstres);

                }
                //si les monstres sont touchés, ils sont morts
                for (int i = 0; i < listMagie.size(); i++) {
                    for (int j = 0; j < listeMonstres.size(); j++) {
                        if (verifierCollision(listMagie.get(i), listeMonstres.get(j))) {
                            listeMonstres.get(j).setEstVivant(false);
                        }
                    }

                }
                for (int i = 0; i < listeMonstres.size(); i++) {
                    //Si l'un des monstres est mort on l'enlève
                    if (!listeMonstres.get(i).isEstVivant()) {
                        listeMonstres.remove(listeMonstres.get(i));
                        nombreMonstresMorts++;
                        score++;
                        //à tous les 5 monstres tués, le nbre revient à 0 et le niv augmente
                        //on garde le temps auquel le niv a changé pour faire les 3 sec d'attente
                        if (nombreMonstresMorts % 5 == 0) {
                            prochainNiv = true;
                            delai = 0;
                            //efface tous les monstres
                            listeMonstres.clear();
                            afficherMonstres = false;
                            nombreMonstresMorts = 0;
                            niveau++;
                        }
                    } else {
                        //voir si l'un a réussi à aller de l'autre côté
                        //l'enlever de la liste de monstres
                        //réduire la vie
                        if ((listeMonstres.get(i).getX() < 0 && listeMonstres.get(i).isxVersLaGauche()) || (listeMonstres.get(i).getX() > Main.WIDTH && !listeMonstres.get(i).isxVersLaGauche())) {
                            listeMonstres.remove(listeMonstres.get(i));
                            personnage.setNombreVies(personnage.getNombreVies() - 1);
                        }
                    }

                }
            }
            if (Input.isKeyPressed(KeyCode.H))
                niveau += 1;
            if (Input.isKeyPressed(KeyCode.J))
                score += 1;
            if (Input.isKeyPressed(KeyCode.K) && personnage.getNombreVies() < 3)
                personnage.setNombreVies(personnage.getNombreVies() + 1);
            else if (Input.isKeyPressed(KeyCode.K)) {
                context.setFont(Font.font(20));
                context.setFill(Color.RED);
                context.fillText("Vie Max Atteinte", Main.WIDTH / 2 - 75, Main.HEIGHT / 2);
            }
            if (Input.isKeyPressed(KeyCode.L))
                partieEncours = false;
        } else {
            afficherDefaite(context);
            niveau = 1;
            delai4 += deltaTemps;
            if (delai4 > 3) {
                return true;
            }

        }
        return false;


    }




    /**
     * Méthode qui update tous les personnages d'une liste
     *
     * @param context
     * @param deltaTemps
     * @param deltaTimeDepart
     * @param liste
     */
    public void UpdateListes(GraphicsContext context, double deltaTemps, double deltaTimeDepart, ArrayList<Monstres> liste) {
        for (Monstres monstre : liste) {
            monstre.updatePhysique(deltaTemps, deltaTimeDepart);
            monstre.draw(context);
        }
    }


    /**
     * Méthode qui gère le mode débogage
     * Elle s'active avec la lettre M
     *
     * @param context
     */
    public void debugMode(GraphicsContext context) {
        if (Input.isKeyPressed(KeyCode.M)) {
            if (modeDebugage)
                modeDebugage = false;
            else
                modeDebugage = true;
        }
        if (modeDebugage) {
            String debug = "monstres: " + listeMonstres.size() + "\nvie: " + personnage.getNombreVies() + "\nscore: " + score + "\n"
                    + "niveau: " + niveau + "\najoute mais n'enleve pas";
            context.setFont(Font.font(15));
            context.fillText("Score: " + score, 245, 280);
            context.setFill(Color.rgb(255, 255, 255));
            context.fillText(debug, 5, 10, 200);
        }
    }

    /**
     * Méthode qui permet d'afficher quand la partie est terminée
     *
     * @param context
     */
    public void afficherDefaite(GraphicsContext context) {
        context.setFill(Color.RED);
        context.setFont(Font.font(45));
        context.fillText("Fin de partie", 220, 220);
        context.setFill(Color.BLUE);
        context.fillText("Score: " + score, 245, 280);

    }

    /**
     * Méthode qui permet d'afficher le niveau
     *
     * @param context
     */
    public void afficherNiv(GraphicsContext context) {
        context.setFill(Color.WHITE);
        context.setFont(Font.font(45));
        context.fillText("Niveau " + niveau, 220, 220);

    }

    /**
     * Méthode qui permet d'afficher le score
     *
     * @param context
     */
    public void afficherScore(GraphicsContext context) {
        context.setFill(Color.YELLOW);
        context.setFont(Font.font(40));
        context.fillText("" + score, 290, 50);

    }

    /**
     * Méthode qui vérifie que la touche pour la magie est enfoncée
     *
     * @return
     */
    public boolean verifMagie() {
        if (Input.isKeyPressed(KeyCode.SPACE)) {
            return true;
        } else return false;
    }


    /**
     * Méthode qui vérifie s'il y a collision entre 2 objets
     *
     * @param obj1 la boule de magie
     * @param obj2 Le monstre
     * @return vrai ou faux
     */
    public boolean verifierCollision(Magie obj1, Monstres obj2) {
        double dx = obj2.getX() - obj1.getX();
        double dy = (obj2.getY() + obj2.getRayon()) - (obj1.getY() + obj2.getRayon());
        double dCarre = dx * dx + dy * dy;
        return dCarre < (obj2.getRayon() + obj1.getRayon()) * (obj2.getRayon() + obj1.getRayon());
    }
}
