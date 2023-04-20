<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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
	<!-- Precisa FAZER MUUUUITA COISA AINDA MDS ainda(09/04/2023) -->

	<section class="d-flex">
		<div class="container">
			<div class="row justify-content-center">

				<div class="panel panel-primary col-md-12">
					<div class="mb-3 display-3 h5">Menu Inicial</div>
				</div>

				<div>


					<a href="./salvarQtdHorario.jsp">
						<button type="button" class="btn btn-primary btn-lg btn-block">Cadastrar
							Coordenador</button>
					</a>

					<form action="./salvar" method="get">
						<button type="submit" class="btn btn-primary btn-lg btn-block">Exibir
							coordenadores Cadastrados</button>
					</form>


					<form action="./excluir" method="get">
						<button type="submit" class="btn btn-primary btn-lg btn-block">excluir
							coordenadores</button>
					</form>


					<a href="./confirmarIdCoordenador.jsp">
						<button type="submit" class="btn btn-primary btn-lg btn-block">Editar
							Coordenadores</button>

					</a>


				</div>



			</div>
		</div>



	</section>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>
