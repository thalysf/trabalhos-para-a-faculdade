package Excecoes;


public class Saque_Exception extends Exception{
    @Override
    public String getMessage(){
        return "Operação de saque negada!";
    }
}
