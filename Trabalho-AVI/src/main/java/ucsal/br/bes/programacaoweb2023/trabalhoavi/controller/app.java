package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

	private boolean acaoRealizada = false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	Aqui precisa ter apenas um dopost, pq preciso fazer a confirmação das outras
	

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

			String dataDisponibilidade = req.getParameter("dataDisponibilidade");
			String horaInicial = req.getParameter("horarioInicial");
			String horaFinal = req.getParameter("horaFinal");
			List<PeriodoDisponibilidade> periodoDisponibilidade = new ArrayList<>();

			PeriodoDisponibilidade periodo = new PeriodoDisponibilidade(dataDisponibilidade, horaInicial, horaFinal);
			periodoDisponibilidade.add(periodo);

			String nome = req.getParameter("nome");
			Coordenador coordenador = new Coordenador(nome, cursos, periodoDisponibilidade);
			CoordenadoresDao.adicionar(coordenador);
//			
//			teste listar coordenadores
//			req.setAttribute("coordenadores", CoordenadoresDao.listarCoordenadores());
//			
//			req.getRequestDispatcher("exibirCoordenadores.jsp").forward(req, resp);;

			for (Coordenador mostra : CoordenadoresDao.listarCoordenadores()) {
				System.out.println(mostra);
			}

		} catch (Exception e) {
			System.out.println("eu não faço a minima ideia kkkkkkkkkkkkk");

		}

		

	}
}
