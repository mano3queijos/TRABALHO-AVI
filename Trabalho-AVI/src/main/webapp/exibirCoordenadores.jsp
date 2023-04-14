<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="Coordenadores" scope="session"
	class="java.util.ArrayList"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostar lista coordenadores</title>
</head>
<body>



	<section>

		<div class="container">

			<div class="row justify-content-center">


				<table class="table table-striped-columns">

					<thead>

						<tr>

							<th>Nome</th>
							<th>Cursos</th>
							<th>dia</th>
							<th>Hora</th>

						</tr>

					</thead>

					<tbody>
						<c:forEach var="coordenadores" items="${coordenadores}">

							<td><c:out value="${coordenadores.nome}" /></td>
							<td><c:out value="${coordenadores.cursos}" /></td>
							<td><c:out value="${coordenadores.disponibilidade}" /></td>
						</c:forEach>






					</tbody>



				</table>


			</div>



		</div>


	</section>

</body>
</html>