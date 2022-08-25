package Ex04;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] valores;
        valores = new int[2];
        lerValores(valores);
        int x = valores[0];
        int y = valores[1];
        
        
        System.out.println(Potencia.Potencia(x, y));
    }
     public static int lerValores(int[] valor) {
        Scanner ler;
        ler = new Scanner(System.in);
        System.out.print("Insira o valor da base: ");
        valor[0] = ler.nextInt();
        System.out.print("Insira o valor da potência: ");
        valor[1] = ler.nextInt();

        return 0;
    }
}
