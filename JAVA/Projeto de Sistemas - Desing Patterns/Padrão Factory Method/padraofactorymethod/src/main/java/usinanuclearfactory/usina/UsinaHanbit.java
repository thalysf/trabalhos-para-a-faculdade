package usinanuclearfactory.usina;

import usinanuclearfactory.elementoradioativo.ElementoRadioativo;
import usinanuclearfactory.elementoradioativo.Radonio;

public class UsinaHanbit implements Usina {
    @Override
    public ElementoRadioativo criarElementoRadioativo() {
        return new Radonio();
    }
}
