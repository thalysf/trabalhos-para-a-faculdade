package simulado;

/**
 * 
 * @author thalysfabrete
 */
public class Simulado {

    public static void main(String[] args) {
        // Todo carro tem: aceleracao, velocidade máxima,
        // dirigibilidade, propulsao (nessa ordem)
        Carro c1 = new Camaro(4.23, 262, 1.235, 32);
        Carro c2 = new Tesla(3.87, 222, 1.113, 26);
        Carro c3 = new Survolt(2.2, 294, 1.3, 38);
        // Um carro pode ser tunado e ter, por exemplo, maior acelaraçao
        // e velocidade que outro do mesmo modelo
        Carro c4 = new Survolt(2.1, 298, 1.3, 38);
        Carro c5 = new Camaro(2.2, 294, 1.3, 38);
        Carro c6 = new Camaro(2.2, 294, 1.3, 38);
        System.out.println("A quantidade de carros criados é ");
        System.out.println("D: " + D.getQtD()); // -> o D.getQtD é um método direto da classe, ou seja, estático  
        System.out.println("C: " + C.getQtC());
        System.out.println("B: " + B.getQtB());
        System.out.println("Os preços dos carros são: ");
        System.out.println(c1.getPreco() + ", ");
        System.out.println(c2.getPreco() + ", ");
        System.out.println(c3.getPreco() + ", ");
        System.out.println(c4.getPreco() + ".");
        // Impressão do carro c1 
        // Deve ser impresso:
        // Aceleracao = 4.23, Velocidade Máxima = 262.0, Dirigibilidade = 1.235, Propulsao = 32.
        System.out.println(c1.toString()); 
    }
    
}
