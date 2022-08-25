package padraobridge;

public class VideogameUltra extends VideogameAbstrato {
    public VideogameUltra(VideogameImpl videogameImpl) {
        super(videogameImpl);
    }

    @Override
    public void jogar() {
        jogar("\n|Jogando a 60 FPS");
        jogar("|Jogando em FULL HD");
        menu("|Acionando menu ULTRA\n");
    }
}
