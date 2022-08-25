package Servicos;

import Entidades.Contrato;
import Entidades.Parcelas;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;


public class ServicoContrato {
    private ServicoPagamentoOnline pagOnline;
    
      public ServicoContrato(ServicoPagamentoOnline pagOnline) {
        this.pagOnline = pagOnline;
    }
      
    public void processarContrato(Contrato contrato){
        Date dataParcela = contrato.getData();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataParcela);
        // Lista de Parcelas:
        double valorComTaxa;
        double valorSimplesParcela = contrato.getValorTotal() / contrato.getNumParcelas();
        LinkedList<Parcelas> parcelas = new LinkedList<>();
        for(int i = 1; i <= contrato.getNumParcelas(); i++)
        {
            valorComTaxa = pagOnline.valorComTaxa(valorSimplesParcela, i);
            cal.add(Calendar.MONTH, 1);
            dataParcela = cal.getTime();
            parcelas.add(new Parcelas(dataParcela, valorComTaxa));
        }
        contrato.setParcelas(parcelas);
    }
}
