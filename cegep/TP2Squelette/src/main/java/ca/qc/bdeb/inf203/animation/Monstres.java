package ca.qc.bdeb.inf203.animation;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;

import java.util.Random;

import static ca.qc.bdeb.inf203.animation.Main.HEIGHT;
import static ca.qc.bdeb.inf203.animation.Main.WIDTH;

public class Monstres extends Personnage {


    public boolean isPassage() {
        return passage;
    }

    public void setPassage(boolean passage) {
        this.passage = passage;
    }

    protected boolean passage = true;
    protected boolean isxVersLaGauche() {
        return xVersLaGauche;
    }


    public double getVx() {
        return vx;
    }

    protected double vx = vitesse(), vy = 0;

    protected double ax = 0, ay = 100;
   protected Random rnd = new Random();
    protected double rayon = (double) rnd.nextInt(30) + 20;

    protected Image img;

    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }

    public boolean isEstVivant() {
        return estVivant;
    }

    protected boolean estVivant = true;


    public Monstres() {
        Random random = new Random();
        int monstrePng = random.nextInt(7);
        img = new Image(monstrePng + ".png");
        img = ImageHelpers.colorize(img, ImageHelpers.couleurAuHasard());
        //positions au hasard de x et de y
        positionHazard(true, true);
        vy = -(random.nextInt(101)+100);

    }


    public void setVx(double vx) {
        this.vx = vx;
    }

    @Override
    public void updatePhysique(double deltaTemps, double deltaTempsDepart) {
        vx += deltaTemps * ax;
        vy += deltaTemps * ay;

        y += deltaTemps * vy;
        if (xVersLaGauche) {
            x -= deltaTemps * vx;
        }
        else{
            x += deltaTemps * vx;
        }

    }

    public void draw(GraphicsContext context) {
        context.drawImage(img, x, y, rayon * 2, rayon * 2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRayon() {
        return rayon;
    }

    /**
     * Méthode qui donne une position aléatoire
     * @param deciderX booléen qui donne vrai ou faux
     * @param deciderY booléen qui donne vrai ou faux
     */
    public void positionHazard(boolean deciderX, boolean deciderY) {
        if (deciderX) {
            if (rnd.nextDouble() < 0.5) {
                xVersLaGauche = false;
                x = 0;
            } else {
                xVersLaGauche = true;
                x = WIDTH;
                img = ImageHelpers.flop(img);
            }
        }
        if (deciderY) {
            if (rnd.nextDouble() < 0.5) {
                y = HEIGHT / 5+rayon;
            } else {
                y = (HEIGHT / 5) * 4-100;
            }

        }
    }

    /**Méthode qui calcule la vitesse selon le niveau
     * @return
     */
    public int vitesse(){
        return (int) (100 * Math.pow(Partie.getNiveau(),0.33) + 200);
    }
}
