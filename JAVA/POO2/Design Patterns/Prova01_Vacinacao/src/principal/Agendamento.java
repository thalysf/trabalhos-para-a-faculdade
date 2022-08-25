package principal;

public class Agendamento {

    private String nome;
    private String CPF;
    private String tipoVacina;
    private String nomeVacina;
    private String data1Dose;
    private String data2Dose;

    public Agendamento(String nome, String CPF, String tipoVacina, String nomeVacina, String data1Dose, String data2Dose) {
        this.nome = nome;
        this.CPF = CPF;
        this.tipoVacina = tipoVacina;
        this.nomeVacina = nomeVacina;
        this.data1Dose = data1Dose;
        this.data2Dose = data2Dose;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(String tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getData1Dose() {
        return data1Dose;
    }

    public void setData1Dose(String data1Dose) {
        this.data1Dose = data1Dose;
    }

    public String getData2Dose() {
        return data2Dose;
    }

    public void setData2Dose(String data2Dose) {
        this.data2Dose = data2Dose;
    }

     
}
