/*Nome: Enzo Mikael - RM:558887*/
package models;

import enums.SituacaoEnum;

import java.time.LocalDate;
import java.util.Random;

public class ContaComum {
    protected Long nroConta;
    protected LocalDate dtAbertura;
    protected LocalDate dtEncerramento;
    protected SituacaoEnum situacao;
    protected int senha;
    protected double saldo;
    protected Cliente cliente;

    public Long abrirConta(int senha) {
        Random r = new Random();
        this.dtAbertura = LocalDate.now();
        this.situacao = SituacaoEnum.ATIVA;
        this.saldo = 100;
        this.senha = senha;
        this.nroConta = r.nextLong(100);
        return this.nroConta;
    }

    public boolean validarSenha(int senha){
        if(this.senha == senha){
            return true;
        }else{
            return false;
        }
    }

    public String sacarValor(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return "Saque efetuado com sucesso.\nNovo Saldo: " + this.saldo;
        }else{
            return "Saque não efetuado, saldo insuficiente.";
        }
    }

    public void depositarValor(double valor, Long nroConta){
        if(this.nroConta == nroConta){
            this.saldo += valor;
        }else{
            System.out.println("Conta inválida!");;
        }
    }

    public String encerrarConta(Long nroConta){
        if(this.nroConta == nroConta){
            this.saldo = 0;
            this.situacao = SituacaoEnum.INATIVA;
            this.dtEncerramento = LocalDate.now();
            return "Conta encerrada.";
        }else{
            return "Conta inválida!";
        }
    }

    public Long getNroConta() {
        return nroConta;
    }

    public void setNroConta(Long nroConta) {
        this.nroConta = nroConta;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public LocalDate getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(LocalDate dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
