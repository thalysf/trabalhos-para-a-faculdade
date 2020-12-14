package ex09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.LinkedList;

public class Ex09 {

    public static void main(String[] args) throws FileNotFoundException {
        boolean exito = true;
        int i = 0;
        Locale US = Locale.US;
        Double preco;
        Double total;
        Integer qtd;
        String nome;
        String[] info = null;
        LinkedList<String> entradas = new LinkedList<>();
        File file = new File("produtos.txt");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                entradas.add(scan.nextLine());
            }
            String novoDiretorio = "C:\\Users\\thaly\\Documents\\Curso de Java\\Exercicios\\Ex09\\saidaPasta";
            boolean sucesso = new File(novoDiretorio).mkdir();
            BufferedWriter bw = new BufferedWriter(new FileWriter(novoDiretorio + "\\saida.txt"));

            for (String dado : entradas) {
                info = dado.split(",");
                if (info.length != 3) {
                    throw new IOException();
                }
                nome = info[0];
                preco = Double.parseDouble(info[1]);
                qtd = Integer.parseInt(info[2]);
                total = qtd.doubleValue() * preco;
                bw.write(nome + "," + total);
                bw.newLine();
            }

            bw.close();

        } catch (IOException | NumberFormatException exception) {
            exito = false;
            System.out.println("Arquivo de entrada mal formatado!");
        }
        if (exito) {
            System.out.println("Arquivo saída.txt gerado com sucesso!");
        }
    }

}
