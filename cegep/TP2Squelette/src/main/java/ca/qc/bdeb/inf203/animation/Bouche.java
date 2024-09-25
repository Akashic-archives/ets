package ca.qc.bdeb.inf203.animation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bouche extends MonstreSpeciaux{
    private double ybase=y;
    private double tempsEcoule=10;
    @Override
    public void updatePhysique(double deltaTemps, double deltaTempsDepart) {
        ay=0;
        super.updatePhysique(deltaTemps,deltaTempsDepart);
        tempsEcoule+=deltaTemps;
        y = ybase + 50 * Math.sin(5 * tempsEcoule);
    }

    @Override
    public void draw(GraphicsContext context) {
        img=new Image("bouche.png");
        super.draw(context);

    }
}
