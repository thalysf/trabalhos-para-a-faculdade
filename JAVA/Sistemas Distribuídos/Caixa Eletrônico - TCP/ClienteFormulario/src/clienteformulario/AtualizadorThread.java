package clienteformulario;

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

public class AtualizadorThread extends Thread {

    public MonitorHistorico monitorHistorico;
    public static String logs_operacoes;

    private int sleepTime;

    // Operação | 1 -> decremento, 2 -> incremento
    private int operacao = 1;
    private Socket socket = null;
    private InetAddress enderecoServidor = null;
    private SolicitaOperacao solicitaOperacao = new SolicitaOperacao();
    private Object resposta;

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private int PORTA_SERVICO = 2000;

    public AtualizadorThread(String nome, int operacao, int sleepTime) {
        super(nome);
        this.operacao = operacao;
        this.sleepTime = sleepTime;
        monitorHistorico = new MonitorHistorico();
    }

    @Override
    public void run() {
        monitorHistorico.setVisible(true);
        while (true) {
            // Preparando operação
            solicitaOperacao = new SolicitaOperacao();
            solicitaOperacao.setCodigo(operacao); // operação de decremento
            solicitaOperacao.setNomeThread(this.getName()); // recuperando nome do Thread
            solicitaOperacao.setTipo("ATUALIZADOR"); // recuperando nome do Thread
            solicitaOperacao.setDataHora(Calendar.getInstance().getTime()); // data e hora da operação

            // Recuperando endereço do servidor
            try {
                enderecoServidor = InetAddress.getLocalHost();

                // Recuperando IP do Host
                solicitaOperacao.setIp(enderecoServidor.getHostAddress());

            } catch (UnknownHostException ex) {
                Logger.getLogger(AtualizadorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Criando ponto de transporte para conectar com o servidor
            try {
                socket = new Socket(enderecoServidor, PORTA_SERVICO);
            } catch (IOException ex) {
                Logger.getLogger(AtualizadorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Criando Streams para entrada e saída de informações
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(AtualizadorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Enviar solicitação de operação
            try {
                objectOutputStream.writeObject(solicitaOperacao);
            } catch (IOException ex) {
                Logger.getLogger(AtualizadorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Aguarda resposta
            try {
                resposta = objectInputStream.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(AtualizadorThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Recuperando Histórico
            if (resposta != null) {
                logs_operacoes = (String) resposta;
                // Atualizando histórico no monitor
                monitorHistorico.updateLogs(logs_operacoes);
            }
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtualizadorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
