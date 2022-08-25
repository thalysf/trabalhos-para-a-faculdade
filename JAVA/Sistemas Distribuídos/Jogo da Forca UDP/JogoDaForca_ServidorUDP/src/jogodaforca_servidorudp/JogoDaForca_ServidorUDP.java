package jogodaforca_servidorudp;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class JogoDaForca_ServidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variaveis game
        String resultGame = null;
        String jogadorGame = null;
        String palavraGame = null;
        String historico = null;
        int i = 0;
        
        // variaveis servidor
        String retorno = null;
        DatagramSocket aSocket = null;
        BaseDeDados bd = new BaseDeDados();
        
        
        try{
            aSocket = new DatagramSocket(6789);
            
            while(true){
                // Preparando para receber msg
                byte[] buffer = new byte[600];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                // Processando mensagem
                String mensagem = new String (request.getData(), StandardCharsets.UTF_8).replaceAll("\\P{Print}","");
         
                if(mensagem.charAt(0) == '#')
                {
                    // Obtendo usuário da vez
                    String jogador = mensagem.replaceAll("#", "");
                    
                    // obtendo palavra para o jogo da forca
                    String palavra = bd.obterPalavra(jogador);
                    bd.insereJogador(jogador, palavra);
                    retorno = palavra;
                }
                else if(mensagem.contains("_DERROTAS_"))
                {
                    String jogadorHistorico = mensagem.replaceAll("_DERROTAS_", "");
                    historico  = bd.getHistoricoJogadorErros(jogadorHistorico);

                    retorno = historico;
                }
                else if(mensagem.contains("_VITORIAS_"))
                {
                    String jogadorHistorico = mensagem.replaceAll("_VITORIAS_", "");
                    historico =  bd.getHistoricoJogadorAcertos(jogadorHistorico);
                    
                    retorno = historico;
                }
                else if(mensagem.charAt(0) == '%')
                {
                    String placar = bd.obterPlacar();
                    retorno = placar;
                }
                else
                {
                    switch (i) {
                        case 1:
                            resultGame = mensagem;
                            break;
                        case 2:
                            jogadorGame = mensagem;
                            break;
                        case 3:
                            palavraGame = mensagem;
                            bd.atualizaHistorico(jogadorGame, palavraGame, resultGame);
                            break;
                        default:
                            i = 0;
                    }
                    i++;
                }
                
                  byte[] todaMsg = retorno.getBytes();
                    
                // Enviando resposta
                DatagramPacket reply = new DatagramPacket(todaMsg, todaMsg.length, request.getAddress(), request.getPort());
                aSocket.send(reply);
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if(aSocket != null)
                aSocket.close();
        }
    }
    
}
