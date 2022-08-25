package observer;

public class TrianguloObserver extends InfoObserver {
    public TrianguloObserver(DadosSubject dados) {
        super(dados);
    }
    @Override
    public void update() {
        System.out.println("----------- Triângulo -----------");
        System.out.printf("Área: %d\n", (info.getState().base * info.getState().altura) / 2);
    }
}
