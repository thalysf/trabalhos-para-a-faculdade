package padraocomposite;

import java.util.ArrayList;
import java.util.List;


public class Fulano extends Humano{
    private List<Humano> filhos;

    public Fulano(String nome, Integer idade, SexoEnum sexo) {
        super(nome, idade, sexo);
        this.filhos = new ArrayList<>();
    }
    @Override
    public void addFilho(Humano filho) {
        this.filhos.add(filho);
    }
    @Override
    public void exibirInfoHumano() {
        String temFilhos = this.filhos.isEmpty()? "": " filhos: ";
        System.out.println(String.format("%s - %d anos %s", this.getNome(), this.getIdade(), this.getSexo().getLabel() + temFilhos));
        filhos.stream().forEach((f) -> { f.exibirInfoHumano();});
        System.out.println("...");
    }
}
