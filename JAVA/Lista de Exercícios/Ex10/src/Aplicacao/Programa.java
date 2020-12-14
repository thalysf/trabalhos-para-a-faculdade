
package Aplicacao;

import Entidades.Contrato;
import Entidades.Parcelas;
import Servicos.ServicoContrato;
import Servicos.ServicoPayPal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Programa {

  
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataContrato = dateFormat.parse("25/06/2020");
        Contrato contrato01 = new Contrato(1122, 3, dataContrato, 600.0);
        ServicoContrato servico01 = new ServicoContrato(new ServicoPayPal());
        servico01.processarContrato(contrato01);
        
        System.out.println("Parcelas: ");
        for(Parcelas parcela: contrato01.getParcelas())
        {
            System.out.println(parcela.toString());
        }
    }
}
