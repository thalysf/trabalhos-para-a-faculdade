package servidorTcp;

import commons.RespostaOperacao;
import commons.SolicitaOperacao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorTCP {

    private static BaseDados baseDados = new BaseDados();
    private static final int TAMANHO_MAXIMO = 100000;
    private static final int PORTA_SERVICO = 2000;

    public static void main(String[] args) throws IOException {
        // Estabelecendo valor inicial para a BD
        baseDados.setValor(35);

        ServerSocket serverSocket = null;
        Socket socket = null;

        SolicitaOperacao solicitaOperacao = null;
        Object resposta;

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        // Criar ponto de transporte para conexão
        try {
            serverSocket = new ServerSocket(PORTA_SERVICO);
        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Servindo constantemente
        while (true) {
            // Esperando conexão
            try {
                socket = serverSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Criando streams de saída e entrada;
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Aguardar recebimento da solicitação
            try {
                solicitaOperacao = (SolicitaOperacao) objectInputStream.readObject();
            } catch (Exception ex) {
                Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Executando operação solicitado
            switch (solicitaOperacao.getCodigo()) {
                case 1:
                    System.out.println("Decremento");
                    baseDados.decrementar(1);
                    break;
                case 2:
                    System.out.println("Incremento");
                    baseDados.incrementar(1);
                    break;
                case 3:
                    System.out.println("Recuperando histórico");
                    break;
            }
            
            // Operações de incremento e decremento
            if (solicitaOperacao.getCodigo() != 3) {
                // Atulizando histórico
                baseDados.updateHistorico(solicitaOperacao);
                
                // Criando objeto contendo resposta
                resposta = new RespostaOperacao();

                // providenciando resposta conforme operação solicitada
                ((RespostaOperacao) resposta).setSucesso(true);
                ((RespostaOperacao) resposta).setValorAtualizado(baseDados.getValor());

                // Enviando objeto de resposta
                try {
                    objectOutputStream.writeObject(resposta);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else // Operação de recuperar histórico
            {
                // Enviando histórico solicitado como resposta
                try {
                    objectOutputStream.writeObject(baseDados.getLogs_operacoes());
                } catch (IOException ex) {
                    Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}