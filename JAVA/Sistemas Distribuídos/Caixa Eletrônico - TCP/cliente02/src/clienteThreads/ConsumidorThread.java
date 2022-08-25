package clienteThreads;

/**
 *
 * @author thalys
 */
public class ConsumidorThread extends OperacaoThread {

    public ConsumidorThread(String nome, int operacao, int sleepTime, String tipoThread) {
        super(nome, operacao, sleepTime, tipoThread);
    }
}
