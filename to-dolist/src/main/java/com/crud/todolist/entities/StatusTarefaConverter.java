package com.crud.todolist.entities;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusTarefaConverter implements AttributeConverter<StatusTarefa, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusTarefa status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public StatusTarefa convertToEntityAttribute(Integer value) {
        if (value == null) {
            return null;
        }
        return StatusTarefa.get(value);
    }
}
