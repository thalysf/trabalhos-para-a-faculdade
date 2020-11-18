package Ex05;

public class Main {

    public static void main(String[] args) {

        int op = 0, x = 0, y = 0;
        System.out.println("|Opções: [1] sub - [2] add - [3] multi - [4] div - [5] pow  - [0] encerrar|");
        do {
            do {
                op = Leitura.ler("Digite a op desejada: ");
            } while (op < 0 || op > 5);
            if (op != 0)
            {
                x = Leitura.ler("Digite o valor de x: ");
                y = Leitura.ler("Digite o valor de y: ");
            }

            switch (op) {
                case 1:
                    System.out.println(Funcoes_Matematicas.subtracao(x, y));
                    break;
                case 2:
                    System.out.println(Funcoes_Matematicas.adicao(x, y));
                    break;
                case 3:
                    System.out.println(Funcoes_Matematicas.multiplica(x, y));
                    break;
                case 4:
                    System.out.println(Funcoes_Matematicas.divisao(x, y));
                    break;
                case 5:
                    System.out.println(Funcoes_Matematicas.potencia(x, y));
                    break;
                default:
                    System.out.println("Programa encerrado ... ");
            }
        } while (op != 0);

    }
}
