package ucsal.br.bes.programacaoweb2023.trabalhoavi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.ucsal.bes.programacaoweb2023.trabalhoavi.exception.ValidarException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;

@WebServlet("/salva")
public class SalvarQtdcursos extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

//			Transformando a string em numero, fazendo o tratamento de erro(caso exista) e mandando a quantidade de cursos escolhidos para a jsp que irá cadastra apenas cursos
			String qtdCursos = req.getParameter("qtdCursos");
			Integer numeroRepetir = Integer.parseInt(qtdCursos);
			Coordenador.validarQtdCuros(numeroRepetir);

			req.setAttribute("qtdCursos", numeroRepetir - 1);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCursos.jsp");
			requestDispatcher.forward(req, resp);

		} catch (NumberFormatException e) {

			String mensagem = "Por favor, insira apenas numero";
			req.setAttribute("erro", mensagem);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
			requestDispatcher.forward(req, resp);

		} catch (ValidarException e) {
			req.setAttribute("erro", e.getMessage());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastro.jsp");
			requestDispatcher.forward(req, resp);

		}

	}

}
