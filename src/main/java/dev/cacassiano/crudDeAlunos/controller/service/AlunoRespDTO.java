package dev.cacassiano.crudDeAlunos.controller.service;

import dev.cacassiano.crudDeAlunos.entity.Aluno;

public record AlunoRespDTO(long id, String nome, String email, int idade) {
    public AlunoRespDTO(Aluno dados){
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getIdade());
    }
}
