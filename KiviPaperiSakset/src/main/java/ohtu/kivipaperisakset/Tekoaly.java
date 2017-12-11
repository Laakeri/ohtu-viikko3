package ohtu.kivipaperisakset;

abstract public class Tekoaly implements Pelaaja {
    abstract String valitseSiirto();
    
    @Override
    public String annaSiirto() {
        String siirto = valitseSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }
}