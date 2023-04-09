package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.util.ArrayList;
import java.util.List;

public class Coordenador {

	private String nome;
	private List<Curso> cursos = new ArrayList<>();
	private List<PeriodoDisponibilidade> disponibilidade = new ArrayList<>();

	public Coordenador() {
		// TODO Auto-generated constructor stub
	}

	public Coordenador(String nome, List<Curso> cursos, List<PeriodoDisponibilidade> disponibilidade) {
		super();
		this.nome = nome;
		this.cursos = cursos;
		this.disponibilidade = disponibilidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<PeriodoDisponibilidade> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(List<PeriodoDisponibilidade> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
