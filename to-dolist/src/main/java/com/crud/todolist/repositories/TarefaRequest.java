package com.crud.todolist.repositories;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequest(Long id, @NotBlank String titulo, String descricao, String dataCriacao, Integer status) {

}
