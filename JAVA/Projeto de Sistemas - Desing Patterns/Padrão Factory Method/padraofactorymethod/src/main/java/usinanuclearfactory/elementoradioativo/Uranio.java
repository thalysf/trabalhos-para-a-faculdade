package usinanuclearfactory.elementoradioativo;

import usinanuclearfactory.enums.ClassificacaoRisco;
import usinanuclearfactory.msgs.Msgs;

public class Uranio implements ElementoRadioativo {
    private final ClassificacaoRisco classificacaoRisco = ClassificacaoRisco.MEDIO;
    private final Double radiacao = 210050.50D;

    @Override
    public void exibirRadiacao() {
        Msgs.exibirMsgConsultaElementoRadioativo(this, classificacaoRisco, radiacao);
    }

    @Override
    public String toString() {
        return "Uránio";
    }
}
