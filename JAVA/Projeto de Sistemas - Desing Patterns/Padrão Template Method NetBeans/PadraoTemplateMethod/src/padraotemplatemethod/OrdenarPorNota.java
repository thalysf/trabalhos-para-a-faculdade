package padraotemplatemethod;

public class OrdenarPorNota extends OrdenadorTemplate {
    @Override
    public int isFirst(Aluno aluno01, Aluno aluno02) {
        return aluno01.getNota().compareTo(aluno02.getNota());
    }
}
