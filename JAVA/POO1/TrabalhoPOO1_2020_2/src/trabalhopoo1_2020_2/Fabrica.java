package trabalhopoo1_2020_2;

public class Fabrica { 

    public static void produz(Estoque estoque, String item, int qtd, Carro carro) throws FaltouInsumoException{
        switch (item) {
            case "Madeira":
                    if(estoque.getMadeira()- qtd >= 0) estoque.setMadeira(estoque.getMadeira() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Madeira");
                    break;
            case "Ferro":
                    if(estoque.getFerro() - qtd >= 0) estoque.setFerro(estoque.getFerro() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Ferro");
                    break;
            case "Aço":
                    if(estoque.getAco() - qtd >= 0) estoque.setAco(estoque.getAco() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Aço");
                    break;
            case "Alumínio":
                    if(estoque.getAluminio() - qtd >= 0) estoque.setAluminio(estoque.getAluminio() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Alumínio");
                    break;
            case "Ouro":
                    if(estoque.getOuro() - qtd >= 0) estoque.setOuro(estoque.getOuro() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Ouro");
                    break;
            case "Cobre":
                    if(estoque.getCobre()- qtd >= 0) estoque.setCobre(estoque.getCobre() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Cobre");
                    break;
            case "Chumbo":
                    if(estoque.getChumbo()- qtd >= 0) estoque.setChumbo(estoque.getChumbo() - qtd);
                    else throw new FaltouInsumoException(carro.getCodigo(), carro.getCor(), "Chumbo");
                    break;
        }
    }
}
