/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteThreads;

/**
 *
 * @author thalys
 */
public class ProdutorThread extends OperacaoThread {

    public ProdutorThread(String nome, int operacao, int sleepTime, String tipoThread) {
        super(nome, operacao, sleepTime, tipoThread);
    }
}
