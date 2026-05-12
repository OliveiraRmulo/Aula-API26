package org.serratec.aula04.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pagamento {

	@Autowired
	private Consulta consulta;
	
	@Autowired
	private Exame exame;
	
	public Double calcularProcedimento(Double valorConsulta, Double valorExame) {
		return consulta.calcularConsultar(valorConsulta)
				+ exame.calcularExame(valorExame);
	}
	
	public Double calcularProcedimento(Double valorConsulta, Double valorExame1,
				Double valorExame2) {
		return consulta.calcularConsultar(valorConsulta)
				+ exame.calcularExame(valorExame1, valorExame2);
	}
}
