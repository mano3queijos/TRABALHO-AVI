<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
<jsp:useBean id="Coordenadores" scope="session"
	class="java.util.ArrayList"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmação ID do Coordenador</title>
</head>


<section class="d-flex">
	<div class="container">
		<div class="row justify-content-center">



			<table class="table table-hover table-bordered w-75 mx-auto"
				style="font-size: 18px;">

				<thead class="table-dark">



					<tr>
						<th class="text-center" scope="col">Nome</th>
						<th class="text-center" scope="col">Cursos</th>
						<th class="text-center" scope="col">Disponibilidade</th>
						<th class="text-center" scope="col">Id</th>
					</tr>

				</thead>

				<tbody>

					<c:forEach var="coordenadores" items="${coordenadores}">
						<tr>
							<td class="text-center"><c:out value="${coordenadores.nome}" /></td>
							<td class="text-center"><c:out
									value="${coordenadores.cursos}" /></td>
							<td class="text-center"><c:out
									value="${coordenadores.disponibilidade}" /></td>
							<td class="text-center"><c:out value="${coordenadores.id}" /></td>

						</tr>
					</c:forEach>


				</tbody>




			</table>



			<form action="./editar" method="get" class="col col-md-12">


				<div class="form-group mb-0 mt-5">
					<label class="control-label h5" for="curso">Digite o Id do
						coordenador que deseja editar</label>


					<div>
						<input name="idCoordenador" placeholder="Id Coordenador"
							class="form-control" type="text" /> <span style="color: red;">${erro}</span><br>
					</div>

				</div>


			</form>


		</div>



	</div>
</section>



<body>














	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>



</body>
</html>