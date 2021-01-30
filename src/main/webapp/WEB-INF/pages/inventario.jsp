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
						<h2>Monitor de productos</h2>
					</div>
				</div>
				<!-- ***************************************************************** -->
				<!-- ******************        FILTRADO      ************************* -->
				<!-- ***************************************************************** -->
				<div class="row my-5">
					<div class="col">
						<!-- 						<form action="/inventarios/filtrado" method="post"> -->
						<form action="/filtrado" method="post">
							<div class="form-row">
								<div class="col">
									<label for="estado_id">Almacenes</label> <select
										id="warehouseId" name="warehouseId" class="custom-select"
										required="required">
										<c:forEach var="tienda" items="${almacenes}">
											<option value="${tienda.warehouseId}">${tienda.warehouseName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col">
									<label for="categoryId">Categorias</label> <select
										id="categoryId" name="categoryId" class="custom-select"
										required="required">
										<c:forEach var="cat" items="${categorias}">
											<option value="${cat.categoryId}">${cat.categoryName}</option>
										</c:forEach>
									</select>
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
									<th scope="col">Almacen</th>
									<th scope="col">Id Producto</th>
									<th scope="col">Nombre Producto</th>
									<th scope="col">Precio Lista</th>
									<th scope="col">Costo Estandar</th>
									<th scope="col">Inventario</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="inventario" items="${inventarios}">
									<tr>
										<th scope="row">${inventario.inventoriesId}</th>
										<td>${inventario.warehouseId.warehouseName}</td>
										<td>${inventario.productId.productId}</td>
										<td>${inventario.productId.productsName}</td>
										<td>${inventario.productId.listPrice}</td>
										<td>${inventario.productId.standarCost}</td>
										<td>${inventario.quantity}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal">Registrar nuevo inventario</button>
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
								<h5 class="modal-title" id="exampleModalLabel">Nuevo
									inventario</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form action="/inventarios" method="post">
								<div class="modal-body">

									<div class="form-group row">
										<div class="col">
											<select id="productId" name="productId" class="custom-select"
												required="required">
												<c:forEach var="prd" items="${productos}">
													<option value="${prd.productId}">${prd.productsName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<div class="col">
											<select id="warehouseId" name="warehouseId" class="custom-select"
												required="required">
												<c:forEach var="alm" items="${almacenes}">
													<option value="${alm.warehouseId}">${alm.warehouseName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-10">
											<input type="number" class="form-control form-control-user"
												id="quantity" name="quantity" placeholder="Cantidad" required="required">
										</div>
									</div>
									<hr>
								</div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary " disabled value="registrar">
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