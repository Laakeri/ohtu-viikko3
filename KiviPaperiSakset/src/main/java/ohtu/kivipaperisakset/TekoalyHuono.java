package ohtu.kivipaperisakset;

public class TekoalyHuono extends Tekoaly {
    private int siirto;
    
    public TekoalyHuono() {
        siirto = 0;
    }
    
    @Override
    public String valitseSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    public void toinenSiirsi(String siirto) {
        // ei tehdä mitään 
    }
}
