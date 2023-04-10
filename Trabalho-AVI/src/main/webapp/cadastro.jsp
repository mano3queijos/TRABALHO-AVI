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
			<div class="row justify-content-md-center">
				<div class="col col-md-8">
					<form>
						<fieldset>
							<div class=" col-md-12 panel panel-primary">
								<div class="panel-heading mb-3">Cadastro de Coordenadores</div>
							</div>


							<div class="form-group mb-4">
								<label class="col-md-5 control-label" for="Nome">Nome do
									Coordenador </label>
								<div>
									<input id="Nome" name="Nome" placeholder="Nome do coordenador"
										class="form-control input-md" type="text">
								</div>
							</div>


							<div class="form-group mb-4">
								<label class="col-md-4 control-label" for="curso">Curso
									a coordenar</label>
								<div>
									<input id="curso" name="curso" placeholder="Curso a Coordenar"
										class="form-control input-md" type="text">
								</div>
							</div>



							<div class="form-group mb-4">
								<label class="col-md-5 control-label" for="date">Data de
									disponibilidade</label>

								<div>
									<input id="Data" name="Data" placeholder="Data disponibilidade"
										class="form-control input-md" type="text">
								</div>

							</div>


							<script type="text/javascript">
								$(function() {
									$('#datepicker').datepicker();
								})
							</script>



							<div class="form-group mb-1">
								<label class="col-md-4 control-label" for="Nome">Hoário
									de disponibilidade</label>
								<div>
									<input id="Nome" name="Nome"
										placeholder="Horário Disponibilidade"
										class="form-control input-md" type="text">
								</div>
							</div>






							<!-- 	<div class="form-group">


								<label class="col-md-5 control-label" for="qtdCursos">
									Quantidade cursos a coordenar</label>
								<div>

									<select class="form-control  col-md-4"
										id="exampleFormControlSelect1">

										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>

									</select>


								</div>
							</div> -->


							<div class="form-group">
								<label class="col-md-2 control-label" for="prosseguir"></label>
								<div class="col-md-8">
									<button id="Prosseguir" name="prosseguir"
										class="btn btn-success" type="Submit">prosseguir</button>
								
									

									<button id="Cancelar" name="Cancelar" class="btn btn-danger"
										type="Reset">Cancelar</button>
								</div>
							</div>
						</fieldset>
					</form>

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