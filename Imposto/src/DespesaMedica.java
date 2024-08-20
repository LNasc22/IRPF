package br.pucpr.POO.Imposto;

public class DespesaMedica {

    private String desc;
    private float valor;

    public DespesaMedica(String desc, float valor) {
        this.desc = desc;
        setValor(valor);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor<0){
            this.valor=0.0f;
        }else{
            this.valor = valor;
        }
    }

    @Override
    public String toString(){
        return "Descrição: " + desc + " - Valor: " + valor;
    }
}
