package dev.cacassiano.crudDeAlunos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cacassiano.crudDeAlunos.controller.service.AlunoReqDTO;
import dev.cacassiano.crudDeAlunos.controller.service.AlunoRespDTO;
import dev.cacassiano.crudDeAlunos.entity.Aluno;
import dev.cacassiano.crudDeAlunos.repository.AlunoRepository;

import java.util.List;


@RestController
@RequestMapping("aluno")

public class AlunoController 
{
    @Autowired
    private AlunoRepository repository;
    
    @GetMapping 
    public  List<AlunoRespDTO> buscarTodos(){
        List<AlunoRespDTO> alunos = repository.findAll().stream().map(AlunoRespDTO::new).toList();
        return alunos;
    }

    @PostMapping
    public void addAluno(@RequestBody AlunoReqDTO body)
    {
        Aluno nAluno = new Aluno(body);
        repository.save(nAluno);
    }
}
