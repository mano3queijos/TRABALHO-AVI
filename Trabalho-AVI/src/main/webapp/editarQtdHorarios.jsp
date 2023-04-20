<%@page
	import="ucsal.br.bes.programacaoweb2023.trabalhoavi.controller.SalvaCoordenadoresController"%>
<%@page
	import="ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador"%>
<%@page
	import="ucsal.br.bes.programacaoweb2023.trabalhoavi.exception.ValidarException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<section class="d-flex">
		<div class="container">
			<div class="row justify-content-center">


					<input type="text" name="id" value="${id}">


				<form action="./editarQtdH" method="post" class="col col-md-10">
					<div class="panel panel-primary">
						<div class="mb-2 display-3 h5">Edição de coordenador de Coordenadores</div>
					</div>

					<div class="form-group mb-3">
						<label class="control-label h5" for="Nome"> Defina a
							quantidade de horários de disponibilidade de cada coordenador </label>

						<div>
							<input name="qtdHorario" placeholder="Qtd Horários"
								class="form-control" type="number" min="1" max="5" /> <span
								style="color: red;">${erroQtd}</span><br>
						</div>
					</div>


					<div class="col-md-8">
						<button type="submit" name="prosseguir" class="btn btn-success"
							type="Submit">Prosseguir</button>


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