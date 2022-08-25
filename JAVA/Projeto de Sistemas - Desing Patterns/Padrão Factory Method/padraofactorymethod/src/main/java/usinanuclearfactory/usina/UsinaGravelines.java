package usinanuclearfactory.usina;

import usinanuclearfactory.elementoradioativo.ElementoRadioativo;
import usinanuclearfactory.elementoradioativo.Plutonio;

public class UsinaGravelines implements Usina {
    @Override
    public ElementoRadioativo criarElementoRadioativo() {
        return new Plutonio();
    }
}
