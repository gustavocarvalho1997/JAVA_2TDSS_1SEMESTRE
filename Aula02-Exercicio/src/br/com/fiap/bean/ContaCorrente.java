package br.com.fiap.bean;

import java.time.LocalDate;

public final class ContaCorrente extends Conta{
    // Atributos
    private TipoConta tipo;
    // Construtores
    public ContaCorrente() {
        super();
    }
    public ContaCorrente(int agencia, int numero, double saldo, LocalDate dataAbertura, TipoConta tipo) {
        super(agencia, numero, saldo, dataAbertura);
        this.tipo = tipo;
    }
    // Getters e Setters
    public TipoConta getTipo() {
        return tipo;
    }
    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }
    // Métodos
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }//depositar
    @Override
    public void retirar(double valor) {
        if(tipo.equals(TipoConta.COMUM) && valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else {
            saldo -= valor;
        }
    }//retirar
}//CLASS