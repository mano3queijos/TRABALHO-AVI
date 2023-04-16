package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;

@WebServlet("/excluirCoordenadores")
public class ExcluirCoordenadoresController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Coordenador> coordenadores = (List<Coordenador>) req.getSession().getAttribute("coordenadores");

		String nome = req.getParameter("nome");

		int indice = -1;
		for (int i = 0; i < coordenadores.size(); i++) {
			if (coordenadores.get(i).getNome().equals(nome)) {
				indice = i;

			}
		}
		if (indice != -1)
			coordenadores.remove(indice);

		System.out.println(coordenadores);
		resp.sendRedirect("./index.jsp");
//		resp.sendRedirect("./exibirCoordenadores.jsp");
//

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Coordenador> coordenadores = (List<Coordenador>) req.getSession().getAttribute("coordenadores");


		req.setAttribute("coordenadores", coordenadores);

		req.getRequestDispatcher("removerCoordenador.jsp").forward(req, resp);
		

	}

}
