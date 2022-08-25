package padraocomposite;

/**
 *
 * @authores thalys fabrete, alexandre borlini, vitor zani, pedro mariano.
 */
public class PadraoComposite {

    public static void main(String[] args) {
        Humano joao = new Fulano("João Paulo", 20, SexoEnum.M);
        Humano eduardo = new Fulano("Eduardo Siqueira", 40, SexoEnum.M);
        Humano maria = new Fulano("Maria Clara", 25, SexoEnum.F);
        Humano carla = new Fulano("Carla Andrade", 75, SexoEnum.F);
        
        joao.exibirInfoHumano();
        eduardo.exibirInfoHumano();
        maria.exibirInfoHumano();
        carla.exibirInfoHumano();
        
        
        eduardo.addFilho(joao);
        eduardo.addFilho(maria);
        eduardo.exibirInfoHumano();
        carla.addFilho(eduardo);
        carla.exibirInfoHumano();
    }
    
}
