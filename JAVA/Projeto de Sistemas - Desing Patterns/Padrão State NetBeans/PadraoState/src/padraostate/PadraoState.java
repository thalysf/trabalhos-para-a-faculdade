package padraostate;
/**
 *
 * @authores thalys fabrete, alexandre borlini, vitor zani, pedro mariano
 */
public class PadraoState {
    private static int i = 1;
    public static void main(String[] args) {
        System.out.println("Esteira " + (i++) + "\n");
        Esteira esteira = new Esteira();
        try {
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.pararSteira();
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("\nEsteira " + (i++) + "\n");
        esteira = new Esteira();
        try {
            esteira.prosseguirEsteira();
            esteira.pararSteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("\nEsteira " + (i++) + "\n");
        esteira = new Esteira();
        try {
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.pararSteira();
            esteira.prosseguirEsteira();
            
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("\nEsteira " + (i++) + "\n");
        esteira = new Esteira();
         try {
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            esteira.prosseguirEsteira();
            
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
