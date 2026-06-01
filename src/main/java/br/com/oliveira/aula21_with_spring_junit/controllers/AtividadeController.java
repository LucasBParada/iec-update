package br.com.oliveira.aula21_with_spring_junit.controllers;

import org.springframework.web.bind.annotation.GetMapping; // Alterado o import
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtividadeController {

    @GetMapping("/atividade") // Mudou de @RequestMapping para @GetMapping
    public String atividade() {
        return "Lucas Barros";
    }

}