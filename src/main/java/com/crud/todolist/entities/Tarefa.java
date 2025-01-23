package com.crud.todolist.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.crud.todolist.repositories.TarefaRequest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tarefa")
@Table(name = "tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String titulo;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false, updatable = false)
	private Date dataCriacao;

	//	private StatusTarefa status;

	public Tarefa() {}

	public Tarefa(TarefaRequest tarefarequest) throws ParseException {
		this.id = tarefarequest.id();
		this.setTitulo(tarefarequest.titulo());
		this.setDescricao(tarefarequest.descricao());


		SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdfEntrada.parse(tarefarequest.dataCriacao());

		// Converter Date para String no formato yyyy/MM/dd
		SimpleDateFormat sdfSaida = new SimpleDateFormat("yyyy/MM/dd");
		String dataFormatada = sdfSaida.format(data);

		this.setDataCriacao(data);
		//this.status = tarefarequest.status();		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


}
