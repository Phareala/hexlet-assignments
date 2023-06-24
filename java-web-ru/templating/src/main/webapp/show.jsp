<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Company</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
             <table>
                 <tr>
                     <th>id</th>
                     <th>firstName</th>
                     <th>lastName</th>
                     <th>email</th>
                 </tr>
                 <tr>
                      <th>${user.get("id")} </th>
                      <th>${user.get("firstName")}</th>
                      <th>${user.get("lastName")}</th>
                      <th>${user.get("email")}</th>
                 </tr>
             </table>
             <a href='/users/delete?id=${user.get("id")}'><button type="submit">Удалить пользователя?</button></a>
        </div>
    </body>
</html>
<!-- END -->