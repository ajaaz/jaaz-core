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
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
			</div>
		</div>

		<jsp:include page="/skin/${skin}/bottom.jsp"></jsp:include>
	</div>

	<jsp:include page="/skin/system/footer.jsp"></jsp:include>
	<jsp:include page="/skin/${skin}/footer.jsp"></jsp:include>
</body>

</html>