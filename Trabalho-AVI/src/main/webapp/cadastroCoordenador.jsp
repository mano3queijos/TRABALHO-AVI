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
<title>cadastro de coordenadores</title>
</head>
<body>


	<c:set var="qtdHorario" value="${requestScope.qtdHorario}" />

	<section class="d-flex">
		<div class="container">
			<div class="row justify-content-center">



				<form action="./salvar" method="post" class="col col-md-10">


					<input type="text" name="qtdHorario" value="${qtdHorario}">
					<div class="panel panel-primary">
						<div class="mb-3 display-3 h5">Cadastro de Coordenadores</div>
					</div>
					<div class="form-group mb-4">
						<label class="control-label h5" for="Nome"> Nome do
							Coordenador </label>

						<div>
							<input name="nome" placeholder="Nome do coordenador"
								class="form-control" type="text">
						</div>
					</div>


					<div class="form-group mb-1 col-md-12">
						<label class="col-md-5 control-label h5" for="curso">
							cursos</label> <input type="text" name="curso"
							placeholder="Cadastrar Curso" class="form-control mb-4">
						<br>




					</div>

					<div class="form-group mb-4 col-md-12">
						<%-- 	<label class="col-md-12 control-label h5" for="curso">Cadastrar
							curso</label> <input type="hidden" name="qtdHorario"
							value="${qtdHorario}" />
 --%>
						<c:forEach begin="1" end="${qtdHorario}" varStatus="loop">

							<br>

							<h3 class="mb-4">Disponibilidade ${loop.index}</h3>

							<div class="row">
								<div class="form-group col-md-4">
									<label class="control-label h5">Dia </label>

									<div>
										<input name="dia${loop.index}"
											placeholder="Data disponibilidade" class="form-control"
											type="text">

									</div>

								</div>


								<div class="form-group mb-4 col-md-4">
									<label class="control-label h5">Horario inicial</label>
									<div>
										<input name="horarioInicial${loop.index}"
											placeholder="horario inicial" class="form-control"
											type="text">
									</div>
								</div>

								<div class="form-group mb-4 col-md-4">


									<label class="control-label h5">Horario final</label>
									<div>
										<input name="horaFinal${loop.index}"
											placeholder="horario final" class="form-control" type="text">
									</div>
								</div>
								<hr>


							</div>
						</c:forEach>



					</div>


					<label class="col-md-2 control-label" for="prosseguir"></label>

					<h1>
						<span style="color: red;">${erroCadastro}</span><br>
					</h1>
					<h1>
						<span style="color: red;">${erroQtd}</span><br>
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