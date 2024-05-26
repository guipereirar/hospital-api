package br.edu.senaisp.Hospital.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=2, max=125)
	private String nome;
	
	@NotNull
	@Size(min=1, max=6)
	private String crm;
	
	@OneToMany(mappedBy = "medico")
	private List<Especialidade> especialidades = new ArrayList<Especialidade>();
	
	public Medico() {
		
	}

	public Medico(@NotNull @Size(min = 2, max = 125) String nome,
			@NotNull @Size(min = 1, max = 6) String crm) {
		this.nome = nome;
		this.crm = crm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
	
}
