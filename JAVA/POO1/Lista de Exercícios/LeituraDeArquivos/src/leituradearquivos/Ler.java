package leituradearquivos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Ler {
    public static void ler(String caminho)
    {
        try{
            FileInputStream file = new FileInputStream(caminho);
            Scanner scan = new Scanner(file);
            String conteudo = "";
            
            while(scan.hasNext())
            {
                conteudo = conteudo + scan.nextLine() + "\n";
            }
            System.out.println("\tConteúdo do arquivo: \n");
            System.out.println("---------------------------------------");
            System.out.print(conteudo);
            System.out.println("---------------------------------------");
        }
        catch(FileNotFoundException erro)
        {
            System.out.println("Arquivo não encontrado ...");
        }
    }
}
