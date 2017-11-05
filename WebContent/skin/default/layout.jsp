<html>
  <head>
    <title>Jaaz Portal</title>
    <jsp:include page="/skin/${skin}/header.jsp"></jsp:include>
  </head>
  <body>
        <table>
      <tr>
        <td colspan="2">
          <jsp:include page="/skin/${skin}/top.jsp"></jsp:include>
        </td>
      </tr>
      <tr>
         <td>
          <jsp:include page="/skin/${skin}/body.jsp"></jsp:include>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <jsp:include page="/skin/${skin}/bottom.jsp"></jsp:include>
        </td>
      </tr>
    </table>
  </body>
          <jsp:include page="/skin/${skin}/footer.jsp"></jsp:include>
</html>