
package Aplicacao;

import Entidades.Comentario;
import Entidades.Post;
import java.util.Date;


public class Aplicacao {

    public static void main(String[] args) {
        Post post1 = new Post(new Date(), "Romênia, como eres deslumbrante", "Viagei para Romênia esse mês, e estou fascinado com a beleza desse país");
        post1.addComentario(new Comentario("UAUUUU!! É um páis incrível mesmo"));
        //  etccc
    }
    
}
