package Servicos;

public class ServicoPayPal implements ServicoPagamentoOnline{

    @Override
    public double valorComTaxa(double quantia, int parcela) {
        double taxaPayPalSimples = (double) parcela/100;
        double taxaPayPalMensal = 0.02;
        
        double jurosSimples = quantia + (quantia * taxaPayPalSimples);
        double jurosComposto =  jurosSimples + (jurosSimples * taxaPayPalMensal);
        return jurosComposto;
    }
}
