
package padrão.singleton;

import sessao.*;

/**
 *
 * @authores thalys, vitor zani, alexandre borlini, pedro mariano
 */
public class PadrãoSingleton {

    
    public static void main(String[] args) {
        Usuario usuario01 = new Usuario("André", 20);
        Usuario usuario02 = new Usuario("João", 22);
        Usuario usuario03 = new Usuario("Ana", 28);
        
        SessaoUsuario sessao = SessaoUsuario.getSessaoUsuario();
        sessao.infoSessao();
        
        sessao.updateUsuarioSessao(usuario01);
        
        sessao.infoSessao();
        sessao.incluirHobby("Nadar");
        sessao.incluirHobby("Jogar bola");
        sessao.infoSessao();
        
        sessao.updateUsuarioSessao(usuario02);
        sessao.infoSessao();
        
        sessao.incluirHobby("Jogar videogame");
        sessao.infoSessao();
        
        sessao.updateUsuarioSessao(usuario03);
        sessao.incluirHobby("Ler livros");
        sessao.infoSessao();
        sessao.retirarHobby("Nadar");
        sessao.infoSessao();
    }
    
}
