package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.persistence.CoordenadoresDao;


@WebServlet("/verificarId")
public class VerificarIdEdicao extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Integer index = 0;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			Integer posicaoEncontrada = -1;
			String id = req.getParameter("id");
			Integer idvalue = Integer.parseInt(id);
			index = idvalue;
			for (int i = 0; i < CoordenadoresDao.getList().size(); i++) {
				if (CoordenadoresDao.getList().get(i).getId() == idvalue) {
					posicaoEncontrada = i;
					req.setAttribute("id", idvalue);
					break;
				}
			}

			if (posicaoEncontrada != -1) {
				CoordenadoresDao.getList().get(posicaoEncontrada);
			} else {
				throw new ValidarException("posição não encontrada");
			}

			req.getRequestDispatcher("./editarQtdHorarios.jsp").forward(req, resp);

		} catch (ValidarException e) {
			req.setAttribute("erroId", "o id do coordenador não existe");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./confirmarIdCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		} catch (NumberFormatException e) {
			req.setAttribute("erroId", "Coloque apenas numero meu casa");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./confirmarIdCoordenador.jsp");
			requestDispatcher.forward(req, resp);
		}

	}
}
