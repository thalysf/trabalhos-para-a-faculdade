package clienteudp;


public class MeuClienteUDP {
        public static void main(String[] args) {
        AtualizadorThread atualizador = new AtualizadorThread();
        atualizador.start();
    }
}
