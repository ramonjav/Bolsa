package com.example.bolsa;

public class Accion {

    private String empresa;
    private float valor;
    private String tendencia;
    private float valormax;
    private float valormin;
    private int riesgo;

    public Accion(String empresa, float valor, String tendencia, float valormax, float valormin, int riesgo) {
        this.empresa = empresa;
        this.valor = valor;
        this.tendencia = tendencia;
        this.valormax = valormax;
        this.valormin = valormin;
        this.riesgo = riesgo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public float getValormax() {
        return valormax;
    }

    public void setValormax(float valormax) {
        this.valormax = valormax;
    }

    public float getValormin() {
        return valormin;
    }

    public void setValormin(float valormin) {
        this.valormin = valormin;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }
}
