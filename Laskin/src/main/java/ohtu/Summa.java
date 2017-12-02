package ohtu;

import javax.swing.JTextField;

public class Summa extends Operaatio {
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void laske(int arvo) {
        sovellus.plus(arvo);
    }
    
    @Override
    public void peru() {
        
    }
}
