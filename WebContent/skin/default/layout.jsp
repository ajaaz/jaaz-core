<html>
  <head>
    <title>Jaaz Portal</title>
    <link rel="stylesheet" href="/skin/default/css/bootstrap.min.css">
    <jsp:include page="/skin/${skin}/header.jsp"></jsp:include>
  </head>
  <body>    
    	<jsp:include page="/skin/${skin}/top.jsp"></jsp:include>
  	<div class="container">
		<div class="row">
    		<jsp:include page="/skin/${skin}/body.jsp"></jsp:include>
    	</div>
    </div>	
    <jsp:include page="/skin/${skin}/bottom.jsp"></jsp:include>        
  	
  	<script src="/skin/default/js/jquery.min.js"></script>
	<script src="/skin/default/js/bootstrap.min.js"></script>
  
    <jsp:include page="/skin/${skin}/footer.jsp"></jsp:include>
  </body>
	  	
</html>