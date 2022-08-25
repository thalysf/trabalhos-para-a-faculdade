package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usado extends Produto{
    private Date dataDeManofatura;

    public Usado(String nome, Double preco, Date dataDeManofatura) {
        super(nome, preco);
        this.dataDeManofatura = dataDeManofatura;
    }
    
    @Override
    public String etiquetaDePreco(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return getNome() + " (usado) " + getPreco() + " (Data da Manofatura: " + dateFormat.format(dataDeManofatura) + ")";
    }
}
