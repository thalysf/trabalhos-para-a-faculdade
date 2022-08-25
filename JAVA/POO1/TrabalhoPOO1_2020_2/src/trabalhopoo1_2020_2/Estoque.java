package trabalhopoo1_2020_2;

public class Estoque {
    private int madeira;
    private int aco;
    private int ferro;
    private int aluminio;
    private int ouro;
    private int cobre;
    private int chumbo;
    
    public Estoque(int madeira, int aco, int ferro, int aluminio, int ouro, int cobre, int chumbo) {
        this.madeira = madeira;
        this.aco = aco;
        this.ferro = ferro;
        this.aluminio = aluminio;
        this.ouro = ouro;
        this.cobre = cobre;
        this.chumbo = chumbo;
    }
    public Estoque()
    {
        this.madeira = 0;
        this.aco = 0;
        this.ferro = 0;
        this.aluminio = 0;
        this.ouro = 0;
        this.cobre = 0;
        this.chumbo = 0;
    }
    public int getMadeira() {
        return madeira;
    }

    public void setMadeira(int madeira) {
        this.madeira = madeira;
    }

    public int getAco() {
        return aco;
    }

    public void setAco(int aco) {
        this.aco = aco;
    }

    public int getFerro() {
        return ferro;
    }

    public void setFerro(int ferro) {
        this.ferro = ferro;
    }

    public int getAluminio() {
        return aluminio;
    }

    public void setAluminio(int aluminio) {
        this.aluminio = aluminio;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getCobre() {
        return cobre;
    }

    public void setCobre(int cobre) {
        this.cobre = cobre;
    }

    public int getChumbo() {
        return chumbo;
    }

    public void setChumbo(int chumbo) {
        this.chumbo = chumbo;
    }

    @Override
    public String toString() { // Apenas para necessidade de visualizar o estoque recuperado do arquivo "estoque.txt"
        return "Estoque{" + "madeira=" + madeira + ", aco=" + aco + ", ferro=" + ferro + ", aluminio=" + aluminio + ", ouro=" + ouro + ", cobre=" + cobre + ", chumbo=" + chumbo + '}';
    }
}
