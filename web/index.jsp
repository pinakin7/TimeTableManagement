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
        <title>Time Table Management System</title>
        <!--<link href="css/index.css" rel="stylesheet" type="text/css">-->


        <link href="css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body class="main py-5">



        <div class="container h-100 d-flex justify-content-center align-items-center my-5 py-4">
            <!-- your form container -->
            <div class="container w-auto text-center main-container-bg d-flex flex-column justify-content-center align-content-center align-items-center" style="border-radius:0.75rem!important">
                <div class="text-center my-2 p-2 mx-3" style="font-family: consolas; font-weight: 900; font-size: 3rem">
                    Time-Table Management System
                </div>
                <div class="text-center my-2 p-2" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                    Login as
                </div>
                <div class="d-flex justify-content-center align-content-center align-items-center my-2">
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="text-center">
                            <div class="bg-transparent"  style="cursor: pointer;">
                                <img class="bg-tranparent p-2" src="img/teacher.png" alt="Teacher Login" width="150" height="150" onclick="window.location='<%=request.getContextPath()%>/FacultyLogin'"/>
                            </div>
                        </div>
                        <div class="text-center my-3 px-3" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                            Faculty
                        </div>
                    </div>
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="vl">
                        </div>
                    </div>
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="text-center my-2 ">
                            <div class="bg-transparent" style="cursor: pointer;">
                                <img class="bg-tranparent p-2" src="img/student.png" alt="Student Login"width="150" height="150" onclick="window.location='<%=request.getContextPath()%>/StudentLogin'"/>
                            </div>
                        </div>
                        <div class="text-center my-3 px-3" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                            Student
                        </div>
                    </div>
                </div>
            </div>
        </div>





    </body>



</html>
