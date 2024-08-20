package br.pucpr.POO.Imposto;

public class Dependente {

    private String nome;
    private String dataNasc;

    public Dependente(String nome, String dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getDataNasc() {

        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {

        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Data de nascimento: " + dataNasc;
    }
}
