<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/css/admin.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>
    <title>Find Job</title>
</head>
<body>
  <div id="tabs">

      <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#find">Vacancy</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#rezume">Summary</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#people">Users</a>
          </li>
          <li class="nav-item">
            <form action="/logout" method="post"><input type="submit" class="btn btn-dark" value="LogOut"></form>
          </li>
        </ul>
      </nav>
    <div class="tab-content" id="find">
      <div class="search">
        <form class="navbar-form navbar-left" role="search" action="/search" method="post">
          <div class="form-group">
            <input type="text" class="form-control" name="pattern" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-dark">Submit</button>
        </form>
      </div>
      <div class="cards">
        <c:forEach items="${vacancies}" var="vacancy">
        <div class="card">
          <div class="card-body">
            <h4 class="card-title">${vacancy.na}</h4>
            <p class="dataBegin">${project.date}</p>
            <p class="card-text">${project.description}</p>
            <form class="navbar-form" action="/block_post" method="post"><button type="submit" class="btn btn-dark card-btn">Block</button></form>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
    <div class="tab-content" id="rezume">
      <div class="search">
        <form class="navbar-form navbar-left" role="search" action="/search" method="post">
          <div class="form-group">
            <input type="text" class="form-control" name="pattern" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-dark">Submit</button>
        </form>
      </div>
      <div class="cards">
        <div class="card">
          <div class="card-body">
            <h4 class="card-title">${project.name}</h4>
            <p class="dataBegin">${project.date}</p>
            <p class="card-text">${project.description}</p>
            <a href="#" class="card-link">Go to rezume</a>
          </div>
        </div>
      </div>
    </div>
    <div class="tab-content" id="people">
      <div class="search">
        <form class="navbar-form navbar-left" role="search" action="/search" method="post">
          <div class="form-group">
            <input type="text" class="form-control" name="pattern" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-dark">Submit</button>
        </form>
      </div>
      <div class="cards">
        <div class="card">
          <div class="card-body">
            <h4 class="card-title">${project.name}</h4>
            <p class="dataBegin">${project.date}</p>
            <p class="card-text">${project.description}</p>
            <a href="#" class="card-link">Go to rezume</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
