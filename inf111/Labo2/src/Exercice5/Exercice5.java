package Exercice5;

import java.util.Scanner;

public class Exercice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez rentrer un nombre");
        int nombre = sc.nextInt();
        estPremier(nombre);
        boolean continuer = true;
        do {
            System.out.println("Voulez-vous continuer? (0 pour oui, 1 pour non)");
            if (sc.nextInt() == 1)
                continuer = false;
            System.out.println("Veuillez rentrer un nombre");
            nombre = sc.nextInt();
            estPremier(nombre);
        } while (continuer);

    }

    public static int estPremier(int nombre) {
        for (int i = 2; i < nombre / 2; i++) {
            if (nombre%i == 0){
                System.out.println("Ce nombre est divisible par " + i);
                return i;
            }
        }
        System.out.println("Ce nombre est premier");
        return 0;
    }

}
