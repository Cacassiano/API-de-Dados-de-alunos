package dev.cacassiano.crudDeAlunos.repository;

import org.springframework.data.jpa.repository.*;

import dev.cacassiano.crudDeAlunos.entity.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long>
{ 
}
