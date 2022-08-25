package padraostate;

public class Build implements PipelineState{
    @Override
    public PipelineState prosseguirEsteira() {
        exibirEstadoAtual();
        return new CodeAnalize();
    }

    @Override
    public void pararEsteira() {
        throw new RuntimeException("Falha no Build!");
    }

    private void exibirEstadoAtual() {
        System.out.println("Build .............");
    }
}
