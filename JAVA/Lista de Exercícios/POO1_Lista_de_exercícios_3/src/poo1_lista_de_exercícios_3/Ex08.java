package poo1_lista_de_exercícios_3;
import java.io.*;
public class Ex08 {

    public static void main(String[] args) throws IOException {
        
        int nota = 0, matricula = 0, sexo = 0, numHomens = 0, numMulheres = 0, mediaNotas = 0, totalDeNotas = 0, di = 0, dr = 0, db = 0;
        BufferedReader dado; 
        try
        {
            dado = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Digite a matricula: ");
                matricula = Integer.parseInt(dado.readLine());
                System.out.print("Digite a nota: ");
                nota = Integer.parseInt(dado.readLine());
                System.out.print("Digite o sexo [0] homem [1] mulher: ");
                sexo = Integer.parseInt(dado.readLine());
                
                if(matricula != 0)
                {
                    totalDeNotas++;
                    mediaNotas += nota;
                    if(nota < 60)di++;
                    else if(nota < 80) dr++;
                    else db++;
                    if(sexo == 0) numHomens++;
                    else numMulheres++;
                                
                }
            }while(matricula != 0);
           
           mediaNotas = mediaNotas/totalDeNotas;
            
            System.out.println("Média das notas: " + mediaNotas);
            System.out.println("Total de mulheres: " + numMulheres);
             System.out.println("Total de homens: " + numHomens);
             System.out.println("di, dr e db respectivamente: " + di + " | " + dr + " | " + db);
             
             System.out.println("Porcentagem de dis dbs e drs respectivamente: " + (di/totalDeNotas) + " | " + (dr/totalDeNotas) +  (db/totalDeNotas));
        
        }
        catch ( NumberFormatException erro )
        {
            System.out.println("Houve erro na conversão, digite apenas caracteres numericos");
        }  
    }
}