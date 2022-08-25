package jogodaforca_servidorudp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BaseDeDados {

    // estruturas de dados para armazenar informações estáticas
    List<String> palavras = new ArrayList<>(Arrays.asList(
            "NOVA YORK", "JOAO VITOR", "RESCEM-CASADO", "AZUL MARINHO", "PEIXE AGULHA",
            "FINAL DE SEMANA", "VIDEOGAME", "ABACATE",
            "DIVORCIADO", "CHOCOLATE"
    ));

    List<String> jogadores = new ArrayList<>();
    Map<String, List<String>> jogadorPalavraAtivos = new HashMap<>();

    Map<String, List<String>> jogadorHistoricoVitorias = new HashMap<>();
    Map<String, List<String>> jogadorHistoricoDerrotas = new HashMap<>();

    //Métodos de acesso e formatação de retorno dos dados
    public void insereJogador(String jogador, String palavra) {
        List<String> palavras = jogadorPalavraAtivos.get(jogador);
        if(palavras == null){
            palavras = new ArrayList<>();
        }
        palavras.add(palavra);
        
        jogadorPalavraAtivos.put(jogador, palavras);
        if(!jogadores.contains(jogador))
            jogadores.add(jogador);
    }

    public void atualizaHistorico(String jogador, String palavra, String resultado) {
        if (resultado.equalsIgnoreCase("VITORIA")) {
            List<String> atual = jogadorHistoricoVitorias.get(jogador);
            if (atual == null) {
                atual = new ArrayList<>();
            }
            atual.add(palavra);
            jogadorHistoricoVitorias.put(jogador, atual);
        } else if (resultado.equalsIgnoreCase("DERROTA")) {
            List<String> atual = jogadorHistoricoDerrotas.get(jogador);
            if (atual == null) {
                atual = new ArrayList<>();
            }
            atual.add(palavra);
            jogadorHistoricoDerrotas.put(jogador, atual);
        }
    }

    public String obterPalavra(String jogador) {
        String palavra = null;

        while(true){
            palavra = palavras.get(new Random().nextInt(palavras.size()));
            List<String> palavrasJogador = jogadorPalavraAtivos.get(jogador);
            if(palavrasJogador == null) break;
            else if(palavrasJogador.size() == palavras.size()) {
                palavrasJogador = new ArrayList<>();
                jogadorPalavraAtivos.put(jogador, palavrasJogador);
            }
            else if(!palavrasJogador.contains(palavra)) break;
        }

        return palavra;
    }

    public String getHistoricoJogadorAcertos(String jogadorHistorico) {
        String allAcertos = "";
        if (jogadorHistoricoVitorias.get(jogadorHistorico) != null) {
            for (String palavra : jogadorHistoricoVitorias.get(jogadorHistorico)) {
                allAcertos += palavra + "_";
            }
            return allAcertos;
        }
        return "";
    }

    public String getHistoricoJogadorErros(String jogadorHistorico) {
        String allErros = "";
        if (jogadorHistoricoDerrotas.get(jogadorHistorico) != null) {
            jogadorHistoricoDerrotas.get(jogadorHistorico).forEach(System.out::println);
            for (String palavra : jogadorHistoricoDerrotas.get(jogadorHistorico)) {
                allErros += palavra + "_";
            }
            return allErros;
        }
        return "";
    }

    public String obterPlacar() {
        String placarFormatado = "";
        String jogador = "";
        Integer acertos = 0;
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println("SIZE" + jogadores.size());
            if (jogadores.get(i) != null) {
                jogador = jogadores.get(i);
                if(jogadorHistoricoVitorias.get(jogador) == null)
                    acertos = 0;
                else
                    acertos = jogadorHistoricoVitorias.get(jogador).size();
                if (acertos != null) {
                         placarFormatado += jogador + "_" + acertos + "_";
                }
            }
        }
        System.out.println("NO SERVIDOR: " + placarFormatado);
        return placarFormatado;
    }
}
