package leituradearquivos;
import java.io.FileNotFoundException;
import java.util.Formatter;


public class Escrever {
    public static void escrever(String caminho, String conteudo)
    {
        try{
            Formatter formater = new Formatter(caminho);
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
