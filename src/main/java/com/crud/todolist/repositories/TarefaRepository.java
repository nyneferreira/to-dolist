package com.crud.todolist.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.todolist.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long>{

}
