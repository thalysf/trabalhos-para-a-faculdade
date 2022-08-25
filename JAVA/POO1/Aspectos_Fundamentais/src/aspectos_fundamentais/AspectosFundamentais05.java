/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aspectos_fundamentais;

public class AspectosFundamentais05 {

    public static void main(String[] args) {
        // TODO code application logic here
        double nota1, nota2, trabalho1, trabalho2, media;
        // Convertendo String[] para Double
        nota1 = Double.parseDouble(args[0]);
        nota2 = Double.parseDouble(args[1]);
        trabalho1 = Double.parseDouble(args[2]);
        trabalho2 = Double.parseDouble(args[3]);
        media = ( nota1 + nota2 + trabalho1 + trabalho2 ) / 4;
        System.out.println("Media = " + media);
    }
}
