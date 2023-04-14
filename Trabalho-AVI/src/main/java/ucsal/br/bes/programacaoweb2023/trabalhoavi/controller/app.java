package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Curso;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.PeriodoDisponibilidade;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.persistence.CoordenadoresDao;

@WebServlet("/app")
public class app extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String dataDisponibilidade = req.getParameter("dataDisponibilidade");
		String horaInicial = req.getParameter("horarioInicial");
		String horaFinal = req.getParameter("horaFinal");
		List<Curso> cursos = new ArrayList<>();
		List<PeriodoDisponibilidade> periodoDisponibilidade = new ArrayList<>();
		
		PeriodoDisponibilidade periodo = new PeriodoDisponibilidade(null, null, null); 
		
		
		
		
		
//		fazer conversão de string para ldt quando acordar, boa 10 horas de sono emaul s2
		for (int i = 0; i <= 10; i++) {
			String nomeCurso = req.getParameter("nomeCursos" + i);
			if (nomeCurso != null && !nomeCurso.isEmpty()) {
				Curso curso = new Curso(nomeCurso);
				cursos.add(curso);
			}
		}
		req.setAttribute("nomeCursos", cursos);
		req.getRequestDispatcher("index.jsp").forward(req, resp);

		Coordenador coordenador = new Coordenador(horaFinal, cursos, null);
		CoordenadoresDao.adicionar(coordenador);

		for (Coordenador coordenadowr : CoordenadoresDao.listarCoordenadores()) {
			System.out.println(coordenadowr);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String qtdCursos = req.getParameter("qtdCursos");

//		fazer get cursos quando voltar da praia

		try {

//			Transformando a string em numero, fazendo o tratamento de erro(caso exista) e mandando a quantidade de cursos escolhidos para a jsp que irá cadastra apenas cursos

			Integer numeroRepetir = Integer.parseInt(qtdCursos);
			Coordenador.validarQtdCuros(numeroRepetir);

			req.setAttribute("qtdCursos", numeroRepetir);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCursos.jsp");
			requestDispatcher.forward(req, resp);

		} catch (

		NumberFormatException e) {

			String mensagem = "Por favor, insira apenas numero";
			req.setAttribute("erro", mensagem);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
			requestDispatcher.forward(req, resp);

		} catch (ValidarException e) {
			req.setAttribute("erro", e.getMessage());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
			requestDispatcher.forward(req, resp);

		}

	}

}
