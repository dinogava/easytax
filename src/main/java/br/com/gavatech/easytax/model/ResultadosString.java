package br.com.gavatech.easytax.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResultadosString {
    private String valorPresente;
    private String taxaJuros;
    private String dataInicio;
    private String dataFinal;
    private String diasAtraso;
    private String valorTotalJuros;
    private String valorFinal;

    public ResultadosString(){

    }

    public ResultadosString(String valorPresente, String taxaJuros,
                            String dataInicio, String dataFinal, String diasAtraso, String valorTotalJuros, String valorFinal) {
        this.valorPresente = valorPresente;
        this.taxaJuros = taxaJuros;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.diasAtraso = diasAtraso;
        this.valorTotalJuros = valorTotalJuros;
        this.valorFinal = valorFinal;
    }

    public String getValorPresente() {
        return valorPresente;
    }

    public void setValorPresente(String valorPresente) {
        this.valorPresente = valorPresente;
    }

    public String getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(String taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(String diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public String getValorTotalJuros() {
        return valorTotalJuros;
    }

    public void setValorTotalJuros(String valorTotalJuros) {
        this.valorTotalJuros = valorTotalJuros;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "ResultadosString{" +
                "valorPresente='" + valorPresente + '\'' +
                ", taxaJuros='" + taxaJuros + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", diasAtraso='" + diasAtraso + '\'' +
                ", valorTotalJuros='" + valorTotalJuros + '\'' +
                ", valorFinal='" + valorFinal + '\'' +
                '}';
    }
}
