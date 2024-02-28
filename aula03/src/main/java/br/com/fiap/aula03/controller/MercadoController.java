package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mercado")
public class MercadoController {
    // GET
    @GetMapping("/consultar")
    public Mercado listar() {
        return new Mercado(1, "Carrefour", CategoriaMercado.HIPER);
    }//GET

}//CLASS