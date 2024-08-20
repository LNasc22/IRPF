package br.pucpr.POO.Imposto;

import java.util.ArrayList;

public class IRPF {

    private String nome;
    private float salario;
    private String DataNascimento;
    private float ValorPensao;
    private ArrayList<Dependente> dependentes = new ArrayList<>();
    private ArrayList<DespesaMedica> despesasMedicas = new ArrayList<>();
    private ArrayList<PrevidenciaPrivada> previdenciasPrivadas = new ArrayList<>();

    public IRPF(){
        setNome(nome);
        setSalario(salario);
        setDataNascimento(DataNascimento);
        setValorPensao(ValorPensao);
    }

    public IRPF(String nome, float salario, String dataNascimento, float valorPensao) {
        this.nome = nome;
        setSalario(salario);
        DataNascimento = dataNascimento;
        setValorPensao(valorPensao);
    }

    public void InserirDependentes(Dependente d){

        dependentes.add(d);
    }

    public void InserirDespesaMedica(DespesaMedica despesaM){

        despesasMedicas.add(despesaM);
    }

    public void InserirPrevidenciaPrivada(PrevidenciaPrivada previdencias){

        previdenciasPrivadas.add(previdencias);
    }

    public float calculateImposto(){
        float valor;
        float somaPrevidencias = 0.0f;
        float somaDespesasM = 0.0f;

        for (PrevidenciaPrivada p: previdenciasPrivadas){
            somaPrevidencias += p.getValor();
        }

        for (DespesaMedica d: despesasMedicas){
            somaDespesasM += d.getValor();
        }

        valor = salario - (189.59f * dependentes.size()) + ValorPensao + somaPrevidencias + (0.2f * somaDespesasM);

        float totalFaixas = 0;

        if (valor <= 1903.98f) {
            totalFaixas = .0f;
        }

        // Calculo segunda faixa
        if (valor >= 1903.98f && valor <= 2826.65f) {
            totalFaixas += (valor - 1903.98f) * 0.075f;
        } else if (valor >= 1903.98f && valor > 2826.65f) {
            totalFaixas += (2826.65 - 1903.98f) * 0.075f;
        }

        // Calculo terceira faixa
        if (valor >= 2826.65f && valor <= 3751.05f) {
            totalFaixas += (valor - 2826.65f) * 0.15f;
        } else if (valor >= 2826.65f && valor > 3751.05f) {
            totalFaixas += (3751.05f - 2826.65f) * 0.15f;
        }

        // Calculo quarta faixa
        if (valor >= 3751.05f && valor <= 4664.68) {
            totalFaixas += (valor - 3751.05f) * 0.225f;
        } else if (valor >= 3751.05f && valor > 4664.68) {
            totalFaixas += (4664.68f - 3751.05f) * 0.225f;
        }

        // Calculo quinta faixa
        if (valor > 4664.68f) {
            totalFaixas += (valor - 4664.68f) * 0.275f;
        }

        return totalFaixas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario<0){
            this.salario=0.0f;
        }else{
            this.salario = salario;
        }
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public float getValorPensao() {
        return ValorPensao;
    }

    public void setValorPensao(float valorPensao) {
        if (valorPensao<0){
            ValorPensao=0.0f;
        }else{
            ValorPensao = valorPensao;
        }
    }

    public Object[] getPrevidenciaPrivada() {
        ArrayList ListPrev = new ArrayList();
        for (PrevidenciaPrivada previdencia: previdenciasPrivadas){
            ListPrev.add(previdencia.toString());
        }
        return ListPrev.toArray(new Object[0]);
    }

    public Object[] getDespesaMedica(){
        ArrayList ListDesp = new ArrayList();
        for (DespesaMedica despesa: despesasMedicas){
            ListDesp.add(despesa.toString());
        }
        return ListDesp.toArray(new Object[0]);
    }

    public Object[] getDependente(){
        ArrayList ListDep = new ArrayList();
        for (Dependente dependente: dependentes){
            ListDep.add(dependente.toString());
        }
        return ListDep.toArray(new Object[0]);
    }
}
