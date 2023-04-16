package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;

public class editarCoordenadores extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Coordenador> coordenadores = (List<Coordenador>) req.getSession().getAttribute("coordenadores");

		String id = req.getParameter("id");
		int idvalue = Integer.parseInt(id);
		Coordenador coordenador = null;
		for (int i = 0; i < coordenadores.size(); i++) {
			if (coordenadores.get(i).getId() == idvalue) {
				coordenador = coordenadores.get(i);
			}
		}
		req.setAttribute("coordenadores", coordenadores);

		req.getRequestDispatcher("removerCoordenador.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Coordenador> coordenadores = (List<Coordenador>) req.getSession().getAttribute("coordenadores");


		
	}

}
