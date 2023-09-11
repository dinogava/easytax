package br.com.gavatech.easytax.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosProRataDTO(BigDecimal valorPresente, BigDecimal taxaJuros, LocalDate dataInicio , LocalDate dataFinal) {
}
