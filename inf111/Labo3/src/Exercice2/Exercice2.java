package Exercice2;

import java.util.Random;

public class Exercice2 {
    public static void main(String[] args) {
        System.out.println("Regardez le code");
    }

    private static int getNombreDeZeros(int tab[][]) {
        int nombreDeZeros = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == 0)
                    nombreDeZeros += 1;
            }
        }
        return nombreDeZeros;
    }

    private static double[] fusion(double tab1[], double tab2[]) {
        double tab3[] = new double[tab1.length + tab2.length];
        for (int i = 0; i < tab3.length/2; i+=2) {
            tab3[i] = tab1[i];
        }
        for (int i = 1; i < tab3.length/2; i+=2) {
            tab3[i] = tab2[i];
        }
        return tab3;
    }

    private static double[] getNouveauTableau(int nb, double min, double max) {
        double tab[] = new double[nb];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = getNbAleatoireEntre(min, max);
        }
        return tab;
    }

    private static void inverser(double tab[]) {
        double tabTemp[] = getInverse(tab);
        for (int i = 0; i < tab.length; i++) {
            tab[i] = tabTemp[i];
        }
    }

    private static double[] getInverse(double tab[]) {
        double tabTemp[] = new double[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tabTemp[i] = tab[tab.length - i];
        }
        return tabTemp;
    }

    private static void remplirAleatoirement(double tab[], double min, double max) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = getNbAleatoireEntre(min, max);
        }
    }

    private static double getNbAleatoireEntre(double min, double max) {
        Random rand = new Random();
        double nombre = rand.nextDouble();
        return nombre * (max - min) + min;
    }
}
