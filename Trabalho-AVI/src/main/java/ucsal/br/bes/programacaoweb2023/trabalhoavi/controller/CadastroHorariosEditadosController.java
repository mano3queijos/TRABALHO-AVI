package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;

@WebServlet("/editarQtdH")
public class CadastroHorariosEditadosController extends HttpServlet {

	static Integer qtdRep = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String qtdHorario = req.getParameter("qtdHorario");
			Integer qtd = Integer.parseInt(qtdHorario);
			Coordenador.validarQtdHorario(qtd);
			qtdRep = qtd;
			HttpSession session = req.getSession();
			session.setAttribute("qtdHorario", qtd);
			req.setAttribute("qtdHorario", qtd);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./editarCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		} catch (ValidarException e) {
			req.setAttribute("erroQtd", e.getMessage());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./salvarQtdHorario.jsp");
			requestDispatcher.forward(req, resp);

		} catch (NumberFormatException e) {

			req.setAttribute("erroQtd", "O campo não pode ser nulo");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./salvarQtdHorario.jsp");
			requestDispatcher.forward(req, resp);

		}
	}

}
