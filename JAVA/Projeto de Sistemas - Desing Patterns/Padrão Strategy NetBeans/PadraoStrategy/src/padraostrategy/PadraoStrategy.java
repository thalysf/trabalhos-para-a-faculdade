package padraostrategy;

import pagamento.Comanda;
import pagamento.Lanche;
import pagamento.TipoPagamento;

import java.util.Arrays;
import java.util.List;
	/*
	* Grupo: Alexandre Borlini, Thalys Fabrete, Pedro Mariano, Vitor Zani.
	* */
public class PadraoStrategy {

	public static void main(String[] args) {

		List<Lanche> lanches = Arrays.asList(
				new Lanche("XBurguer", 15.5),
				new Lanche("XBaconBurguer", 16.5),
				new Lanche("XTudoBurguer", 18.5)
				);

		Comanda comanda01 = new Comanda(TipoPagamento.DINHEIRO, lanches);
		Comanda comanda02 = new Comanda(TipoPagamento.CARTAO_CREDITO, lanches);
		Comanda comanda03 = new Comanda(TipoPagamento.BOLETO, lanches);

		System.out.println("1 - Valor total: " + comanda01.getValorTotal() + " TipoPagamento: " + comanda01.getTipoPagamento());
		System.out.println("2 - Valor total: " + comanda02.getValorTotal() + " TipoPagamento: " + comanda02.getTipoPagamento());
		System.out.println("3 - Valor total: " + comanda03.getValorTotal() + " TipoPagamento: " + comanda03.getTipoPagamento());

		comanda03.atualizarPagamento(TipoPagamento.DINHEIRO);
		System.out.println("3 - Valor total: " + comanda03.getValorTotal() + " TipoPagamento: " + comanda03.getTipoPagamento());
	}
}