/*Nome: Enzo Mikael - RM:558887*/
package models;

import enums.SituacaoEnum;

import java.time.LocalDate;
import java.util.Random;

public class ContaEspecial extends ContaComum{
    private double limiteConta;


    public Long abrirConta(int senha, double limite){
        super.abrirConta(senha);
        this.limiteConta = limite;
        return this.nroConta;
    }

    @Override
    public String sacarValor(double valor){
        if (valor > this.saldo || valor < this.limiteConta+this.saldo) {
            valor -= this.saldo;
            this.saldo = 0;
            this.limiteConta -= valor;
            return "Saque efetuado com sucesso.\nSaldo Devedor: -" + valor + "\nLimite Disponível: " + this.limiteConta;
        } else if (valor < this.saldo) {
            this.saldo -= valor;
            return "Saque efetuado com sucesso.\nNovo Saldo: " + this.saldo;
        } else {
            return "Saque não efetuado, saldo insuficiente.";
        }
    }

    public double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(double limiteConta) {
        this.limiteConta = limiteConta;
    }
}
