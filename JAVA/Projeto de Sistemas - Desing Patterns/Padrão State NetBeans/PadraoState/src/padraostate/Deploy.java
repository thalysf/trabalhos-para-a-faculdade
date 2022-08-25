package padraostate;

public class Deploy implements PipelineState {
    @Override
    public PipelineState prosseguirEsteira() {
        exibirEstadoAtual();
        return this;
    }

    @Override
    public void pararEsteira() {
       throw new RuntimeException("Falha no Deploy!");
    }

    private void exibirEstadoAtual() {
        System.out.println("Deploy .............");
    }

}
