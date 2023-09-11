package br.com.gavatech.easytax.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record StringDTO(String valorPresente, String taxaJuros, String dataInicio , String dataFinal) {
}
