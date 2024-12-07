<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
				<a class="nav-link" href="<c:url value='/trang-chu'/>">Home
						<span class="sr-only">(current)</span>
				</a>
				</li>
				
				<!-- Có thể dùng: <security:authentication property="principal" var="auth" />
				c:if test="${empty auth}" OR:  
				isAnonymous() là method ktra xem đã login chưa.Nếu chưa thì đoạn code bên trong đc biên soạn -->
				<security:authorize access = "isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Sign up</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact </a></li>
				 </security:authorize>
				 <!--isAuthenticated() là method ktra xem đã login chưa.Nếu đã xác thực thì đoạn code bên trong đc biên soạn -->
				<security:authentication property="principal" var="auth" /><!--Chỉ định UserDetails iml từ của cải principal -->
				<security:authorize access = "isAuthenticated()">
					<!--Lấy info user đc set trong hệ thống ở object UserDetails -->
					<li class="nav-item"><a class="nav-link" href="#">Welcome, <c:out value="${auth.fullName}" /> </a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact </a></li>
				 </security:authorize>
			</ul>
		</div>
	</div>
</nav>
