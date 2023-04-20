package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.util.ArrayList;
import java.util.List;

import ucsal.br.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;

public class Coordenador {

	private Integer id;
	private String nome;
	private String cursos;
	private List<PeriodoDisponibilidade> disponibilidade = new ArrayList<>();

	private static int index = 0;

	public Coordenador(String nome, String cursos, List<PeriodoDisponibilidade> disponibilidade) {

		index = index + 1;
		this.id = index;
		this.nome = nome;
		this.cursos = cursos;
		this.disponibilidade = disponibilidade;
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

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

	public List<PeriodoDisponibilidade> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(List<PeriodoDisponibilidade> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public static void validarQtdHorario(Integer qtdHorarios) throws ValidarException {

		if (qtdHorarios > 5) {

			String mensagem = "O coordenadordenar mais de 10 cursos por vês";
			throw new ValidarException(mensagem);

		} else if (qtdHorarios == 0 || qtdHorarios == null) {

			String mensagem = "O coordenador precisa coordenar pelo menos um curso";
			throw new ValidarException(mensagem);

		} else if (qtdHorarios < 0) {

			String mensagem = "O coordenador não pode coordenar um numero negativo de cursos";
			throw new ValidarException(mensagem);

		}

	}

	public static void validarQtdHorarios(String dia, String horaInicial, String horaFinal)
			throws ValidarException {

		if (dia == null || dia.isEmpty() || horaInicial == null || horaFinal == null|| horaFinal.isEmpty() || horaInicial.isEmpty() ) {
			String mensagem = "Nenhum campo pode estar vazio, coordenador não cadastrado";
			throw new ValidarException(mensagem);
		}

	}

	public static void validarNomeCurso(String nomeCurso) throws ValidarException {

		if (nomeCurso == null) {
			String mensagem = "Nenhum campo pode estar vazio, coordenador não cadastrado";
			throw new ValidarException(mensagem);
		}

	}

	@Override
	public String toString() {
		return "nome=" + nome + ", cursos=" + cursos + ", disponibilidade=" + disponibilidade + ", id= " + id;
	}

}