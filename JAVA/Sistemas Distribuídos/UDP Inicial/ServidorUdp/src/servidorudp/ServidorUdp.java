/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;

import java.net.*;
import java.time.LocalTime;

/**
 *
 * @author 2019122760095
 */
public class ServidorUdp {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
                String mensagem = new String (request.getData());
                if(!mensagem.trim().equalsIgnoreCase("***ATUALIZA***"))
                {
                   // System.out.println("INSERIDO: " + mensagem + " TEMPO: " + LocalTime.now());
                    bd.insere(mensagem);
                }
                
                String resposta = bd.le();
                byte[] todaMsg = resposta.getBytes();
                
                // Enviando resposta
                DatagramPacket reply = new DatagramPacket(todaMsg, todaMsg.length, request.getAddress(), request.getPort());
                aSocket.send(reply);
            } 
        }
        catch(Exception e)
        {
            System.out.println("deu ruim");
        }
        finally{
            if(aSocket != null)
                aSocket.close();
        }
        
    }
    
}
