package padraobridge;

public abstract class VideogameAbstrato {

    protected VideogameImpl videogameImpl;

    public VideogameAbstrato(VideogameImpl videogameImpl) {
        this.videogameImpl = videogameImpl;
    }

    public void jogar(String acao) {
        videogameImpl.jogar(acao);
    }

    public void menu(String acao) {
        videogameImpl.menu(acao);
    }
    public abstract void jogar();
}
