<%@page
	import="ucsal.br.bes.programacaoweb2023.trabalhoavi.controller.SalvaCoordenadoresController"%>
<%@page
	import="ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador"%>
<%@page
	import="ucsal.br.bes.programacaoweb2023.trabalhoavi.exception.ValidarException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="Coordenadores" scope="session"
	class="java.util.ArrayList"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="Style.css">
<title>cadastro de coordenadores</title>
</head>
<body>


	<%
	// tive q usar scriplet aqui, desculpa
		// Verifica se o usuário informou a quantidade de cursos
		try {
			String qtdCursosStr = request.getParameter("qtdCursos");
			int qtdCursos = 0;
			if (qtdCursosStr != null && !qtdCursosStr.isEmpty()) {
		qtdCursos = Integer.parseInt(qtdCursosStr);
		Coordenador.validarQtdHorario(qtdCursos);
			}

		} catch (NumberFormatException e) {

			String mensagem = "Por favor, insira apenas numero";
			request.setAttribute("erroNumFormat", mensagem);

		} catch (ValidarException e) {
			request.setAttribute("erroValid", e.getMessage());

		}
	%>

	<c:set var="qtdCursosForm" value="${not empty param.quantidade}" />

	<section class="d-flex">
		<div class="container">
			<div class="row justify-content-center">


				<form method="post" class="col col-md-10">


					<div class="panel panel-primary">
						<div class="mb-3 display-3 h5">Editar Coordenador</div>
					</div>

					<div class="form-group mb-4">
						<label class="col-md-5 control-label h5" for="quantidade">Quantidade
							Cursos:</label> <input type="number" class="form-control" id="quantidade"
							name="quantidade" min="1" max="10"><br>

						<button type="submit" name="Cancelar" class="btn btn-primary"
							type="submit">confirmar</button>
						<%-- <span style="color: red;">${erroNumFormat}</span> <span
							style="color: red;">${erroValid}</span> <br> <span
							style="color: red;">${erroQtd}</span> <br> --%>
					</div>
				</form>

				<form action="./editar" method="post" class="col col-md-10">


					//id <input type="text" name="id"
						value="<%= request.getAttribute("id") %>"
						<c:if test="${not qtdCursosForm}">disabled</c:if> />

					<div class="form-group mb-4">
						<label class="control-label h5" for="Nome"> Nome do
							Coordenador </label>



						<div>
							<input name="nome" placeholder="Nome do coordenador"
								class="form-control" type="text"
								<c:if test="${not qtdCursosForm}">disabled</c:if>> <span
								style="color: red;">${erro}</span><br>
						</div>
					</div>


					<div class="form-group mb-4">
						<label class="col-md-5 control-label h5" for="dia">Data de
							disponibilidade</label>

						<div>
							<input name="dia" placeholder="Data disponibilidade"
								class="form-control" type="text"
								<c:if test="${not qtdCursosForm}">disabled</c:if>> <span
								style="color: red;">${erro}</span><br>
						</div>

					</div>



					<div class="row">

						<div class="form-group mb-4 col-md-6">
							<label class="control-label h5" for="curso">Horario
								inicial</label>
							<div>
								<input name="horarioInicial" placeholder="horario inicial"
									class="form-control" type="text"
									<c:if test="${not qtdCursosForm}">disabled</c:if>> <span
									style="color: red;">${erro}</span><br>
							</div>
						</div>

						<div class="form-group mb-4 col-md-6">


							<label class="control-label h5" for="curso">Horario final</label>
							<div>
								<input name="horaFinal" placeholder="horario final"
									class="form-control" type="text"
									<c:if test="${not qtdCursosForm}">disabled</c:if>> <span
									style="color: red;">${erro}</span><br>
							</div>
						</div>


					</div>





					<div class="form-group mb-4 col-md-6">
						<label class="col-md-5 control-label h5" for="curso">Cadastrar
							curso</label>

						<c:if test="${not empty param.quantidade}">
							<c:set var="qtdCursos" value="${param.quantidade}" />
							<input type="hidden" name="qtdCursos" value="${qtdCursos}" />

							<c:forEach begin="0" end="${qtdCursos-1}" varStatus="loop">
								<input type="text" name="nomeCursos${loop.index}"
									placeholder="Cadastrar Curso" class="form-control mb-4"
									<c:if test="${not qtdCursosForm}">disabled</c:if>>
								<br>
							</c:forEach>
						</c:if>


					</div>


					<label class="col-md-2 control-label" for="prosseguir"></label>

					<h1>
						<span style="color: red;">${erroCadastro}</span><br>
					</h1>

					<div class="col-md-8">
						<button type="submit" name="prosseguir" class="btn btn-success"
							type="Submit">Salvar Coordenador</button>


						<a href="./index.jsp">


							<button type="button" name="Cancelar" class="btn btn-danger"
								type="submit">Cancelar</button>
						</a>


					</div>

				</form>




			</div>
		</div>

	</section>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>