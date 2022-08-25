package usinanuclearfactory.msgs;

import usinanuclearfactory.elementoradioativo.ElementoRadioativo;
import usinanuclearfactory.enums.ClassificacaoRisco;

public class Msgs {
        public static void exibirMsgConsultaElementoRadioativo(ElementoRadioativo elemento, ClassificacaoRisco classificacaoRisco, Double radiacao)
        {
            switch (classificacaoRisco)
            {
                case ALTO:
                    System.out.println("Radiação gerada pelo elemento " + elemento.toString() + ": " + radiacao + " R");
                    System.out.println("RISCO ALTÍSSIMO, CUIDADO AO MANIPULAR ESSE ELEMENTO!\n");
                    break;
                case MEDIO:
                    System.out.println("Radiação gerada pelo elemento " + elemento.toString() + ": " + radiacao + " R");
                    System.out.println("RISCO MÉDIO, SE MANTENHA ATENTO DURANTE A MANIPULAÇÂO DESTE ELEMENTO!\n");
                    break;
                case BAIXO:
                    System.out.println("Radiação gerada pelo elemento " + elemento.toString() + ": " + radiacao + " R");
                    System.out.println("RISCO BAIXO, ELEMENTO NÃO APRESENTA NENHUM RISCO CONSIDERÁVEL.\n");
                    break;
            }
        }
}
