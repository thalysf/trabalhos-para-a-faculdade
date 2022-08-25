package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private Date momento;
    private String titulo;
    private String conteudo;
    private List<Comentario> comentario = new ArrayList<>();

    public Post(Date momento, String titulo, String conteudo) {
        this.momento = momento;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }
    public void addComentario(Comentario comentario)
    {
        this.comentario.add(comentario);
    }
    public void removerComentario(Comentario comentario)
    {
        this.comentario.remove(comentario);
    }
    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }
    
}
