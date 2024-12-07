<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<!--Lấy messege trên thanh trình duyệt hiện tại -->
			<!--Param là lấy tham số trên url mà thg security.xml chuyển hướng khi login fail -->
			<c:if test="${param.incorrectAccount != null}">
				<div class="alert alert-danger">
					<!--Cái này truyền danger:màu đỏ, success:màu xanh -->
					User or password incorrect
				</div>
			</c:if>
			<c:if test="${param.accessDenied != null}">
				<div class="alert alert-danger">
					<!--Cái này truyền danger:màu đỏ, success:màu xanh -->
					Not authorize!
				</div>
			</c:if>
			<!-- Icon -->
			<div class="fadeIn first">
				<h2>Đăng nhập</h2>
			</div>

			<!-- Login Form -->
			<!--/j_spring_security_check là tên url chứa method handle khi user nhập mk, tk  -->
			<!--khi nộp mk, tk thì mk, tk sẽ đến file security.xml dựa vào url /j_spring_security_check chứa method handle khi nhập mk, tk đúng và đến url /dang-nhap?incorrectAccount khi nhập tk, mk sai-->
			<form  action="<c:url value='j_spring_security_check?${_csrf.parameterName}=${_csrf.token}'/>" id="formLogin" method="post">
				<!-- id dùng để submit bằng jquery và name dùng để ánh xạ sang server -->
				 <c:if test="${not empty requestScope.UserName}">
        			<input type="text" id="userName" class="fadeIn second" name="j_username" placeholder="Email address" value="${requestScope.UserName}">
   				 </c:if>
				<c:if test="${empty requestScope.UserName}">
        			<input type="text" id="userName" class="fadeIn second" name="j_username" placeholder="Email address" ">
   				 </c:if>
    			<c:if test="${not empty requestScope.password}">
        			<input type="password" id="password" class="fadeIn third" name="j_password" placeholder="Password" value="${requestScope.password}">
    			</c:if>
				<c:if test="${ empty requestScope.password}">
        			<input type="password" id="password" class="fadeIn third" name="j_password" placeholder="Password" >
    			</c:if>
    			
				<!--KO cần thẻ này nữa vì trong spring mvc url /dang-nhap sẽ vào method với url riêng chứ ko cần tham số để vào method như servlet -->
				<!--<input type="hidden" value="login" name="action" />  -->
				
				
				<input type="submit" class="fadeIn fourth" value="Đăng nhập"><!-- Khi người dùng nhấn nút này thì 2 input tk,mk đc nộp httpbody của 
																			   url .../dang-nhap?action=login(action=login là input hidden thành tham số url)  với method post(httpBody sẽ ko hiện mk,tk và đi vào method post) -->
			</form>

			<!-- Remind Passowrd -->


		</div>
	</div>
</body>
</html>