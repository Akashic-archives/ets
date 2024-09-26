package Exercice2;

import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez rentrer un nombre");
        int nombre = sc.nextInt();
        for (int i = 1; i < nombre; i++) {
            if (nombre % i == 0)
                System.out.println(i);
        }
    }
}
