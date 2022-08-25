package clienteudp;

import java.net.*;
import java.io.*;


public class MeuCliente {
    private String nomeDNS;
    private int serverPort;
    private byte[] meuIP;
    private String usuario;
    
    public MeuCliente(){
        
        try{
            InetAddress endereco = InetAddress.getLocalHost();
            nomeDNS = endereco.getHostName();
            meuIP = endereco.getAddress();
        } catch (UnknownHostException e){
            System.out.println("Host desconhecido: " + e.getMessage());
        }
        
        serverPort = 6789;
    }
    
    
    public String enviaMensagem(String mensagem){
        DatagramSocket aSocket = null;
        String resposta = "";
        
        try{
            aSocket = new DatagramSocket();
            byte []m = mensagem.getBytes();
            InetAddress aHost = InetAddress.getByName(nomeDNS);
            
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            
            aSocket.send(request);
            
            byte[] buffer = new byte[600];
            
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            
            aSocket.receive(reply);
            
            resposta = new String(reply.getData());
            
            resposta = resposta + "\n";
        } catch (SocketException e){
            System.out.println("Socket: e" + e.getMessage());
        } catch (IOException e){
            System.out.println("Input Output: " + e.getMessage());
        } finally {
            if(aSocket != null){
                aSocket.close();
            }
        }
        
        return resposta;
    }
    
    
    public MeuCliente(String nomeDNSServidor){
        nomeDNS = "DESKTOP-FCVVTA7";
        
        meuIP = null;
        serverPort = 6789;
    }
    
    public String getNomeDNS(){
        return nomeDNS;
    }
    
    public int getServerPort(){
        return serverPort;
    }
    
    public String getMeuIp(){
        String s = new String(meuIP);
        return s;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
