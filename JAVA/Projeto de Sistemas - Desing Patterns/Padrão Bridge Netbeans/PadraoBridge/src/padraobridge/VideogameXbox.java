package padraobridge;

import util.ConstantesXbox;

public class VideogameXbox implements VideogameImpl {

   @Override
    public void jogar(String acao) {
        System.out.printf("\n|%s - %s\n", acao, ConstantesXbox.JOGAR);
    }

    @Override
    public void menu(String acao) {
        System.out.printf("\n|%s - %s\n", acao, ConstantesXbox.MENU);
    }

}
