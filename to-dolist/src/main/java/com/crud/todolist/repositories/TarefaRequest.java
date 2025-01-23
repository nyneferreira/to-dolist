package com.crud.todolist.repositories;


public record TarefaRequest(Long id, String titulo, String descricao, String dataCriacao, Integer status) {

}
