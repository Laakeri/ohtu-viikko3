package ohtu;

import javax.swing.JTextField;

public class Erotus extends Operaatio {
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void laske(int arvo) {
        sovellus.miinus(arvo);
    }
    
    @Override
    public void peru() {
        
    }
}
