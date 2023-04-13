package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import jakarta.servlet.RequestDispatcher;

public class Coordenador {

	private String nome;
	private List<Curso> cursos = new ArrayList<>();
	private List<PeriodoDisponibilidade> disponibilidade = new ArrayList<>();

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

	public static void validarQtdCuros(Integer qtdCursos) throws ValidarException {

		if (qtdCursos > 10) {

			String mensagem = "O coordenador não pode coordenar mais de 10 cursos por vês";
			throw new ValidarException(mensagem);

		} else if (qtdCursos == 0) {

			String mensagem = "O coordenador precisa coordenar pelo menos um curso";
			throw new ValidarException(mensagem);

		} else if (qtdCursos < 0) {

			String mensagem = "O coordenador não pode coordenar um numero negativo de cursos";
			throw new ValidarException(mensagem);

		}

	}

	@Override
	public String toString() {
		return "Coordenador [nome=" + nome + ", cursos=" + cursos + ", disponibilidade=" + disponibilidade + "]";
	}

}