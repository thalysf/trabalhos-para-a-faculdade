
package leituradearquivos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
public class Append {
    public static void append(String caminho, String conteudo){
    try{
            FileInputStream file = new FileInputStream(caminho);
            Scanner scan = new Scanner(file);
            String conteudo1 = "";
            
            while(scan.hasNext())
            {
                conteudo1 = conteudo1 + scan.nextLine() + "\n";
            }
            Formatter formater = new Formatter(caminho); // quando o objeto formater é instanciado, o conteúdo do arquivo é totalmente apagado
            System.out.println("Content" + conteudo1);
            formater.format(conteudo1);
            formater.format(conteudo);
            formater.close();
            Ler.ler(caminho);
        }
        catch(FileNotFoundException erro)
        {
            System.out.println("Arquivo não encontrado ...");
        }
    }
}
