package com.crud.todolist.entities;

public enum StatusTarefa {
	
	EM_ANDAMENTO((byte)1, "Em andamento"),
	PENDENTE((byte)2, "Pendente"),
	CONCLUÍDA((byte)3, "Concluída");
	
	private final Byte value;
	
	private final String descricao;
	
	private StatusTarefa(Byte pValue, String pDescricao) {
		this.value = pValue;
		this.descricao = pDescricao;		
	}

	public Byte getValue() {
		return value;
	}

	public String getDescricao() {
		return descricao;
	}	
		

}
