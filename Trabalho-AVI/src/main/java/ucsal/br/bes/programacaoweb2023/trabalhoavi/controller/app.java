package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import br.ucsal.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;

@WebServlet("/app")
public class app extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String dataDisponibilidade = req.getParameter("dataDisponibilidade");
		String horaInicial = req.getParameter("horarioInicial");
		String horaFinal = req.getParameter("horaFinal");
		String qtdCursos = req.getParameter("qtdCursos");
		String nomeCurso = req.getParameter("nomeCurso");

//		fazer get cursos quando voltar da praia

		try {

//			Transformando a string em numero, fazendo o tratamento de erro(caso exista) e mandando a quantidade de cursos escolhidos para a jsp que irá cadastra apenas cursos

			Integer numeroRepetir = Integer.parseInt(qtdCursos);
			Coordenador.validarQtdCuros(numeroRepetir);

			req.setAttribute("qtdCursos", numeroRepetir);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCursos.jsp");
			requestDispatcher.forward(req, resp);

			List<String> cursos = new ArrayList<>();
			Enumeration<String> parametros = req.getParameterNames();
			while (parametros.hasMoreElements()) {
				String parametro = parametros.nextElement();
				if (parametro.startsWith("nomeCursos-")) {
					cursos.add(req.getParameter(parametro));

				}
			}
//			req.setAttribute("nomeCursos", cursos);
//			req.getRequestDispatcher("exibirNomes.jsp").forward(req, resp);

			/*
			 * Curso curso = new Curso(nomeCurso);
			 */
//			Coordenador coordenador = new Coordenador(nomeCurso, cursos, null);
			/*
			 * coordenador.getCursos().add(curso);
			 * 
			 * System.out.println(coordenador); System.out.println(cursos);
			 */
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
