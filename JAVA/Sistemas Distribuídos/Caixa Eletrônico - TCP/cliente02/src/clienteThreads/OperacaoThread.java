/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteThreads;

import commons.RespostaOperacao;
import commons.SolicitaOperacao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thalys
 */
public class OperacaoThread extends Thread{
    private int sleepTime;
    private String tipoThread;
    // Operação | 1 -> decremento, 2 -> incremento
    private int operacao = 1;
    private Socket socket = null;
    private InetAddress enderecoServidor = null;
    private SolicitaOperacao solicitaOperacao = new SolicitaOperacao();
    private Object resposta;

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private int PORTA_SERVICO = 2000;

    public OperacaoThread(String nome, int operacao, int sleepTime, String tipoThread) {
        super(nome);
        this.operacao = operacao;
        this.sleepTime = sleepTime;
        this.tipoThread = tipoThread;
    }

    
    @Override
    public void run() {
        while (true) {
            // Preparando operação
            solicitaOperacao = new SolicitaOperacao();
            solicitaOperacao.setCodigo(operacao); // operação de decremento
            solicitaOperacao.setTipo(tipoThread); // tipo do Thread
            solicitaOperacao.setNomeThread(this.getName()); // recuperando nome do Thread
            solicitaOperacao.setDataHora(Calendar.getInstance().getTime()); // data e hora da operação
            
            
            // Recuperando endereço do servidor
            try {
                enderecoServidor = InetAddress.getLocalHost();
                
                // Recuperando IP do Host
                solicitaOperacao.setIp(enderecoServidor.getHostAddress());
                
            } catch (UnknownHostException ex) {
                Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Criando ponto de transporte para conectar com o servidor
            try {
                socket = new Socket(enderecoServidor, PORTA_SERVICO);
            } catch (IOException ex) {
                Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Criando Streams para entrada e saída de informações
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Enviar solicitação de operação
            try {
                objectOutputStream.writeObject(solicitaOperacao);
            } catch (IOException ex) {
                Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Aguarda resposta
            try {
                resposta = objectInputStream.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // fechando ponto de transporte
//        try{
//            socket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
            // Printando informações se forem instância de RespostaOperacao
            if (resposta instanceof RespostaOperacao) {
                System.out.println("Resposta: ");
                System.out.println("Sucesso? " + ((RespostaOperacao) resposta).isSucesso());
                System.out.println("Valor Atualizado: " + ((RespostaOperacao) resposta).getValorAtualizado());
            }
            try
            {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
