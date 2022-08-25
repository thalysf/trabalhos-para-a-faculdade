package usinanuclearfactory.elementoradioativo;

import usinanuclearfactory.enums.ClassificacaoRisco;
import usinanuclearfactory.msgs.Msgs;

public class Bohrio implements ElementoRadioativo {
    private final ClassificacaoRisco classificacaoRisco = ClassificacaoRisco.ALTO;
    private final Double radiacao = 1000050.50D;

    @Override
    public void exibirRadiacao() {
        Msgs.exibirMsgConsultaElementoRadioativo(this, classificacaoRisco, radiacao);
    }

    @Override
    public String toString() {
        return "Bóhrio";
    }
}
