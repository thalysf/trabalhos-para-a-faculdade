package Ex02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //double xA, yA, xB, yB, xC, yC, perimetroTriangulo = 0;
        int[] pontoA, pontoB, pontoC;
        double perimetro;
        pontoA = new int[2];
        pontoB = new int[2];
        pontoC = new int[2];

        System.out.println("- Ponto A -");
        lerPonto(pontoA);
        System.out.println("- Ponto B -");
        lerPonto(pontoB);
        System.out.println("- Ponto C -");
        lerPonto(pontoC);
        perimetro =+ Distancia.calcularDistancia(pontoA[0], pontoA[1], pontoB[0], pontoB[1]);
        perimetro =+ Distancia.calcularDistancia(pontoA[0], pontoA[1], pontoC[0], pontoC[1]);
        perimetro =+ Distancia.calcularDistancia(pontoB[0], pontoB[1], pontoC[0], pontoC[1]);
        
        System.out.println("Perímetro do triângulo = " + perimetro);
    }

    public static double lerPonto(int[] ponto) {
        Scanner ler;
        ler = new Scanner(System.in);
        System.out.print("Insira o valor de x: ");
        ponto[0] = ler.nextInt();
        System.out.print("Insira o valor de y: ");
        ponto[1] = ler.nextInt();

        return 0;
    }
}
