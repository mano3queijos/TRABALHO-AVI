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

	<section class="d-flex">
		<div class="container">
			<div class="row justify-content-center">

				<form action="./app" method="get" class="col col-md-10">

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


					<div class="form-group mb-4">
						<label class="col-md-5 control-label h5" for="dia">Data
							de disponibilidade</label>

						<div>
							<input name="dia" placeholder="Data disponibilidade"
								class="form-control" type="text">
						</div>

					</div>



					<div class="row">

						<div class="form-group mb-4 col-md-6">
							<label class="control-label h5" for="curso">Horario
								inicial</label>
							<div>
								<input name="horarioInicial" placeholder="horario inicial"
									class="form-control" type="text">
							</div>
						</div>

						<div class="form-group mb-4 col-md-6">


							<label class="control-label h5" for="curso">Horario final</label>
							<div>
								<input name="horaFinal" placeholder="horario final"
									class="form-control" type="text">
							</div>
						</div>


					</div>

					<div class="form-group mb-4 col-md-6">
						<label class="col-md-5 control-label h5" for="curso">Cadastrar
							curso</label>


						<c:forEach begin="0" end="${qtdCursos-1}" varStatus="loop">

							<input name="nomeCursos${loop.index}"
								placeholder="Cadastrar Curso" class="form-control mb-4">

						</c:forEach>


						<div class="form-group">
							<label class="col-md-2 control-label" for="prosseguir"></label>
							<div class="col-md-8">
								<button type="submit" name="prosseguir" class="btn btn-success"
									type="Submit">prosseguir</button>


								<button type="submit" name="Cancelar" class="btn btn-danger"
									type="submit">Cancelar</button>
							</div>
						</div>


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