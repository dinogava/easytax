package br.com.gavatech.easytax.controller;

import br.com.gavatech.easytax.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/inicio")
public class ProRataController {

    private List<ResultadosString> resultados = new ArrayList<>();
    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "calculo/formulario";
    }
    @GetMapping
    public String carregaPaginaResultados(Model model){
        model.addAttribute("resultados", resultados);
        return "calculo/listagem";
    }
   @PostMapping
    public String calculaValores(@ModelAttribute StringDTO dados){


       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

       LocalDate inicio = LocalDate.parse(dados.dataInicio(),formatter);
       LocalDate fim = LocalDate.parse(dados.dataFinal(),formatter);
      DadosProRataDTO dados1 = new DadosProRataDTO(new BigDecimal(dados.valorPresente()),new BigDecimal(dados.taxaJuros()),inicio,fim);

       CalculoProRata calculo = new CalculoProRata();
       try {
           calculo.calcularJurosProRataDie(dados1);
       } catch (MValidationException e) {

           System.out.println("Erro!");
       }

       ResultadosString resultado = new ResultadosString();
       resultado.setValorPresente(calculo.getValorPresente().toString());
       resultado.setTaxaJuros(calculo.getTaxaJuros().toString());
       resultado.setDataInicio(calculo.getDataInicio().toString());
       resultado.setDataFinal(calculo.getDataFinal().toString());
       String diasAtraso = Long.toString(calculo.getDiasAtraso());
       resultado.setDiasAtraso(diasAtraso);
       resultado.setValorTotalJuros(calculo.getValorTotalJuros().toString());
       resultado.setValorFinal(calculo.getValorFinal().toString());

       resultados.add(resultado);

       System.out.println(calculo);

       System.out.println("lista de results"+resultados);


        return "redirect:/inicio";
    }

}
