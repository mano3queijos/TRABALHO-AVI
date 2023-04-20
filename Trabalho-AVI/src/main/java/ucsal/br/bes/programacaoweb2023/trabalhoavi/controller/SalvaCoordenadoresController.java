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

@WebServlet("/salvar")
public class SalvaCoordenadoresController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	Aqui precisa ter apenas um dopost, pq preciso fazer a confirmação das outras

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setAttribute("coordenadores", CoordenadoresDao.getList());

		req.getRequestDispatcher("exibirCoordenadores.jsp").forward(req, resp);

	}

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

			Coordenador coordenador = new Coordenador(nome, cursos, pd);

			CoordenadoresDao.adicionar(coordenador);

			req.getSession().setAttribute("coordenadores", CoordenadoresDao.getList());
			resp.sendRedirect("./index.jsp");

		} catch (ValidarException e) {

			req.setAttribute("erroCadastro", "Nenhum campo pode estar vazio, coordenador não cadastrado");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		} catch (NumberFormatException e) {

			req.setAttribute("erroQtd", "Formato inserido invalido");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		}

	}
}
