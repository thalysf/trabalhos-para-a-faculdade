package observer;

public abstract class InfoObserver {
    protected DadosSubject info;

    public InfoObserver(DadosSubject info) {
        this.info = info;
    }

    public abstract void update();
}

