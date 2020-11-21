package trabalhopoo1_2020_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author thalys fabrete - V06
 */
public class TrabalhoPOO1_2020_2 {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Carro> carros = new LinkedList<Carro>(); // lista de carros
        LinkedList<String> carrosRepetidos = new LinkedList<String>();
        carros = lerCarros(); // recebe o retorno da lista de carros lida do arquivo 'carros.txt'
        Estoque estoque = lerEstoque(); // recuperando o estoque
        Iterator it = carros.iterator(); // Iterador da lista de carros
        DecimalFormat df = new DecimalFormat(); 
        df.applyPattern("#,###,000.00");
        int dias = 0, naoTurbo = 0, turbo = 0, qtdMenos100Cavalos = 0; // contador de dias fabricando carros, carros não turbo e carros turbo.
        double mediaCilindradas = 0;
        while (it.hasNext()) {
            Carro carro = (Carro) it.next();
            carrosRepetidos.add(carro.getNome());
            mediaCilindradas += carro.getMotor().getCilindrada();
            if (carro.getMotor().isTurbo()) {
                turbo++;
            } else {
                naoTurbo++;
            }
            if (carro.getMotor().getQtdCavalos() < 100) {
                qtdMenos100Cavalos++;
            }
        }
        mediaCilindradas = mediaCilindradas / carros.size(); // Calculando média de cilindradas
        carrosRepetidos = verificaRepetido(carrosRepetidos); // Recebendo o retorno dos carros repetidos
        
        System.out.println("1) " + carrosRepetidos.toString());
        System.out.println("2) " + qtdMenos100Cavalos);
        System.out.println("3) Não turbo: " + naoTurbo + " e Turbo: " + turbo);
        System.out.println("4) " + df.format(mediaCilindradas) + " Cilindradas");
        System.out.println("5) Compacto: " + Compacto.getQtdCompacto() + ", Sedan: " + Sedan.getQtdSedan() + ", SUV: " + Suv.getQtdSuv());
        try {
            while (true) {
                it = carros.iterator();
                while (it.hasNext()) {

                    Carro carro = (Carro) it.next();
                    carro.construir(estoque);

                }
                dias++;
            }
        } catch (FaltouInsumoException erro) {
            System.out.println("6) O Estoque suportou " + dias + " dias");
            System.out.println("7) " + erro.getMessage());
        }
    }

    public static LinkedList<Carro> lerCarros() throws FileNotFoundException {
        LinkedList<Carro> carrosList = new LinkedList<Carro>();
        try {
            FileInputStream file = new FileInputStream("carros.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                switch (scan.next()) // Pelo código do carro, eu sei qual carro add na lista
                {
                    case "BR1.0":
                        carrosList.add(new Brazuca(scan.next()));
                        break;
                    case "BRSedan":
                        carrosList.add(new Bradan(scan.next()));
                        break;
                    case "BRSedanTurbo":
                        carrosList.add(new BradanTurbo(scan.next()));
                        break;
                    case "TitaHatch":
                        carrosList.add(new Netuno(scan.next()));
                        break;
                    case "TitaSedan":
                        carrosList.add(new Gaia(scan.next()));
                        break;
                    case "Hades":
                        carrosList.add(new Hades(scan.next()));
                        break;
                    case "Zeus":
                        carrosList.add(new Zeus(scan.next()));
                        break;
                }

            }

        } catch (FileNotFoundException fileNot) {
            fileNot.getMessage();
        }
        return carrosList; // retornando a lista de carros lida do arquivo 'carros.txt'

    }

    public static Estoque lerEstoque() throws FileNotFoundException {
        Estoque estoque = new Estoque();
        try {
            FileInputStream file = new FileInputStream("estoque.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                switch (scan.next()) // recuperando quantidade abastecidade do estoque
                {                    // Independente da ordem que o estoque foi informado, a quantidade de cada item será lida corretamente
                    case "Madeira":
                        estoque.setMadeira(Integer.parseInt(scan.next()));
                        break;
                    case "Aço":
                        estoque.setAco(Integer.parseInt(scan.next()));
                        break;
                    case "Ferro":
                        estoque.setFerro(Integer.parseInt(scan.next()));
                        break;
                    case "Alumínio":
                        estoque.setAluminio(Integer.parseInt(scan.next()));
                        break;
                    case "Ouro":
                        estoque.setOuro(Integer.parseInt(scan.next()));
                        break;
                    case "Cobre":
                        estoque.setCobre(Integer.parseInt(scan.next()));
                        break;
                    case "Chumbo":
                        estoque.setChumbo(Integer.parseInt(scan.next()));
                        break;
                }
            }

        } catch (FileNotFoundException fileNot) {
            fileNot.getMessage();
        }
        return estoque; // retornando o estoque lido do arquivo 'estoque.txt'

    }
    public static LinkedList<String> verificaRepetido(LinkedList<String> carrosRepetidos)
    {
        LinkedList<String> repetidos = new LinkedList<String>();
        // Removendo as primeiras ocorrências de todos tipos de carros
        // Os elementos que sobrarem serão os repetidos
        carrosRepetidos.removeFirstOccurrence("Brazuca");
        carrosRepetidos.removeFirstOccurrence("Bradan");
        carrosRepetidos.removeFirstOccurrence("Bradan Turbo");
        carrosRepetidos.removeFirstOccurrence("Netuno ");
        carrosRepetidos.removeFirstOccurrence("Gaia");
        carrosRepetidos.removeFirstOccurrence("Posseidon");
        carrosRepetidos.removeFirstOccurrence("Hades");
        carrosRepetidos.removeFirstOccurrence("Zeus");
        
        // Refazendo a lista dos repetidos, ela irá conter apenas uma cópia de cada elemento repetido
        
        if(carrosRepetidos.contains("Brazuca")) repetidos.add("Brazuca");
        if(carrosRepetidos.contains("Bradan")) repetidos.add("Bradan");
        if(carrosRepetidos.contains("Bradan Turbo")) repetidos.add("Bradan Turbo");
        if(carrosRepetidos.contains("Netuno")) repetidos.add("Netuno");
        if(carrosRepetidos.contains("Gaia")) repetidos.add("Gaia");
        if(carrosRepetidos.contains("Posseidon")) repetidos.add("Posseidon");
        if(carrosRepetidos.contains("Hades")) repetidos.add("Hades");
        if(carrosRepetidos.contains("Zeus")) repetidos.add("Zeus");
        return repetidos;
        
    }
}
