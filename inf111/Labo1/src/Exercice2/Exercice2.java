package Exercice2;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ce programme calcul le volume d'un cylindre.");
        System.out.print("Veuillez rentrer la valeur du rayon: ");
        double rayon = sc.nextDouble();
        System.out.print("Veuillez rentrer la mesure de la hauteur: ");
        double hauteur = sc.nextDouble();
        double volume = Math.PI * Math.pow(rayon, 2) * hauteur;
        System.out.println("Le volume du cylindre est de " + volume);
    }
}
