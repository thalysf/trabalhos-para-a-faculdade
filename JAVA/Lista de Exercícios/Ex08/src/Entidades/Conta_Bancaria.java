package Entidades;

import Excecoes.Saque_Exception;


public class Conta_Bancaria {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta_Bancaria(Integer numero, String titular, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }
    public void saque(Double valor) throws Saque_Exception
    {
        if(saldo == 0 || valor > limiteSaque || (saldo - valor) < 0) throw new Saque_Exception();
        else
        {
            saldo -= valor;
        }
    }
    public void deposito(Double valor)
    {
        saldo += valor;
    }

    @Override
    public String toString() {
        return "Conta_Bancaria{" + "numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", limiteSaque=" + limiteSaque + '}';
    }
    
}
