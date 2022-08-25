package usinanuclearfactory.usina;

import usinanuclearfactory.elementoradioativo.Bohrio;
import usinanuclearfactory.elementoradioativo.ElementoRadioativo;

public class UsinaAngraDosReis implements Usina {
    @Override
    public ElementoRadioativo criarElementoRadioativo() {
        return new Bohrio();
    }
}
