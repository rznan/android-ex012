package br.com.renan.ex012.model;

import android.annotation.SuppressLint;

/**
 *@author: renan santos carvalho
 */
public class IngressoVip extends Ingresso {
    private String funcao;

    public IngressoVip(String codigoIdentificador, float valor, String funcao) {
        super(codigoIdentificador, valor);
        this.funcao = funcao;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        float valorComTaxa = super.valorFinal(taxaConveniencia);
        return valorComTaxa * 1.18f; // Acrescenta 18% para ingresso VIP
    }

    // Getter e Setter para função
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @SuppressLint("DefaultLocale")
    public String getResumo(float taxaConvenniencia) {
        return String.format(
                        "Código: %s\n" +
                        "Valor:  %.2f\n" +
                        "Taxa:   %.2f\n" +
                        "VIP:    +18%%\n"+
                        "Função: %s\n" +
                        "Total:  %.2f",
                getCodigoIdentificador(),
                getValor(),
                taxaConvenniencia,
                getFuncao(),
                valorFinal(taxaConvenniencia));
    }
}