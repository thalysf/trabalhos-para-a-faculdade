package usinanuclearfactory.elementoradioativo;

import usinanuclearfactory.enums.ClassificacaoRisco;
import usinanuclearfactory.msgs.Msgs;

public class Plutonio implements ElementoRadioativo {
    private final ClassificacaoRisco classificacaoRisco = ClassificacaoRisco.ALTO;
    private final Double radiacao = 2010505.50D;

    @Override
    public void exibirRadiacao() {
        Msgs.exibirMsgConsultaElementoRadioativo(this, classificacaoRisco, radiacao);
    }

    @Override
    public String toString() {
        return "Plutônio";
    }
}
