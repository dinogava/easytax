package br.com.gavatech.easytax.model;
import java.io.IOException;
import java.math.BigDecimal;

public interface ICalculoProRata {
    public abstract BigDecimal calcularJurosProRataDie(DadosProRataDTO dados)
            throws MValidationException , MException;
}

