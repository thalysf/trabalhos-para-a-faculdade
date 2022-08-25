package usinanuclearfactory.elementoradioativo;

import usinanuclearfactory.enums.ClassificacaoRisco;
import usinanuclearfactory.msgs.Msgs;

public class Radonio implements ElementoRadioativo {
    private final ClassificacaoRisco classificacaoRisco = ClassificacaoRisco.BAIXO;
    private final Double radiacao = 35050.50D;

    @Override
    public void exibirRadiacao() {
        Msgs.exibirMsgConsultaElementoRadioativo(this, classificacaoRisco, radiacao);
    }

    @Override
    public String toString() {
        return "Radônio";
    }
}
