<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <script src="https://raw.githubusercontent.com/igorescobar/jQuery-Mask-Plugin/master/src/jquery.mask.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">


</head>

<body>

  <div class="form">

      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>

      <div class="tab-content">
        <div id="signup">
          <h1>Sign Up</h1>

          <form action="/" method="post">

          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <input type="text" name="firstName" required autocomplete="off" />
            </div>

            <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
              <input type="text" name="lastName" required autocomplete="off"/>
            </div>
          </div>
          <div class="field-wrap">
            <label>
              Phone number<span class="req">*</span>
            </label>
            <input type="text" name="phone" required autocomplete="off"/>
          </div>

          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off"/>
          </div>

          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          <div class="field-wrap" >
            <label>
              Role<span class="req">*</span>
            </label>
            <select class="form-control" name="role" required autocomplete="off"/>
              <option value="" style="display:none;"></option>
              <option value="EMPLOYEE">Employee</option>
              <option value="EMPLOYER">Employer</option>
            </select>
          </div>

          <button type="submit" class="button button-block"/>Get Started</button>

          </form>

        </div>

        <div id="login">
          <h1>Welcome Back!</h1>
          <form action="/login" method="post">
            <c:if test="${param.error != null}">
              <div class="alert alert-danger">
                <p>Invalid username and password.</p>
              </div>
            </c:if>
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off"/>
          </div>

          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>

          <!--p class="forgot"><a href="#">Forgot Password?</a></p-->
          <button class="button button-block" name="${_csrf.parameterName}"
                  value="${_csrf.token}"/>Log In</button>

          </form>

        </div>

      </div><!-- tab-content -->

</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



    <script  src="../../resources/js/index.js"></script>




</body>

</html>
