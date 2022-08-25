package padraotemplatemethod;

import java.util.ArrayList;
import java.util.List;

public abstract class OrdenadorTemplate {

    public abstract int isFirst(Aluno aluno01, Aluno aluno02);

    protected List<Aluno> ordenarAlunos(List<Aluno> alunos, CrescenteDecrescente crescenteDecrescente) {
        List<Aluno> alunosOrdenados = new ArrayList<>(alunos);
        
        int crescDecres = crescenteDecrescente.equals(CrescenteDecrescente.CRESCENTE)? 1: -1;
        alunosOrdenados.sort((a1, a2) -> {
            return isFirst(a1, a2) * crescDecres;
        });
        return alunosOrdenados;
    }
}
