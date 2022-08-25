package observer;

public class RetanguloObserver extends InfoObserver {
    public RetanguloObserver(DadosSubject info) {
        super(info);
    }
    @Override
    public void update() {
        System.out.println("----------- Retângulo -----------");
        System.out.printf("Área: %d\n", (info.getState().base * info.getState().altura));
        System.out.printf("Perímetro: %d\n", 2 * (info.getState().base + info.getState().altura));
    }
}
