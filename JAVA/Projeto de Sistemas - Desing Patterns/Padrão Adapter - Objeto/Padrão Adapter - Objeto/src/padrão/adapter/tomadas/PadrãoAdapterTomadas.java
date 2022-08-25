package padrão.adapter.tomadas;

import tomadas.*;

// @Authores: Thalys, Vitor Zani, Alexandre Borlini, Pedro Mariano.
public class PadrãoAdapterTomadas {

    
    public static void main(String[] args) {
        TomadaParede tomadaParede = new TomadaParede();
        Tomada2Pinos tomada2Pinos = new Tomada2Pinos();
              
        TParede3Para2Pinos t = new TParede3Para2Pinos(tomada2Pinos);
        tomadaParede.setTomata3Pinos(t);
        tomadaParede.conectarEnergia();
    }
    
}
