package com.padraofactorymethod.padraofactorymethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import usinanuclearfactory.elementoradioativo.ElementoRadioativo;
import usinanuclearfactory.usina.*;

@SpringBootApplication
public class PadraofactorymethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadraofactorymethodApplication.class, args);
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
