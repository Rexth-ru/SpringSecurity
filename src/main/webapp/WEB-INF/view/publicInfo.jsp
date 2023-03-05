<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h1>Public information</h1>
<br>
<br>

<security:authorize access="hasAnyRole('IT','SECURITY','DIRECTOR')">
<input type="button" value="for IT"
onclick="window.location.href='server_info'">
for IT, STUFF, DIRECTOR
</security:authorize>
<br>
<br>

<security:authorize access="hasAnyRole('SECURITY','DIRECTOR')">
<input type="button" value="for STUFF"
       onclick="window.location.href='stuff_info'">
for STUFF, DIRECTOR
</security:authorize>
<br>
<br>

<security:authorize access="hasRole('DIRECTOR')">
<input type="button" value="for DIRECTOR"
       onclick="window.location.href='director_info'">
for DIRECTOR
</security:authorize>
<br>
</body>
</html>