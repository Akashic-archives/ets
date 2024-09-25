package ca.qc.bdeb.inf203.animation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Random;

public class Magie {


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double x;
    private double y;

    public double getRayon() {
        return rayon;
    }

    private double rayon=35;
    //pour que la couleur change aléatoirement
    private Random rnd=new Random();
    private Color couleur= ImageHelpers.couleurAuHasard();



    private double vx = 0, vy = -300;
    private double ax = 0, ay = 0;

    public Magie(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public void updatePhysique(double deltaTemps) {

        // / Calcul de la nouvelle vitesse
        //vx += deltaTemps * ax;
        vy += deltaTemps * ay;
        // Calcul de la nouvelle position
        y += deltaTemps * vy;


    }

    public void draw(GraphicsContext context) {
            context.setFill(couleur);
            context.fillOval(x, y, 40, 40);
    }
}
