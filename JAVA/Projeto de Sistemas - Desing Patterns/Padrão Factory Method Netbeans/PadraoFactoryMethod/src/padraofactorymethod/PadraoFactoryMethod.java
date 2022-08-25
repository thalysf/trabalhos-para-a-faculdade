
package padraofactorymethod;
import usinanuclearfactory.elementoradioativo.ElementoRadioativo;
import usinanuclearfactory.usina.*;
/**
 *
 * @authores thalys fabrete, alexandre borlini, vitor zani, pedro mariano
 */
public class PadraoFactoryMethod {

    public static void main(String[] args) {
       	// Usina de Angra dos Reis
		Usina usina = new UsinaAngraDosReis();
		ElementoRadioativo elemento =  usina.criarElementoRadioativo();
		elemento.exibirRadiacao();

		// Usina de GraveLines
		usina = new UsinaGravelines();
		elemento =  usina.criarElementoRadioativo();
		elemento.exibirRadiacao();

		// Usina de Hanbit
		usina = new UsinaHanbit();
		elemento =  usina.criarElementoRadioativo();
		elemento.exibirRadiacao();

		// Usina de Kashiwazai
		usina = new UsinaKashiwazai();
		elemento =  usina.criarElementoRadioativo();
		elemento.exibirRadiacao();
    }
    
}
