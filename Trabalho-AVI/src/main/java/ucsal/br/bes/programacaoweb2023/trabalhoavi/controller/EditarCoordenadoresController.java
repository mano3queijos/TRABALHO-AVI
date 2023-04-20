package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.PeriodoDisponibilidade;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.persistence.CoordenadoresDao;

@WebServlet("/editar")

public class EditarCoordenadoresController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String qtdHorario = req.getParameter("qtdHorario");
			Integer repQtdHorario = Integer.parseInt(qtdHorario);
			req.getSession().setAttribute("qtdHorario", qtdHorario);
			Coordenador.validarQtdHorario(repQtdHorario);
			CadastrarHorariosController.qtdRep = repQtdHorario;
			List<PeriodoDisponibilidade> pd = new ArrayList<>();

			for (int i = 1; i <= repQtdHorario; i++) {

				String horaInicial = req.getParameter("horarioInicial" + i);
				String horaFinal = req.getParameter("horaFinal" + i);
				String dia = req.getParameter("dia" + i);
				Coordenador.validarQtdHorarios(dia, horaInicial, horaFinal);
				PeriodoDisponibilidade periodo = new PeriodoDisponibilidade(dia, horaInicial, horaFinal);
				pd.add(periodo);
			}

			String cursos = req.getParameter("curso");

			String nome = req.getParameter("nome");

			for (int i = 0; i < CoordenadoresDao.getList().size(); i++) {

				if (CoordenadoresDao.getList().get(i).getId() == VerificarIdEdicao.index) {
					CoordenadoresDao.getList().get(i).setCursos(cursos);
					CoordenadoresDao.getList().get(i).setNome(nome);
					CoordenadoresDao.getList().get(i).setDisponibilidade(pd);

				}
			}

			resp.sendRedirect("./index.jsp");

		} catch (ValidarException e) {

			req.setAttribute("erroCadastro", e.getMessage());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		} catch (NumberFormatException e) {

			req.setAttribute("erroQtd", "O campo não pode ser nulo");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		}

	}
}
