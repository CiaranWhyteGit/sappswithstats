<%--
  Created by IntelliJ IDEA.
  User: Ciaran
  Date: 06/04/14
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $('#SappHistory').onload(function() {
            $.get('SappHistory', function(responseText) {
                $('#list').html(responseText);
            });
        });
    });
</script>
<body>
    <div id='header' style='display:inline'>
        <ul style='display:inline'>
            <li><a id="SappHistory" href="#">SappHistory</a></li>
        </ul>
    </div>
    <div id="list">

    </div>
</body>
</html>
