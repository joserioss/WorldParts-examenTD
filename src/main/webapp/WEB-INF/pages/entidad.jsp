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
						<h2>Entidades</h2>
					</div>
				</div>
				<!-- ***************************************************************** -->
				<!-- ******************        FILTRADO      ************************* -->
				<!-- ***************************************************************** -->
				<div class="row my-5">
					<div class="col">
<!-- 						<form action="/entidades/filtrado" method="post"> -->
							<form action="/filtrado" method="post">
							<div class="form-row">
								<div class="col">
									<label for="fecha_desde">Fecha desde</label> <input
										id="fecha_desde" name="fecha_desde" type="date"
										class="form-control" placeholder="Last name"
										required="required">
								</div>
								<div class="col">
									<label for="fecha_hasta">Fecha hasta</label> <input
										id="fecha_hasta" name="fecha_hasta" type="date"
										class="form-control" placeholder="Last name"
										required="required">
								</div>
							</div>
							<div class="row my-3">
								<div class="col">
									<button type="submit" class="btn btn-secondary">Buscar</button>
								</div>
							</div>
						</form>
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
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Registrar nueva entidad</button>
				<a href="/">
					<button type="button" class="btn btn-danger">volver</button>
				</a>

				<!-- ***************************************************************** -->
				<!-- ******************     MODAL REGISTRO   ************************* -->
				<!-- ***************************************************************** -->
				
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Nueva
									entidad</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form action="/entidades" method="post">
								<div class="modal-body">

									<div class="form-group row">
										<div class="col-sm-10">
											<input type="text" class="form-control form-control-user"
												id="nombre" name="nombre" placeholder="Nombre" required="required">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-10">
											<input type="text" class="form-control form-control-user"
												id="apellido" name="apellido" placeholder="Apellido" required="required">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-10">
											<input type="number" class="form-control form-control-user"
												id="edad" name="edad" placeholder="Edad" required="required">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-10">
											<input id="fecha" name="fecha" type="date"
												class="form-control" placeholder="Fecha de inscripcion"
												required="required">
										</div>

									</div>
									<div class="form-group row"></div>
									<hr>


								</div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary" value="registrar">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- ***************************************************************** -->
				<!-- ******************   # MODAL REGISTRO   ************************* -->
				<!-- ***************************************************************** -->
				
				
				
			</div>
		</div>
	</div>

	<!-- footer scripts -->
	<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
	<!-- footer scripts -->
</body>
</html>