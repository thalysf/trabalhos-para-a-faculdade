package usinanuclearfactory.usina;

import usinanuclearfactory.elementoradioativo.ElementoRadioativo;
import usinanuclearfactory.elementoradioativo.Uranio;

public class UsinaKashiwazai implements Usina {
    @Override
    public ElementoRadioativo criarElementoRadioativo() {
        return new Uranio();
    }
}
