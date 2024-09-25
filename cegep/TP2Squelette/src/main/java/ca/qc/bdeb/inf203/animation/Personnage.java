package ca.qc.bdeb.inf203.animation;

import javafx.scene.image.Image;

public class Personnage {
    protected double x, y;
    protected double vx , vy;
    protected double ax , ay ;
    protected boolean xVersLaGauche;

    /**Méthode qui change les valeurs de position d'un personnage
     * @param deltaTemps
     * @param deltaTempsDepart
     */
    public void updatePhysique(double deltaTemps,double deltaTempsDepart) {
        // / Calcul de la nouvelle vitesse

        vx += deltaTemps * ax;
        vy += deltaTemps * ay;

        y += deltaTemps * vy;


    }


}
