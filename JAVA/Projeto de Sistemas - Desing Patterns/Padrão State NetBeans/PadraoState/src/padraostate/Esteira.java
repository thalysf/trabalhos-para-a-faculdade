package padraostate;

public class Esteira {
    protected PipelineState pipelineState;

    public Esteira() {
        exibirEstadoAtual();
        this.pipelineState = new Build();
    }

    public void prosseguirEsteira() {
        this.pipelineState = pipelineState.prosseguirEsteira();
    }

    public void pararSteira() {
        this.pipelineState.pararEsteira();
    }
    private void exibirEstadoAtual() {
        System.out.println("Iniciando pipeline .............");
    }
}
