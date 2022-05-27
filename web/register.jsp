<%-- 
    Document   : register
    Created on : 07-May-2022, 6:08:08 PM
    Author     : preet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
        <link href="css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body class="main">
        <!--\name username password usercode-->
        <div class="container h-100 d-flex justify-content-center align-items-center my-5 py-5">
            <!-- your form container -->
            <div class="container w-auto text-center main-container-bg d-flex flex-column justify-content-center align-content-center align-items-center" style="border-radius:0.75rem!important">
                <div class="text-center my-2 p-2 mx-3" style="font-family: consolas; font-weight: 900; font-size: 3rem">
                    Time-Table Management System
                </div>
                <div class="text-center my-2 p-2" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                    Register New User
                </div>
                <div class="w-100 d-flex justify-content-center align-content-center align-items-center my-2 ">
                    <form method="POST" action="<%=request.getContextPath()%>/Register" class="d-flex flex-column justify-content-start align-content-center align-items-center my-2 mx-1 w-100">
                        <div class="d-flex justify-content-center align-content-center align-items-center" required>
                            <select name="usercode" class="form-select my-1 bg-transparent p-2" required>
                                <option class="bg-transparent p-2" value="F">Faculty</option>
                                <option class="bg-transparent p-2" value="S">Student</option>
                            </select>
                        </div>

                        <div class="form-floating my-1 bg-transparent">
                            <input name="name" type="text" class="form-control bg-transparent h-auto border-1 rounded" id="floatingName" required>
                            <label for="floatingName">Name</label>
                        </div>
                        <div class="form-floating my-1 bg-transparent">
                            <input name="userName" type="text" class="form-control bg-transparent h-auto border-1 rounded" id="floatingInput" required>
                            <label for="floatingInput">User Name</label>
                        </div>

                        <div class="form-floating my-1 bg-transparent">
                            <input name="password" type="password" class="form-control bg-transparent h-auto border-1 rounded" id="floatingPassword" required>
                            <label for="floatingPassword">Password</label>
                        </div>
                        <div class="d-flex justify-content-center align-content-center align-items-center">
                            <div class="my-2">
                                <button type="submit" class="btn btn-outline-danger">Register</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script>
        if (window.history.replaceState) {
            window.history.replaceState(null, null, window.location.href);
        }
    </script>
</html>
