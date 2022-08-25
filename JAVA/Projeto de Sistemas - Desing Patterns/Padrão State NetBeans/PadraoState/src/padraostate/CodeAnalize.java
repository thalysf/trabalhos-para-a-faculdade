package padraostate;

public class CodeAnalize implements PipelineState {
    @Override
    public PipelineState prosseguirEsteira() {
        exibirEstadoAtual();
        return new Tests();
    }

    @Override
    public void pararEsteira() {
        throw new RuntimeException("Código não atende as métricas desejadas!");      
    }

    private void exibirEstadoAtual() {
        System.out.println("CodeAnalize .............");
    }

}
