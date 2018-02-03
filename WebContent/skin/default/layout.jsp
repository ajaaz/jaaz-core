<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Jaaz Portal</title>
<link rel="stylesheet" href="/skin/default/css/bootstrap.min.css">
<jsp:include page="/skin/system/header.jsp"></jsp:include>
<jsp:include page="/skin/${skin}/header.jsp"></jsp:include>
</head>
<body>
	<div id="vue-main">
		<jsp:include page="/skin/${skin}/top.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<jsp:include page="/skin/${skin}/body.jsp"></jsp:include>
				<!-- Trigger the modal with a button -->
			</div>
		</div>

		<jsp:include page="/skin/${skin}/bottom.jsp"></jsp:include>
	</div>

	<jsp:include page="/skin/system/footer.jsp"></jsp:include>
	<jsp:include page="/skin/${skin}/footer.jsp"></jsp:include>
</body>

</html>