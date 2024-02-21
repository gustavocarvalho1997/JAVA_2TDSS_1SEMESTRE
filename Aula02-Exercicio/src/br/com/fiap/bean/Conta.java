package br.com.fiap.bean;

import java.time.LocalDate;
import java.util.Calendar;

public abstract class Conta {
    // Atributos
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected LocalDate dataAbertura;
    // Construtores
    public Conta() {
        super();
    }

    public Conta(int agencia, int numero, double saldo, LocalDate dataAbertura) {
        super();
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
    }

    // Getters e Setters
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    // Métodos
    public abstract void depositar(double valor);

    public abstract void retirar(double valor);
}//CLASS