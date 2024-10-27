package br.com.renan.ex012.model;

import android.annotation.SuppressLint;

/**
 *@author: renan santos carvalho
 */
public class Ingresso {
    private String codigoIdentificador;
    private float valor;

    public Ingresso(String codigoIdentificador, float valor) {
        this.codigoIdentificador = codigoIdentificador;
        this.valor = valor;
    }

    public float valorFinal(float taxaConveniencia) {
        return valor + taxaConveniencia;
    }

    // Getters e Setters
    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @SuppressLint("DefaultLocale")
    public String getResumo(float taxaConvenniencia) {
        return String.format(
                        "Código: %s\n" +
                        "Valor:  %.2f\n" +
                        "Taxa:   %.2f\n" +
                        "Total:  %.2f",
                getCodigoIdentificador(),
                getValor(),
                taxaConvenniencia,
                valorFinal(taxaConvenniencia));
    }
}
