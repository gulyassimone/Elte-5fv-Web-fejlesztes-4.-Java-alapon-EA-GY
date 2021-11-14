<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/hotel.css">
</head>
<body>
	
	<h1>Hotels</h1>
	
	<table>
	<tr>     
        <th>Id</th>
        <th>Name</th>
        <th>Capacity</th>
    </tr>	
	
	<c:forEach items="${hotels}" var="hotel">
    <tr>
    	<td>${hotel.id}</td>
        <td>${hotel.name}</td>
        <td>${hotel.capacity}</td>
    </tr>
	</c:forEach>
    </table>
    
    <br><br>
    <form action="/addHotel" method="post">
	  	<label for="name">Hotel name:</label><br>
	  	<input type="text" id="name" name="name"><br>
	  	<label for="capacity">Capacity:</label><br>
	  	<input type="text" id="capacity" name="capacity"><br><br>
	  	<input type="submit" value="Add hotel">
	</form>
    
    
    
</body>
</html>
