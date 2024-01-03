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

<form:form action="search" method="get">
    <div class="input-group mb-3">
      <input name="searchInput" type="text" class="form-control" placeholder="Search By Name or Author" aria-label="Recipient's username" aria-describedby="button-addon2">
      <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
    </div>
  </form:form>

  <table class="table">
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Author</th>
        <th scope="col">ISBN</th>
        <th scope="col">Price</th>
        <th scope="col">Publish Date</th>
        <th scope="col">Category</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${bookList}">
      <tr>
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.bookDetails.isbn}</td>
        <td>${book.bookDetails.price}</td>
        <td>${book.bookDetails.publishDate}</td>
        <td>${book.category.name}</td>
        <td>
             <button class="btn btn-sm btn-primary" onclick="location.href='edit/${book.id}'">Edit</button>
             <button class="btn btn-sm btn-danger" onclick="location.href='delete/${book.id}'">Delete</button>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>

</body>
</html>