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

@WebServlet("/excluir")
public class ExcluirCoordenadoresController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String id = req.getParameter("id");

			Integer idValue = Integer.parseInt(id);
			int indice = -1;
			for (int i = 0; i < CoordenadoresDao.getList().size(); i++) {
				if (CoordenadoresDao.getList().get(i).getId() == idValue) {
					indice = i;
					break;

				}
			}
			if (indice != -1) {
				CoordenadoresDao.getList().remove(indice);

			} else {
				throw new ValidarException("posição não encontrada");
			}

			System.out.println(CoordenadoresDao.getList());
			resp.sendRedirect("./index.jsp");

		} catch (NullPointerException e) {
			req.setAttribute("erroExist", "não tem coordenador cadastrado");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./removerCoordenador.jsp");
			requestDispatcher.forward(req, resp);
		} catch (ValidarException e) {
			req.setAttribute("erroId", "o id do coordenador não existe");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./removerCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		} catch(NumberFormatException e) {
			req.setAttribute("erroId", "coloque apenas numero meu casa");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./removerCoordenador.jsp");
			requestDispatcher.forward(req, resp);
			
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("coordenadores", CoordenadoresDao.getList());

		req.getRequestDispatcher("./removerCoordenador.jsp").forward(req, resp);

	}

}
