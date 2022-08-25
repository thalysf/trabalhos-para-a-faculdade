package padrao.observer;

import observer.*;

/**
 *
 * @authores thalys fabrete, alexandre borlini, vitor zani e pedro mariano
 */
public class PadraoObserver {

    public static void main(String[] args) {
        DadosSubject dados = new DadosSubject();

        dados.attach(new RetanguloObserver(dados));
        dados.attach(new TrianguloObserver(dados));

        dados.setState(new Info(8, 5));
        System.out.println("#########################################################");
        dados.setState(new Info(5, 2));
        System.out.println("#########################################################");
        dados.setState(new Info(2, 2));
    }
    
}
