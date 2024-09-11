package Exercice3;

import java.util.Scanner;

public class Exercice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer une valeur en secondes: ");
        int temps = sc.nextInt();
        int secondes = temps % 60;
        temps = temps - secondes;
        temps = temps / 60;
        int minutes = temps % 60;
        temps = temps - minutes;
        temps = temps / 60;
        int heure = temps;
        System.out.println(heure + " : " + minutes + " : " + secondes);
    }
}
