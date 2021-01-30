<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="includes/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="includes/navar.jsp"></jsp:include>

	<div class="container">
		<div class="textHeader">
			<h1 class="display-1 font-weight-bold my-5">José Ríos Sánchez</h1>
			<p class="my-5">
				Ingeniero electrónico <br /> & Desarrollador full stack
			</p>
		</div>
		<div class="row">
			<div class="col">
				<h1>Examen de certificación  N°2</h1>
				<h3>Talento Digital Para Chile</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/entidades">
					<button type="button" class="btn btn-success">Ingreso JSP</button>
				</a>
			</div>
			<div class="col">
				<a href="/api/entidades">
					<button type="button" class="btn btn-success">Ingreso API Rest</button>
				</a>
			</div>
		</div>
	</div>

	<!-- footer scripts -->
	<jsp:include page="includes/footerscripts.jsp"></jsp:include>
	<!-- footer scripts -->

</body>
</html>