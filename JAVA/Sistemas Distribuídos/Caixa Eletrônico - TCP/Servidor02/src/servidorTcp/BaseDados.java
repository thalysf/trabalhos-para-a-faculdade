/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorTcp;

import commons.SolicitaOperacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class BaseDados {
    
    private int valor;
    private String logs_operacoes = "";
    private DateFormat dateFormat;
    
    public BaseDados(){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
    }
    
    public BaseDados(int valorInicial){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        setValor(valorInicial);
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void incrementar(int incremento){
        setValor(this.getValor() + incremento);
    }
    
    public boolean decrementar(int decremento){
        
        if(!(this.valor - decremento < 0)){
            setValor(this.getValor() - decremento);
            return true;
        }
        return false;
    }
    
    public void updateHistorico(SolicitaOperacao solicitaOperacao)
    {
        // DateTime to String
        String strDate = dateFormat.format(solicitaOperacao.getDataHora());  
        // Concat Logs
        logs_operacoes += "{IP: " + solicitaOperacao.getIp() + 
                        ", NomeThread: " + solicitaOperacao.getNomeThread() +
                        ", TipoThread: " + solicitaOperacao.getTipo() +
                        ", DataHora: " + strDate +
                        ", ValorAtualizado: " + this.valor +"},\n";
    }

    public String getLogs_operacoes() {
        return logs_operacoes;
    }
}