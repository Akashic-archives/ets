package ca.qc.bdeb.inf203.animation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Squelette extends Personnage {
    private double x = Main.WIDTH / 2, y = Main.HEIGHT;
    private Image image = new Image("stable.png");
    private Image image2 = new Image("marche1.png");
    private Image image3 = new Image("marche2.png");
    //l'image en cours parmi les trois images
    private Image imgEncours = image;
    private final Image[] frames = new Image[]{
            image, image2, image3
    };

    private boolean estEnvie = true;

    public int getNombreVies() {
        return nombreVies;
    }

    private int nombreVies = 3;

    private boolean versLaGauche;

    private double w = image.getWidth();

    private double h = image.getHeight();

    private boolean ensaut = false;
    private final double framerate = 10 * 1e-9;
    // Physique
    private double vx = 0, vy = 0;

    private double ax = 0, ay = 1200;

    @Override
    public void updatePhysique(double deltaTemps, double deltaTempsDepart) {

        boolean left = Input.isKeyPressed(KeyCode.LEFT) || Input.isKeyPressed(KeyCode.A);
        boolean right = Input.isKeyPressed(KeyCode.RIGHT) || Input.isKeyPressed(KeyCode.D);
        boolean up = Input.isKeyPressed(KeyCode.UP) || Input.isKeyPressed(KeyCode.W);
        boolean down = Input.isKeyPressed(KeyCode.DOWN) || Input.isKeyPressed(KeyCode.S);


        if (x + 48 > Main.WIDTH || x < 0) {
            vx *= -0.9;
        }
        //j'ai mis 101, car glitch quand je met 96 avec accel de 1200
        if (y + 96 > Main.HEIGHT || y < 0) {
            //y-=3;  si on voulais le faire rebondir
            vy = 0;
        }
        if (y + 96 > Main.HEIGHT) {
            ensaut = false;
        }
        // Valide que la balle ne termine jamais hors des côtés de l'écran
        x = Math.min(x, Main.WIDTH - 48);
        x = Math.max(x, 0);
        y = Math.min(y, Main.HEIGHT - 96);
        y = Math.max(y, 0);

        if (left) {
            versLaGauche=true;
            imageDemarche(deltaTempsDepart);

            if (!ensaut) {
                imgEncours = ImageHelpers.flop(imgEncours);
            }
            ax = -1200;
            if (vx <= -300) {
                vx = -300;
            }
        } else if (right) {
            versLaGauche=false;
            imageDemarche(deltaTempsDepart);
            ax = 1200;
            if (vx >= 300) {
                vx = 300;
            }
        } else {
            ax = 0;

// Quand on relâche : on RALENTI au lieu de stopper
            //source: notes de cours animation 5 diapo 17
            //https://www-bdb-ovx.omnivox.ca/cvir/ddle/VisualiseDocument.aspx?C=BDB&E=P&L=FRA&Ref=20221122125710&Info=RE5HSWFBdXhXa1lFS25qYS9pV25nVkFjK3Y4QkIxV1lhbFRSLzFTc2RUdGpUVDdTbFM2NnNaZnZKOWZiU25jRnRJOTVTanQzODJTOTNMRktudSt2YUJIWGV1Y0hDN09mNy9GbHRQWjVTL3R3a1JmaVZZa2t2OHdPOFd4K0M3VkNTa3J4c21ybjhVZXFncHdBTVNhWjZPU1hHYVQyQ0ttOEpUZWVQam50TEF3PQ__&IDDocCoursDocument=d17bdb67-32ee-4974-a492-1a0a77bf6e3d
            int signeVitesse = vx > 0 ? 1 : -1;
            double vitesseAmortissementX = -signeVitesse * 1000;
            vx += deltaTemps * vitesseAmortissementX;
            int nouveauSigneVitesse = vx > 0 ? 1 : -1;
// On évite un petit glitch :
// si le signe change, la vitesse tombe à zéro
            if(nouveauSigneVitesse != signeVitesse) {
                vx = 0;
            }
            //fin de la source;
            if (versLaGauche){
                imgEncours=ImageHelpers.flop(image);
            }else {
                imgEncours=image;
            }



        }


        if (up && !ensaut) {
            //Pour que ses pieds soient droits en l'air
            ensaut = true;
            vy = -600;

        } else if (down) {
            if (y+96!=Main.HEIGHT)
                vy = 400;
        }
        if (ensaut) {
            if (left) {
                imgEncours = ImageHelpers.flop(image);
            } else if (right) {
                imgEncours = image;
            }
        }
        // / Calcul de la nouvelle vitesse
        vx += deltaTemps * ax;
        vy += deltaTemps * ay;

        // Calcul de la nouvelle position
        x += deltaTemps * vx;

        y += deltaTemps * vy;

    }

    //dessine un squelette
    public void draw(GraphicsContext context) {
        context.drawImage(imgEncours, x, y, 48, 96);
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setNombreVies(int nombreVies) {
        this.nombreVies = nombreVies;
    }


    /**Méthode qui permet de prendre la bonne image selon le temps de l'animation afin de donne une illusion de mouvement
     * @param deltaTempsDepart
     */
    public void imageDemarche(double deltaTempsDepart) {
        if (!ensaut) {
            //Il faut plutôt le delta depuis le début
            double frameRate = 10 * 1e-9;
        /* Calcul du deltaTime par rapport au
               début de l'animation */
            //pas la limite des int, sinon, il ne pourra plus monter et donc pas de
            //changement d'image
            int frame = (int) Math.floor(deltaTempsDepart * frameRate);
            imgEncours = frames[frame % frames.length];
        }
    }


}

