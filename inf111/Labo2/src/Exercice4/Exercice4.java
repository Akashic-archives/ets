package Exercice4;

import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez rentrer un nombre");
        int nombre = sc.nextInt();
        for (int i = 2; i < nombre/2; i++) {
            if (nombre%i == 0) {
                System.out.println("Ce nombre n'est pas premier, il est divisible par " + i);
                System.exit(0);
            }
        }
        System.out.println("Ce nombre est premier");
    }
}
