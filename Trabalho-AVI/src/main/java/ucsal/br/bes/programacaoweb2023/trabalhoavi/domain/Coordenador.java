package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import jakarta.servlet.RequestDispatcher;

public class Coordenador {

	private Integer id;
	private String nome;
	private List<Curso> cursos = new ArrayList<>();
	private List<PeriodoDisponibilidade> disponibilidade = new ArrayList<>();

	private static int index = 0;

	public Coordenador(String nome, List<Curso> cursos, List<PeriodoDisponibilidade> disponibilidade) {

		index = index + 1;
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

	public static void validarCadastroCursos(String nome, String dia, String horaInicial, String horaFinal)
			throws ValidarException {

		if (nome == null | dia == null | horaInicial == null | horaFinal == null) {
			String mensagem = "Nenhum campo não pode estar vazio, coordenador não cadastrado";
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
		return "nome=" + nome + ", cursos=" + cursos + ", disponibilidade=" + disponibilidade;
	}

}