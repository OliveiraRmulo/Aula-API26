package org.serratec.aula05.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "A placa é obrigatória")
	@Size(max = 7)
	@Column(nullable = false, length = 7)
	private String placa;
	
	@NotBlank(message = "A marca é obrigatória")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String marca;
	
	@Embedded
	private Caracteristica caracteristica;
	
	@OneToOne
	@JsonManagedReference
	@JoinColumn(name = "id_proprietario")
	private Proprietario proprietario;
	
	@OneToMany(mappedBy = "veiculo")
	@JsonBackReference
	private List<Manutencao> manutencoes;

	public Veiculo() {
		super();
	}

	public Veiculo(Long id, @NotBlank(message = "A placa é obrigatória") @Size(max = 7) String placa,
			@NotBlank(message = "A marca é obrigatória") @Size(max = 30) String marca, Caracteristica caracteristica) {
		super();
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.caracteristica = caracteristica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	
}
