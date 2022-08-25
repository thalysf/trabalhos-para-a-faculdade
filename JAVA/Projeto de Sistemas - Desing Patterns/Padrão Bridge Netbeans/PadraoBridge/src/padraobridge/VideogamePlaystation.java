package padraobridge;

import util.ConstantesPlaystation;

public class VideogamePlaystation implements VideogameImpl {
    @Override
    public void jogar(String acao) {
        System.out.printf("\n|%s - %s\n", acao, ConstantesPlaystation.JOGAR);
    }

    @Override
    public void menu(String acao) {
        System.out.printf("\n|%s - %s\n", acao, ConstantesPlaystation.MENU);
    }
}
