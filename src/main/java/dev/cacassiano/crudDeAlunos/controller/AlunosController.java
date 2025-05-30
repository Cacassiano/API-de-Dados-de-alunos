package dev.cacassiano.crudDeAlunos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cacassiano.crudDeAlunos.controller.service.AlunoReqDTO;
import dev.cacassiano.crudDeAlunos.controller.service.AlunoRespDTO;
import dev.cacassiano.crudDeAlunos.entity.Aluno;
import dev.cacassiano.crudDeAlunos.repository.AlunoRepository;

import java.util.List;


@RestController
@RequestMapping("alunos")

public class AlunosController 
{
    @Autowired
    private AlunoRepository repository;
    
    @GetMapping
    public  List<AlunoRespDTO> buscarTodos(){
        List<AlunoRespDTO> alunos = repository.findAll().stream().map(AlunoRespDTO::new).toList();
        return alunos;
    }

    @PostMapping
    public String addAluno(@RequestBody AlunoReqDTO body)
    {
        Aluno nAluno = new Aluno(body);
        repository.save(nAluno);
        return "aluno "+nAluno.getNome()+" Adicionado";
    }

    @DeleteMapping
    public String delAluno(@RequestBody AlunoReqDTO body)
    {
        if(repository.existsById(body.id())){
            Aluno aluno = repository.getReferenceById(body.id());
            repository.deleteById(body.id());
            return "aluno "+aluno.getNome()+" deletado";
        }
        return "aluno não existe";
    } 
        @PostMapping("/delete")
        public String delByPost(@RequestBody AlunoReqDTO body)
        {
            return delAluno(body);
        }


    @PutMapping
    public String updAluno(@RequestBody AlunoReqDTO body)
    {
        if (!repository.existsById(body.id()))
        {
            return "Aluno não existe";
        }
        Aluno nAluno = repository.getReferenceById(body.id());
        
        nAluno.setEmail(body.email());
        nAluno.setIdade(body.idade());
        nAluno.setNome(body.nome());
        
        repository.save(nAluno);
        return "Atualização bem sucedida";
    }
    
    @PutMapping("list")
    public void updListAlunos(@RequestBody List<AlunoReqDTO> body)
    {
        for (AlunoReqDTO aluno : body) {
            updAluno(aluno);
        }
    }

    @PostMapping("list")
    public void addListAlunos(@RequestBody List<AlunoReqDTO> body)
    {
        for (AlunoReqDTO aluno : body) {
            addAluno(aluno);
        }
    }

    @DeleteMapping("list")
    public void delListAlunos(@RequestBody List<AlunoReqDTO> body)
    {
        for (AlunoReqDTO aluno : body) {
            delAluno(aluno);
        }
    }

    @GetMapping("list")
    public List<AlunoRespDTO> todos()
    {
        return buscarTodos();
    }
    
}

