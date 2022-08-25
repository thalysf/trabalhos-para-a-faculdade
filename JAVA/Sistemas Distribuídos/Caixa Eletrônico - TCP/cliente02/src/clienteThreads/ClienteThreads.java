package clienteThreads;


public class ClienteThreads {

    public static void main(String[] args) {
        ConsumidorThread consumidorThread = new ConsumidorThread("CONSUMIDOR_THREAD", 1, 5000, "CONSUMIDOR");
        ProdutorThread produtorThread = new ProdutorThread("PRODUTOR_THREAD", 2, 5000, "PRODUTOR");
        consumidorThread.start();
        produtorThread.start();
    }
}
