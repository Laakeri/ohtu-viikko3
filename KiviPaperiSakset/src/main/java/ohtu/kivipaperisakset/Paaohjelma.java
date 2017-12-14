package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            
            Pelaaja pelaaja1 = new Ihminen("Ensimmäisen", scanner);
            
            if (vastaus.endsWith("a")) {
                Pelimoottori.pelaa(pelaaja1, new Ihminen("Toisen", scanner));
            } else if (vastaus.endsWith("b")) {
                Pelimoottori.pelaa(pelaaja1, new TekoalyHuono());
            } else if (vastaus.endsWith("c")) {
                Pelimoottori.pelaa(pelaaja1, new TekoalyParannettu(20));
            } else {
                break;
            }
        }

    }
}