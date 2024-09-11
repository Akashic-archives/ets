package Exercice1;

import java.util.Scanner;

public class Exercice1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez rentrer une température en degrés celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = celsius * 9/5 + 32;
        System.out.println(celsius + " est " + fahrenheit + " en fahrenheit");

    }
}
