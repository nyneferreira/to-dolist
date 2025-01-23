package com.crud.todolist.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.todolist.entities.Tarefa;
import com.crud.todolist.repositories.TarefaRepository;
import com.crud.todolist.repositories.TarefaRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	

	
	@PostMapping
	public ResponseEntity create (@RequestBody TarefaRequest tarefaRequest) throws ParseException {
		Tarefa tarefa = new Tarefa(tarefaRequest);		
		tarefaRepository.save(tarefa);
		return ResponseEntity.ok("Tarefa incluída com sucesso");
		
	}
	
	@GetMapping
	public ResponseEntity list() {
		var tarefa = tarefaRepository.findAll();		
		return ResponseEntity.ok(tarefa);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		
		if(tarefa.isPresent()) {
			tarefaRepository.deleteById(id);
			return ResponseEntity.ok("Tarefa excluída com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody TarefaRequest tarefaRequest) throws ParseException {
		Optional<Tarefa> tarefaOp = tarefaRepository.findById(tarefaRequest.id());
		
		if(tarefaOp.isPresent()) {
			Tarefa tarefa = tarefaOp.get();
			tarefa.setTitulo(tarefaRequest.titulo());
			tarefa.setDescricao(tarefaRequest.descricao());
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date data = formato.parse(tarefaRequest.dataCriacao());
	        
			tarefa.setDataCriacao(data);
			tarefaRepository.save(tarefa);
			
			return ResponseEntity.ok(tarefa);
		}else {
			return ResponseEntity.ok("Tarefa não encontrada");
		}
		
	}

	
}
