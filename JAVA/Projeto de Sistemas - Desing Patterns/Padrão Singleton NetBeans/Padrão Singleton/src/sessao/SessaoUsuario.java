package sessao;

import java.util.ArrayList;
import java.util.List;

public class SessaoUsuario {
    private Usuario usuario;
    private List<String> hobbies;
    private static SessaoUsuario sessaoUsuario;

    public static SessaoUsuario getSessaoUsuario() {
        if(sessaoUsuario == null)
        {
            sessaoUsuario = new SessaoUsuario();
        }
        return sessaoUsuario;
    }
    private SessaoUsuario()
    {
        usuario = new Usuario();
        hobbies = new ArrayList<>();
    }

    public void updateUsuarioSessao(Usuario usuario) {
       this.usuario = usuario;
    }
    
    public void incluirHobby(String hobby)
    {
        hobbies.add(hobby);
    }
    public void retirarHobby(String hobby)
    {
        hobbies.remove(hobbies.indexOf(hobby));
    }
    
    public void infoSessao()
    {
        if(this.usuario.getNome() == null && this.usuario.getIdade() == null)
        {
            System.out.println("Sessão criada, mas nenhum usuário atribuído a ela."); 
        }
        else if(hobbies.isEmpty()){
            System.out.println("Usuário: "+ usuario.getNome() + ", Idade: " + usuario.getIdade() + "anos ... sem hobbies.");
        }
        else{
            System.out.println("Usuário: "+ usuario.getNome() + ", Idade: " + usuario.getIdade() + " anos");
            listarHobbies();
        }
        System.out.println("\n");
    }
    private void listarHobbies()
    {
        System.out.println("Hobbies: ");
        hobbies.forEach(System.out::println);
    }
}
