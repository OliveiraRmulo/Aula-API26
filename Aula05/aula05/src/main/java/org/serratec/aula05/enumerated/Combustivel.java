package org.serratec.aula05.enumerated;

import org.serratec.aula05.execption.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Combustivel {

	ALCOOL(1, "Álcool"),
	GASOLINA(2, "Gasolina"),
	DIESEL(3, "Diesel"),
	FLEX(4, "Flex");
	
	private Integer codigo;
	private String tipo;
	
	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	@JsonCreator
	public static Combustivel verifica(Integer value) throws EnumValidationException {
		for (Combustivel c : values()) {
			if (value.equals(c.getCodigo())) {
				return c;
			}
		}
		throw new EnumValidationException(
				"Combustível inválido. Valores válidos: 1 - Álcool, 2 - Gasolina, 3 - Diesel, 4 - Flex");
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
