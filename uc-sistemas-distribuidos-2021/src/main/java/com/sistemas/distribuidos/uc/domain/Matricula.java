package com.sistemas.distribuidos.uc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Matricula {

	@EmbeddedId
	MatriculaPK id;

	String semestre;

	public MatriculaPK getId() {
		return id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", semestre=" + semestre + "]";
	}

}
