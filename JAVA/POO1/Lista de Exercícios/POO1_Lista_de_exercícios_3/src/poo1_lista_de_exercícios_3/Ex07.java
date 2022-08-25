package poo1_lista_de_exercícios_3;
import java.io.*;
import java.util.Arrays;
public class Ex07 {

    public static void main(String[] args) throws IOException {
        
        int alt, peso;
        int[] maisAlto, maisBaixo, maisMagro, maisGordo;
        maisAlto = new int[2];
        maisBaixo = new int[2];
        maisMagro = new int[2];
        maisGordo = new int[2];
        
        int cod, aux = 0;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Digite o código: ");
                cod = Integer.parseInt(dado.readLine());
                System.out.print("Digite o peso: ");
                alt = Integer.parseInt(dado.readLine());
                System.out.print("Digite a altura: ");
                peso = Integer.parseInt(dado.readLine());
                if(aux == 0 && cod != 0)
                {
                    aux = 1;
                    maisAlto[0] = alt; maisAlto[1] = cod;
                    maisBaixo[0] = alt; maisBaixo[1] = cod;
                    maisMagro[0] = peso; maisMagro[1] = cod;
                    maisGordo[0] = peso; maisGordo[1] = cod;
                }
                if(aux != 0 && cod != 0)
                {
                    if(alt >  maisAlto[0])
                    {
                        maisAlto[0] = alt; maisAlto[1] = cod;
                    }
                    if(alt < maisBaixo[0])
                    {
                        maisBaixo[0] = alt; maisBaixo[1] = cod;
                    }
                    if(peso > maisGordo[0])
                    {
                        maisGordo[0] = peso; maisGordo[1] = cod;
                    }
                    if(peso < maisMagro[0])
                    {
                         maisMagro[0] = peso; maisMagro[1] = cod;
                    }
                }
                
            }while(cod != 0);
           
           
            System.out.println(Arrays.toString(maisAlto));
            System.out.println(Arrays.toString(maisBaixo));
            System.out.println(Arrays.toString(maisGordo));
            System.out.println(Arrays.toString(maisMagro));
            
            
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}