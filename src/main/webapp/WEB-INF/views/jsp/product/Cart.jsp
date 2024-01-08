<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
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
                <th scope="col">Quantity</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cartItem" items="${cartList}">
                <tr>
                    <td>${cartItem.products.id}</td>
                    <td>${cartItem.products.productName}</td>
                    <td>${cartItem.products.productDescription}</td>
                    <td>${cartItem.products.unitPrice}</td>
                    <td>${cartItem.quantity}</td>
                    <td>

                        <form action="${pageContext.request.contextPath}/removeFromCart/${cartItem.products.id}" method="post">
                                                   <input type="submit" class="btn btn-sm btn-danger" value="Remove" />
                                               </form>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

   <center>

         <c:if test="${cartList.size() !=0 }">

                <a href="/checkout"><input type="submit" class="btn btn-primary" value="Checkout" /></a>
         </c:if>
    </center>

</body>

</html>
