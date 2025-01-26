package com.crud.todolist.entities;

public enum StatusTarefa {
	
	EM_ANDAMENTO(1, "Em andamento"),
	PENDENTE(2, "Pendente"),
	CONCLUÍDA(3, "Concluída");
	
	private final Integer value;
	
	private final String descricao;
	
	private StatusTarefa(Integer pValue, String pDescricao) {
		this.value = pValue;
		this.descricao = pDescricao;		
	}

	public Integer getValue() {
		return value;
	}

	public String getDescricao() {
		return descricao;
	}

	static StatusTarefa get(Integer id) {
		for(StatusTarefa atual:values()) {
			if(atual.getValue() == id) {
				return atual;
			} 			
		}
		return null;
	}	
		

}
