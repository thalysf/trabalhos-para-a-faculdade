/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca_clienteudp;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class JogoDaForca_ClienteUDP {

    //Esquema de mensagens:
    // # -> solicita palavra + cadastro de jogador
    // $ -> envia resultado de jogo (vitoria ou derrota) + jogador + palavra
    // % -> solicita placar -> relacao de jogadores e suas vitorias
    // _VITORIAS_ -> solicita historico -> solicita historico de vitorias de um determinado jogador
    // _DERROTAS_ -> solicita historico -> solicita historico de derrotas de um determinado jogador
    // Vars do Game
    private String jogador;
    private String resultadoJogo = null;
    private String palavra;
    private String mascara;
    private String letrasTentadas = "";
    private int chances = 6;
    List<String> palavrasAcertadas = new ArrayList<>();
    List<String> palavrasErradas = new ArrayList<>();
    private String placar;

    // Vars do Cliente
    private String nomeDNS;
    private int serverPort;
    private byte[] meuIP;

    public JogoDaForca_ClienteUDP() {

        try {
            InetAddress endereco = InetAddress.getLocalHost();
            nomeDNS = endereco.getHostName();
            meuIP = endereco.getAddress();
        } catch (UnknownHostException e) {
            System.out.println("Host desconhecido: " + e.getMessage());
        }

        serverPort = 6789;
    }

    public void solicitarMascara() {
        palavra = enviaMensagem("#" + jogador);
        mascara = palavra.replaceAll("[a-zA-Z]", "_");

        // config de reset de game
        chances = 6;
        letrasTentadas = "";
    }

    public void atualizaPlacar(String resultado) {
        String mensagemFormatada;
        String codigo = "$";

        enviaMensagem(codigo);
        enviaMensagem(resultado);
        enviaMensagem(jogador);
        enviaMensagem(palavra);
    }

    public void chutarLetra(char letra) {
        boolean acerto = false;
        if (!letrasTentadas.contains(String.valueOf(letra))) {
            for (int i = 0; i < palavra.length(); i++) {
                if (String.valueOf(palavra.charAt(i)).equalsIgnoreCase(String.valueOf(letra))) {
                    StringBuilder strbuilder = new StringBuilder(mascara);
                    strbuilder.setCharAt(i, letra);
                    this.mascara = strbuilder.toString();
                    acerto = true;
                }
            }
            if (!acerto) {
                chances--;
            }
            if (!letrasTentadas.contains(String.valueOf(letra))) {
                letrasTentadas += letra + ", ";
            }
        }
    }

    public void solicitarHistoricoJogador() {
        palavrasAcertadas = new ArrayList<>();
        palavrasErradas = new ArrayList<>();
        String historicoVitorias = enviaMensagem("_VITORIAS_" + jogador);
        while (true) {
            int end = historicoVitorias.indexOf("_");
            if (historicoVitorias.equals("") || end == -1) {
                break;
            }

            String palavra = historicoVitorias.substring(0, end);
            historicoVitorias = historicoVitorias.replaceFirst(palavra + "_", "");
            palavrasAcertadas.add(palavra);
        }

        String historicoDerrotas = enviaMensagem("_DERROTAS_" + jogador);
        while (true) {
            int end = historicoDerrotas.indexOf("_");
            if (historicoDerrotas.equals("") || end == -1) {
                break;
            }

            String palavra = historicoDerrotas.substring(0, end);
            historicoDerrotas = historicoDerrotas.replaceFirst(palavra + "_", "");
            palavrasErradas.add(palavra);
        }
    }

    public void obterPlacar() {
        placar = enviaMensagem("%");

        Map<String, Integer> placarTemporario = new LinkedHashMap<>();

        while (true) {
            int end = placar.indexOf("_");
            if (placar.equals("") || end == -1) {
                break;
            }

            String jogador = placar.substring(0, end);
            placar = placar.replaceFirst(jogador + "_", "");

            end = placar.indexOf("_");
            Integer acertos = Integer.valueOf(placar.substring(0, end));
            placar = placar.replaceFirst(acertos + "_", "");
            placarTemporario.put(jogador, acertos);
        }
        Map<String, Integer> sorted = placarTemporario
        .entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(
            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new));

        sorted.forEach((jogador, acertos) -> {
            placar += "|" + jogador.toUpperCase() + ": " + acertos + "\n";
        });
    }

    public String enviaMensagem(String mensagem) {
        DatagramSocket aSocket = null;
        String resposta = new String("");

        try {
            aSocket = new DatagramSocket();
            byte[] m = mensagem.getBytes();
            InetAddress aHost = InetAddress.getByName(nomeDNS);

            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);

            aSocket.send(request);

            byte[] buffer = new byte[600];

            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

            aSocket.receive(reply);

            resposta = new String(reply.getData());
        } catch (SocketException e) {
            System.out.println("Socket: e" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input Output: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }

        return resposta;
    }

    public JogoDaForca_ClienteUDP(String nomeDNSServidor) {
        nomeDNS = "col-8288-li05"; // inserir o nome(DNS) do SEU computador

        meuIP = null;
        serverPort = 6789;
    }

    public String getNomeDNS() {
        return nomeDNS;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getMeuIp() {
        String s = new String(meuIP);
        return s;
    }

    public String getPalavra() {
        return this.palavra;
    }

    public String getMascara() {
        return this.mascara.toUpperCase();
    }

    public String getResultadoJogo() {
        return resultadoJogo;
    }

    public void setResultadoJogo(String resultadoJogo) {
        this.resultadoJogo = resultadoJogo;
    }

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public String getLetrasTentadas() {
        return letrasTentadas.toUpperCase();
    }

    public void setLetrasTentadas(String letrasTentadas) {
        this.letrasTentadas = letrasTentadas;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public List<String> getPalavrasAcertadas() {
        return palavrasAcertadas;
    }

    public void setPalavrasAcertadas(List<String> palavrasAcertadas) {
        this.palavrasAcertadas = palavrasAcertadas;
    }

    public List<String> getPalavrasErradas() {
        return palavrasErradas;
    }

    public void setPalavrasErradas(List<String> palavrasErradas) {
        this.palavrasErradas = palavrasErradas;
    }

    public String getPlacar() {
        return placar;
    }

    public void setPlacar(String placar) {
        this.placar = placar;
    }
}
