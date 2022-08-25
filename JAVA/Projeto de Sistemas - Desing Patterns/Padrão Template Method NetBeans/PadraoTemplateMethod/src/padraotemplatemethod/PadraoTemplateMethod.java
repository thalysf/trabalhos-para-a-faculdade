package padraotemplatemethod;

/**
 *
 * @authores thalys fabrete, alexandre borlini, vitor zani e pedro mariano.
 */
public class PadraoTemplateMethod {

    public static void main(String[] args) {
        Alunos alunos = new Alunos(ModoDeOrdenacao.NOME, CrescenteDecrescente.CRESCENTE);
        alunos.addAluno("Eduardo", 20, 84.5);
        alunos.addAluno("Ana", 32, 81.5);
        alunos.addAluno("Carlos", 36, 80.8);
        alunos.addAluno("Jose", 20, 72.9);
        alunos.addAluno("Maria", 20, 94.2);
        alunos.addAluno("Pedro", 26, 89.3);
        alunos.addAluno("Erica", 29, 68.9);
        alunos.addAluno("Mariana", 40, 90.4);
        alunos.addAluno("Jeremias", 50, 75.0);
        alunos.addAluno("Elisa", 22, 77.1);
        alunos.printAlunos();
        alunos.setModoDeOrdenacao(ModoDeOrdenacao.IDADE, CrescenteDecrescente.CRESCENTE);
        alunos.printAlunos();
        alunos.setModoDeOrdenacao(ModoDeOrdenacao.NOTA, CrescenteDecrescente.CRESCENTE);
        alunos.printAlunos();
        
        
        alunos.setModoDeOrdenacao(ModoDeOrdenacao.NOME, CrescenteDecrescente.DECRESCENTE);
        alunos.printAlunos();
        alunos.setModoDeOrdenacao(ModoDeOrdenacao.IDADE, CrescenteDecrescente.DECRESCENTE);
        alunos.printAlunos();
        alunos.setModoDeOrdenacao(ModoDeOrdenacao.NOTA, CrescenteDecrescente.DECRESCENTE);
        alunos.printAlunos();
    }
    
}
