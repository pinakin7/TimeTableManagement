<%-- 
    Document   : index
    Created on : 07-May-2022, 5:39:03 PM
    Author     : preet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TTMS-Login Student</title>
        <!--<link href="css/index.css" rel="stylesheet" type="text/css">-->


        <link href="css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body class="login-student py-5">



        <div class="container h-100 d-flex justify-content-center align-items-center my-5 py-4">
            <!-- your form container -->
            <div class="container w-auto text-center main-container-bg d-flex flex-column justify-content-center align-content-center align-items-center" style="border-radius:0.75rem!important">
                <div class="text-center my-2 p-2 mx-3" style="font-family: consolas; font-weight: 900; font-size: 3rem">
                    Time-Table Management System
                </div>
                <div class="text-center my-2 p-2" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                    Student Login
                </div>
                <div class="d-flex justify-content-center align-content-center align-items-center my-2">
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="text-center my-2 ">
                            <div class="bg-transparent">
                                <img class="bg-tranparent p-2" src="img/student.png" alt="Student Login"width="150" height="150" onclick="window.location = '<%=request.getContextPath()%>/StudentLogin'"/>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="vl">
                        </div>
                    </div>

                    <form method="POST" action="<%=request.getContextPath()%>/StudentLogin" class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input type="text" class="form-control bg-transparent h-auto border-0" id="floatingEmail" name="username" placeholder="name@example.com" required>
                            <label for="floatingEmail">Username</label>
                        </div>
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input type="password" class="form-control bg-transparent h-auto border-0" id="floatingPassword" name="password" placeholder="Password" required>
                            <label for="floatingPassword">Password</label>
                        </div>
                        <div class="d-flex justify-content-center align-content-center align-items-center">
                            <div class="my-2 mx-3">
                                <button type="button" class="btn btn-outline-secondary" onclick="window.location = '<%=request.getContextPath()%>/Register'">Register</button>
                            </div>
                            <div class="my-2 mx-3">                                
                                <button type="submit" class="btn btn-outline-success">Login</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>





    </body>



</html>
