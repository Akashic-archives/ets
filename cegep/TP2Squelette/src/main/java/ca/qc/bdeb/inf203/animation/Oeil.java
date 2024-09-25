package ca.qc.bdeb.inf203.animation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Oeil extends MonstreSpeciaux{


   public void setAvancer(boolean avancer) {
      this.avancer = avancer;
   }

   private boolean avancer=true;


   private double delai3 = 0;

   @Override
   public void updatePhysique(double deltaTemps, double deltaTempsDepart) {
      //délai pour le mouvement des Monstres yeux
      delai3 += deltaTemps;
      ay=0;vy=0;
      ax=0;
      super.updatePhysique(deltaTemps, deltaTempsDepart);
      if (!avancer){
         x-= deltaTemps * vx;
      }

      if (delai3 > 0.25) {
         delai3 = 0;
         if (((vx > 0) && !xVersLaGauche) || ((xVersLaGauche && vx > 0))) {
            if (isPassage())
               setPassage(false);
            else {
               setPassage(true);
               setVx(-1 * getVx());
            }
         } else
            setVx(-1 * getVx());
      }


   }

   @Override
   public void draw(GraphicsContext context) {
      img=new Image("Oeil.png");
      super.draw(context);

   }

}
