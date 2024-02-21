package br.com.fiap.bean;

import java.time.LocalDate;

public final class ContaPoupanca extends Conta implements ContaInvestimento {
    // Atributos
    private float taxa;
    public static final float RENDIMENTO = 0.05f;
    // Construtores
    public ContaPoupanca() {
        super();
    }
    public ContaPoupanca(int agencia, int numero, double saldo, LocalDate dataAbertura, float taxa) {
        super(agencia, numero, saldo, dataAbertura);
        this.taxa = taxa;
    }
    // Getters e Setters


    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    // Métodos
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void retirar(double valor) {
        if(valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public double calcularRetornoInvestimento() {
        return saldo * RENDIMENTO;
    }
}//CLASS