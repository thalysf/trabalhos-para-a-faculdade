package padraostate;

public class Tests implements PipelineState {
    @Override
    public PipelineState prosseguirEsteira() {
        exibirEstadoAtual();
        return new Deploy();
    }

    @Override
    public void pararEsteira() {
        throw new RuntimeException("Código não atingiu a cobertura mínima desejada!");
    }

    private void exibirEstadoAtual() {
        System.out.println("Tests .............");
    }
}
