package ohtu.kivipaperisakset;

public class Pelimoottori {
    public static void pelaa(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        Tuomari tuomari = new Tuomari();

        while (true) {
            String ekanSiirto = pelaaja1.annaSiirto();
            String tokanSiirto = pelaaja2.annaSiirto();
            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) break;
            
            pelaaja2.toinenSiirsi(ekanSiirto);
            pelaaja1.toinenSiirsi(tokanSiirto);
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            
            System.out.println(tuomari);
            System.out.println();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
