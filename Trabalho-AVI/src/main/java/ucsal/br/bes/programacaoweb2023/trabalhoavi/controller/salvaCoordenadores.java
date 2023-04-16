package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class salvaCoordenadores extends HttpServlet {

	private boolean acaoRealizada = false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	Aqui precisa ter apenas um dopost, pq preciso fazer a confirmação das outras

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Coordenador> coordenadores = (List<Coordenador>) req.getSession().getAttribute("coordenadores");

//		
//		teste listar coordenadores
		req.setAttribute("coordenadores", coordenadores);

		req.getRequestDispatcher("exibirCoordenadores.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {

			List<Curso> cursos = new ArrayList<>();
			for (int i = 0; i <= 10; i++) {
				String nomeCurso = req.getParameter("nomeCursos" + i);
				if (nomeCurso != null && !nomeCurso.isEmpty()) {
					Curso curso = new Curso(nomeCurso);
					cursos.add(curso);
				}
			}

			List<PeriodoDisponibilidade> periodoDisponibilidade = new ArrayList<>();
			String dia = req.getParameter("dia");

			String horaInicial = req.getParameter("horarioInicial");

			String horaFinal = req.getParameter("horaFinal");
			String nome = req.getParameter("nome");

			PeriodoDisponibilidade periodo = new PeriodoDisponibilidade(dia, horaInicial, horaFinal);
			periodoDisponibilidade.add(periodo);

			Coordenador coordenador = new Coordenador(nome, cursos, periodoDisponibilidade);

			CoordenadoresDao.adicionar(coordenador);

			req.getSession().setAttribute("coordenadores", CoordenadoresDao.listarCoordenadores());

			resp.sendRedirect("./index.jsp");

		} catch (Exception e) {
			req.setAttribute("erroCadastro", e.getMessage());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
			requestDispatcher.forward(req, resp);

		}

	}
}
