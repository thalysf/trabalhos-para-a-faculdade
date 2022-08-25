package padraotemplatemethod;

public class OrdenarPorIdade extends OrdenadorTemplate {
    @Override
    public int isFirst(Aluno aluno01, Aluno aluno02) {
        return aluno01.getIdade().compareTo(aluno02.getIdade());
    }
}
