package tomadas;


public class TomadaParede {
   private Tomada3Pinos tomata3Pinos;

    public Tomada3Pinos getTomata3Pinos() {
        return tomata3Pinos;
    }

    public void setTomata3Pinos(Tomada3Pinos tomata3Pinos) {
        this.tomata3Pinos = tomata3Pinos;
    }
     
    public void conectarEnergia(){
        this.tomata3Pinos.plugar();
    }
}
