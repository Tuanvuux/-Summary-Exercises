<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
 <jsp:include page="header.jsp" />
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="https://getbootstrap.com/favicon.ico">
  <title>Book management demo</title>
  <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
  <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>

   <h1>My Shopping Cart</h1>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${List}">
      <tr>
        <td>${product.id}</td>
        <td>${product.productName}</td>
        <td>${product.productDescription}</td>
        <td>${product.unitPrice}</td>
        <td>
            <form method="post" action="addToCart">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit" class="btn btn-sm btn-primary">addToCart</button>
            </form>

        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>

</body>
</html>