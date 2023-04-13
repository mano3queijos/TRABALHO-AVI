package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

public class Curso {

	private String nomeCurso;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(String nomeCurso) {
		super();
		this.nomeCurso = nomeCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "Curso [nomeCurso=" + nomeCurso + "]";
	}

}