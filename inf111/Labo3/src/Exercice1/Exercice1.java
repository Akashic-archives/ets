package Exercice1;

public class Exercice1 {
    public static void main(String[] args) {
        System.out.println("32 degrés celcius font " + cel2Fah(32) + " fahrenheit");
        System.out.println("56 fahrenheit font " + fah2Cel(56) + " celcius");
    }

    public static double cel2Fah(double temperature){
        return (temperature*1.8 + 32);
    }

    public static double fah2Cel(double temperature){
        return (temperature-32)/1.8;
    }

}
