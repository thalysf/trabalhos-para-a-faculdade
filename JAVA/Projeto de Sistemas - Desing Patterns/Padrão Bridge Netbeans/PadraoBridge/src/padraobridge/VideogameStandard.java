package padraobridge;

public class VideogameStandard extends VideogameAbstrato {
    public VideogameStandard(VideogameImpl videogameImpl) {
        super(videogameImpl);
    }

    @Override
    public void jogar() {
        jogar("\n|Jogando a 30 FPS");
        jogar("|Jogando em HD");
        menu("|Acionando menu STANDARD\n");
    }
}
