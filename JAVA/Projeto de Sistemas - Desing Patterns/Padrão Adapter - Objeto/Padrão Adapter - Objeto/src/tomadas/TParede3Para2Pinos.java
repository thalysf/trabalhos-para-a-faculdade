package tomadas;

public class TParede3Para2Pinos extends Tomada3Pinos{
    private Tomada2Pinos tomada2Pinos;

    public TParede3Para2Pinos(Tomada2Pinos tomada2Pinos) {
        this.tomada2Pinos = tomada2Pinos;
    }

    @Override
    public void plugar() {
        tomada2Pinos.plugar();
    }  
}
