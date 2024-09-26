package Exercice3;

public class Exercice3 {
    public static void main(String[] args) {
        double pi = 1;
        for (int i = 0; i < 10000; i++) {
            pi = pi * (2*i+2)/(2*i+1);
            pi = pi * (2*i+2)/(2*i+3);
        }
        System.out.println(pi*2);
    }
}
