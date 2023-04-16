package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.persistence.CoordenadoresDao;

@WebServlet("/excluirCoordenadores")
public class ExcluirCoordenadoresController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");

		int indice = -1;
		for (int i = 0; i < CoordenadoresDao.listarCoordenadores().size(); i++) {
			if (CoordenadoresDao.listarCoordenadores().get(i).getNome().equals(nome)) {
				indice = i;

			}
		}
		if (indice != -1)
			CoordenadoresDao.listarCoordenadores().remove(indice);
		resp.sendRedirect("/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setAttribute("coordenadores", CoordenadoresDao.listarCoordenadores());
		
		req.getRequestDispatcher("removerCoordenador.jsp").forward(req, resp);;
		
	}

}
