package Ex06;

import java.io.IOException;
import java.util.Random;

public class Craps {

    static Random aleatorio = new Random();

    public static int lancarDado() {
        return aleatorio.nextInt(6) + 1;
    }

    public static int jogarDados() throws IOException {
        int d1, d2, soma;
        System.out.println("Pressione <enter> para jogar os dados");
        System.in.read();
        d1 = lancarDado();
        d2 = lancarDado();
        soma = d1 + d2;
        System.out.println("Dado 1: " + d1);
        System.out.println("Dado 2: " + d2);
        System.out.println("SOMA: " + soma);
        System.out.println("---------------------");
        return soma;
    }

    public static void main(String[] args) throws IOException {
        int carteira = 100, aposta = 0;
        int op = 0;
        System.out.println("- Sua carteira: R$ " + carteira + ",00 - ");
        aposta = Leitura.ler("Informe o valor que deseja apostar: ");
        do {
            boolean vitoria = partida();
            if (vitoria) {
                System.out.println("Parabéns, você ganhou :)");
                carteira += aposta * 2;
            } else {
                System.out.println("Infelizmente você perdeu :(");
                carteira = carteira - aposta;
            }
            System.out.println("----------------------");
            System.out.println("- Sua carteira: R$ " + carteira + ",00 - ");
            if (carteira > 0) {
                op = Leitura.ler("Desejas continuar apostando? [0] - Não  [1] - Sim: ");
            }
            if (op != 0) {
                do {
                    aposta = Leitura.ler("Informe o valor que deseja apostar: ");
                } while (aposta > carteira || aposta < 0);
            }

        } while (op != 0 && carteira > 0);
        System.out.println("Obrigado por jogar com a gente ;)");
    }

    public static boolean partida() throws IOException {
        int soma = 0, rodadas = 0, ponto = 0;
        boolean encerrar = false, vitoria = false;
        while (!encerrar) {
            soma = jogarDados();
            if (rodadas == 0) {
                if (soma == 7 || soma == 11) {
                    vitoria = true;
                    encerrar = true;
                } else if (soma == 2 || soma == 3 || soma == 12) {
                    encerrar = true;
                }
            } else if (rodadas > 0) {
                if (soma == ponto) {
                    vitoria = true;
                    encerrar = true;

                } else if (soma == 7) {
                    encerrar = true;
                }
            }
            rodadas++;
            if (rodadas == 1) {
                ponto = soma;
            }
        }
        return vitoria;
    }
}
