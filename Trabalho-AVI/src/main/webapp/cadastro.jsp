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
				<form action="./salva" method="post" class="col col-md-10">


					<div class="panel panel-primary col-md-12">
						<div class="mb-3 display-3 h5">Cadastro de Coordenadores</div>
					</div>


					<div class="form-group mb-0">
						<label class="control-label h5" for="curso">Quantidade
							de cursos a coordenar</label>


						<div>
							<input name="qtdCursos" placeholder="Qtd cursos a coordenar"
								class="form-control" type="text" /> <span style="color: red;">${erro}</span><br>
						</div>

					</div>


					<div class="form-group">
						<label class="col-md-2 control-label" for="prosseguir"></label>
						<div class="col-md-8">
							<button type="submit" name="prosseguir" class="btn btn-success"
								type="Submit">prosseguir</button>


							<button type="submit" name="Cancelar" class="btn btn-danger"
								type="Reset">Cancelar</button>
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
