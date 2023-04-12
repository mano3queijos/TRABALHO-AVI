package ucsal.br.bes.programacaoweb2023.trabalhoavi.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class app extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String dataDisponibilidade = req.getParameter("dataDisponibilidade");
		String horaInicial = req.getParameter("horarioInicial");
		String horaFinal = req.getParameter("horaFinal");
		String qtdCursos = req.getParameter("qtdCursos");

		try {
			Integer numeroRepetir = Integer.parseInt(qtdCursos);

			if (numeroRepetir != 0 && numeroRepetir > 0 && numeroRepetir <= 10) {
				req.setAttribute("qtdCursos", numeroRepetir);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCursos.jsp");
				requestDispatcher.forward(req, resp);

			} else if (numeroRepetir > 10) {

				String mensagem = "O coordenador não pode coordenar mais de 10 cursos por vês";
				req.setAttribute("erro", mensagem);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
				requestDispatcher.forward(req, resp);

			} else if (numeroRepetir == 0) {

				String mensagem = "O coordenador precisa coordenar pelo menos um curso";
				req.setAttribute("erro", mensagem);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
				requestDispatcher.forward(req, resp);
			} else if (numeroRepetir < 0) {

				String mensagem = "O coordenador não pode coordenar um numero negativo de cursos";
				req.setAttribute("erro", mensagem);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
				requestDispatcher.forward(req, resp);
			}

		} catch (

		NumberFormatException e) {

			String mensagem = "Por favor, insira apenas numero";
			req.setAttribute("erro", mensagem);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
