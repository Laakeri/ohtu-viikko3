package ohtu;

import javax.swing.JTextField;

public class Nollaa extends Operaatio {
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void laske(int arvo) {
        sovellus.nollaa();
    }
    
    @Override
    public void peru() {
        
    }
}