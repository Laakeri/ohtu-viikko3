package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Ihminen implements Pelaaja {
    private final Scanner scanner;
    private final String nimi;
    public Ihminen(String nimi, Scanner scanner) {
        this.nimi = nimi;
        this.scanner = scanner;
    }
    @Override
    public void toinenSiirsi(String siirto) {
    }
    @Override
    public String annaSiirto() {
        // tää ei ole kovin nätti mutta ajattelin pitää toiminnan samana kuin alkuperäinen
        System.out.print(nimi + " pelaajan siirto: ");
        return scanner.nextLine();
    }
}
