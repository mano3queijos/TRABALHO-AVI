package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.persistence.CoordenadoresDao;

@WebServlet("/listarCoordenadores")
public class ListarCoordenadores extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setAttribute("coordenadores", CoordenadoresDao.listarCoordenadores());
		
		req.getRequestDispatcher("exibirCoordenadores.jsp").forward(req, resp);;
	}

}
