package poo1_lista_de_exercícios_1;
import java.io.*;
/**
 *
 * @author thaly
 */
public class Ex10 {
     public static void main(String[] args) throws IOException {
        int cigarrosDia, anosFumando, qtdCigarrosFumados, cigarrosMaximosDia = 144, diasPerdidos;
        BufferedReader dado; 
        try
        {
            System.out.println("- Cigarros Fumados -");
            dado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite a quantidade cigarros que você fuma por dia: ");
            cigarrosDia = Integer.parseInt(dado.readLine());
            System.out.print("Digite à quantos anos você fuma: ");
            anosFumando = Integer.parseInt(dado.readLine());
            // Vou considerar que um ano tem 360 dias
            qtdCigarrosFumados = cigarrosDia * (anosFumando * 360);
            diasPerdidos = (qtdCigarrosFumados/cigarrosMaximosDia);
            
            System.out.println("Você perdeu " + diasPerdidos + " dias da sua vida");
            
        } 
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }     
    
     }
}