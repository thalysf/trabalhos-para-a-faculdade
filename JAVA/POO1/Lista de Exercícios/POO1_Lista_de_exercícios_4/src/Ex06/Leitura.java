package Ex06;
import java.util.Scanner;


public class Leitura {

    public static int ler(String mensagem) {
        Scanner ler;
        ler = new Scanner(System.in);
        System.out.print(mensagem);
        return ler.nextInt();
    }
    
}
