package dev.cacassiano.crudDeAlunos.entity;

import dev.cacassiano.crudDeAlunos.controller.service.AlunoReqDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aluno")
@Table(name = "alunos")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private int idade;

    private String email;
    
    public Aluno(AlunoReqDTO body)
    {
        this.nome = body.nome();
        this.email = body.email();
        this.idade = body.idade();

    }
}
