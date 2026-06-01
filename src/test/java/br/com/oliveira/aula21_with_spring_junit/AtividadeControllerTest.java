package br.com.oliveira.aula21_with_spring_junit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.oliveira.aula21_with_spring_junit.controllers.AtividadeController;

@WebMvcTest(AtividadeController.class)
public class AtividadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarNomeCompleto() throws Exception {
        // Executa a requisição GET para /atividade e valida o retorno
        mockMvc.perform(get("/atividade"))
                .andExpect(status().isOk())
                .andExpect(content().string("Lucas Barros"));
    }
}