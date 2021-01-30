<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/navar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="row my-5">
					<div class="col">
						<h2>-</h2>
						<h2>Entidade Filtradas</h2>
					</div>
				</div>

				<!-- ***************************************************************** -->
				<!-- ******************    TABLA REGISTROS   ************************* -->
				<!-- ***************************************************************** -->
				<div class="row">
					<div class="col">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">#</th>
									<th scope="col">Nombre</th>
									<th scope="col">Apellido</th>
									<th scope="col">Edad</th>
									<th scope="col">Fecha de inscripcion</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="entidad" items="${entidades}">
									<tr>
										<th scope="row">${entidad.idEntidad}</th>
										<td>${entidad.nombre}</td>
										<td>${entidad.apellido}</td>
										<td>${entidad.edad}</td>
										<td>${entidad.fecha}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
				<a href="/entidades">
					<button type="button" class="btn btn-danger">volver</button>
				</a>
			</div>

		</div>
	</div>

	<!-- footer scripts -->
	<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
	<!-- footer scripts -->
</body>
</html>