package ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02 {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios.add(new Funcionario(10, "Carlos", 1250.50));
        int id1 = 10;
        // Impede repetição de id
        Funcionario res = funcionarios.stream().filter(funcinario -> funcinario.getID() == id1).findFirst().orElse(null);
        System.out.println(res.getID());
    }
    
}
