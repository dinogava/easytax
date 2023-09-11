package br.com.gavatech.easytax.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculoProRata implements ICalculoProRata {

    private BigDecimal valorPresente;
    private BigDecimal taxaJuros;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private long diasAtraso;
    private BigDecimal valorTotalJuros;
    private BigDecimal valorFinal;



    public CalculoProRata(){}
    public CalculoProRata(BigDecimal valorPresente, BigDecimal taxaJuros, LocalDate dataInicio, LocalDate dataFinal) {
        this.valorPresente = valorPresente;
        this.taxaJuros = taxaJuros;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;

    }
    @Override
    public BigDecimal calcularJurosProRataDie(DadosProRataDTO dados) throws MValidationException  {
        LocalDate dataAtual = LocalDate.now();

        if(dados.taxaJuros().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MValidationException("A taxa de juros não pode "
                    + "ser inferior ou igual a zero.");
        }

        else if (dados.valorPresente().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MValidationException("O valor Presente não pode "
                    + "ser inferior ou igual a zero.");
        }

        else if (dados.dataInicio().isBefore(dataAtual)) {
            throw new MValidationException("a data de inicio não pode "
                    + "ser inferior a data de hoje.");
        }
        else if (dados.dataFinal().isBefore(dados.dataInicio())||dados.dataFinal().isBefore(dataAtual)) {
            throw new MValidationException("a data final não pode "
                    + "ser inferior a data de hoje e nem a data de inicio.");
        }

        long difDias = dados.dataInicio().until(dados.dataFinal(), ChronoUnit.DAYS);

        BigDecimal taxa = dados.taxaJuros().divide(new BigDecimal("30"), 10, RoundingMode.HALF_UP);

        System.out.println("dias de atraso: "+difDias);

        // parentese1 se refere ao primeiro parentese da formula do calculo de juros composto pro-rata.

        BigDecimal parentese1 = taxa.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);
        parentese1 = parentese1.add(BigDecimal.ONE);

        // parentese2 se refere ao segundo parentese da formula separei os dois para poder fazer a logica do
        // calculo e depois unir as variaveis no final para obter o resultado.

        BigDecimal parentese2 = parentese1.pow((int) difDias);

        BigDecimal juros = parentese2.subtract(BigDecimal.ONE);
        juros = juros.multiply(dados.valorPresente());

        BigDecimal valorFinal = juros.add(dados.valorPresente());
        valorFinal = valorFinal.setScale(2,RoundingMode.HALF_UP);
        juros = juros.setScale(2,RoundingMode.HALF_UP);

        this.valorPresente = dados.valorPresente();
        this.taxaJuros = dados.taxaJuros();
        this.dataInicio = dados.dataInicio();
        this.dataFinal = dados.dataFinal();
        this.diasAtraso = difDias;
        this.valorTotalJuros = juros;
        this.valorFinal = valorFinal;

        System.out.println("valor total de juros: "+juros);
        System.out.println("valor Final: "+valorFinal);
        System.out.println("porcentagem de juros: "+dados.taxaJuros()+"% ao dia");
        System.out.println("taxa: "+taxa);

        return valorFinal;

    }

    public BigDecimal getValorPresente() {
        return valorPresente;
    }

    public void setValorPresente(BigDecimal valorPresente) {
        this.valorPresente = valorPresente;
    }

    public BigDecimal getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(BigDecimal taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public long getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(long diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public BigDecimal getValorTotalJuros() {
        return valorTotalJuros;
    }

    public void setValorTotalJuros(BigDecimal valorTotalJuros) {
        this.valorTotalJuros = valorTotalJuros;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "CalculoProRata{" +
                "valorPresente=" + valorPresente +
                ", taxaJuros=" + taxaJuros +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", diasAtraso=" + diasAtraso +
                ", valorTotalJuros=" + valorTotalJuros +
                ", valorFinal=" + valorFinal +
                '}';
    }
}
