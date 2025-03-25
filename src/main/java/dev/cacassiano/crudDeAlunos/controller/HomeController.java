package dev.cacassiano.crudDeAlunos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HomeController {
    @GetMapping
    public String home(){
        return "<h1>faça suas requisições no endpoint<br>/alunos<br>Se a requisição for uma lista<br>/alunos/list</h1>";
    }
}
