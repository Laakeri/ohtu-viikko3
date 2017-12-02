package ohtu;

import javax.swing.JTextField;

public abstract class Operaatio implements Komento {
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    private int previousValue = 0;
    
    public Operaatio(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    private void nayta() {
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    public void suorita() {
        previousValue = sovellus.tulos();
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        laske(arvo);
        nayta();
    }
    protected abstract void laske(int arvo);
    
    public void peru() {
        sovellus.setValue(previousValue);
        nayta();
    }
}
