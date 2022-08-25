/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteformulario;

/**
 *
 * @author thalys
 */
public class ClienteTCP {
    public static void main(String[] args) {
        AtualizadorThread atualizadorThread = new AtualizadorThread("AtualizadorThread", 3, 1000);
        atualizadorThread.start();
    }
}
