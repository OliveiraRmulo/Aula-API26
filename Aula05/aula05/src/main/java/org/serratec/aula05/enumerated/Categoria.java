package org.serratec.aula05.enumerated;

import org.serratec.aula05.execption.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {

	HATCH,
	SEDAN,
	PICAPE,
	SUV;
	
	@JsonCreator
	public static Categoria verifica(String value) throws EnumValidationException {
		for (Categoria c : values()) {
			if( value.equals(c.name())) {
				return c;
			}
		}
		throw new EnumValidationException(
				"Categoria inválida. Valores válidos: HATCH, SEDAN, PICAPE, SUV");
	}
}
