package Exercice4;

import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez rentrer le nombre de kg de ciment que vous avez: ");
        double betonCiment = sc.nextDouble();
        System.out.print("Veuillez rentrer le nombre de kg de sable que vous avez: ");
        double betonSable = sc.nextDouble();
        System.out.print("Veuillez rentrer le nombre de kg de gravier que vous avez: ");
        double betonGravier = sc.nextDouble();
        double betonTotalEnMetreCarre = Math.min(betonCiment / 350, Math.min(betonSable / 680, betonGravier / 1175));
        System.out.println("Vous pouvez produire " + betonTotalEnMetreCarre + " mètres carrés de béton.");
    }
}
