<%-- 
    Document   : edit
    Created on : 09-May-2022, 9:32:52 PM
    Author     : preet
--%>

<%@page import="backend.SUBJECT_MODEL"%>
<%@page import="backend.SUBJECT"%>
<%@page import="backend.STUDENT_MODEL"%>
<%@page import="backend.STUDENT"%>
<%@page import="backend.FACULTY_MODEL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="backend.FACULTY"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body class="register">
        <div class="d-flex flex-column justify-content-center align-content-center align-items-center p-3">
            <%-- 
                Welcom screen
            --%>
            <div class="d-flex justify-content-between align-items-center align-content-center w-100 px-2 my-2">
                <div class="container text-end ms-6" style="font-family: cooper black; font-size: 1.8rem; padding-left: 9rem">
                    <span class="ms-6 ps-5">
                        Welcome admin
                    </span> 
                </div>
                <div class="container text-end">
                    <button type="button" class="btn btn-outline-danger" onclick="window.location = '<%=request.getContextPath()%>/'">
                        Logout
                    </button>
                </div>
            </div>
            <div class="my-4 py-3 text-center pe-5" style="font-family: leelawadee; font-size: 1.35rem;">
                Today's Time Table
                <figcaption class='blockquote-footer'>                    
                    <em><%= (new java.util.Date()).toString()%></em>
                </figcaption>

            </div>
            <%-- 
                Form 1 -> Add subject
            --%>
            <div class="my-3 container w-auto text-center main-container-bg d-flex flex-column justify-content-center align-content-center align-items-center" style="border-radius:0.75rem!important">

                <div class="text-center my-2 p-2" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                    Add New Subject
                </div>
                <div class="d-flex justify-content-center align-content-center align-items-center my-2">
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="text-center my-2 ">
                            <div class="bg-transparent">
                                <img class="bg-tranparent p-2" src="img/subject.png" alt="Faculty Login"width="150" height="150"/>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="vl">
                        </div>
                    </div>

                    <form method="POST" action="<%=request.getContextPath()%>/NewSubject" class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input name="subjectName" type="text" class="form-control bg-transparent h-auto border-1" id="floatingInput" required>
                            <label for="floatingInput">Subject Name</label>
                        </div>
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input name="subjectCode" type="text" class="form-control bg-transparent h-auto border-1" id="floatingPassword" required="">
                            <label for="floatingPassword">Subject Code</label>
                        </div>
                        <%--
                            Dynamically bring the list of all faculties
                        --%>
                        <select name="facultyCode" class="form-select my-1 bg-transparent p-2" aria-label="Default select example" required>
                            <!--                            <option class="bg-transparent p-2" selected>Faculty</option>-->
                            <%
                                ArrayList<FACULTY_MODEL> faculties = FACULTY.GetFaculties();
                                for (FACULTY_MODEL faculty : faculties) {
                            %>
                            <option class="bg-transparent p-2" value=<%=faculty.getFACULTY_ID()%>><%=faculty.getFACULTY_ID()%></option>
                            <%
                                }
                            %>
                        </select>
                        <div class="d-flex justify-content-center align-content-center align-items-center">
                            <div class="my-2">                                
                                <button type="submit" class="btn btn-outline-success">Add</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%-- 
                Form 2 -> Enroll Student
            --%>
            <div class="my-3 container w-auto text-center main-container-bg d-flex flex-column justify-content-center align-content-center align-items-center" style="border-radius:0.75rem!important">
                <div class="text-center my-2 p-2" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                    Enroll a Student to a Course
                </div>
                <div class="d-flex justify-content-center align-content-center align-items-center my-2">
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="text-center my-2 ">
                            <div class="bg-transparent">
                                <img class="bg-tranparent p-2" src="img/course.png" alt="Faculty Login"width="150" height="150"/>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="vl">
                        </div>
                    </div>

                    <form method="POST" action="<%=request.getContextPath()%>/EnrollStudent" class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <%--
                             Dynamically bring the list of all students
                        --%>
                        <select name="student" class="form-select my-1 bg-transparent p-2" aria-label="Default select example" required>
                            <!--<option class="bg-transparent p-2" selected>Student</option>-->
                            <%
                                ArrayList<STUDENT_MODEL> students = STUDENT.GetStudents();
                                for (STUDENT_MODEL student : students) {
                            %>
                            <option class="bg-transparent p-2" value=<%=student.getSTUDENTID()%>><%=student.getSTUDENTID()%></option>
                            <%
                                }
                            %>
                        </select>
                        <%--
                            Dynamically bring the list of all courses
                        --%>
                        <select name="course" class="form-select my-1 bg-transparent p-2" aria-label="Default select example" required>
                            <!--<option class="bg-transparent p-2" selected>Student</option>-->
                            <%
                                ArrayList<SUBJECT_MODEL> courses = SUBJECT.GetSubjects();
                                for (SUBJECT_MODEL course : courses) {
                            %>
                            <option class="bg-transparent p-2" value=<%=course.getSUBJECT_CODE()%>><%=course.getSUBJECT_CODE()%></option>
                            <%
                                }
                            %>
                        </select>
                        <div class="d-flex justify-content-center align-content-center align-items-center">
                            <div class="my-2">                                
                                <button type="submit" class="btn btn-outline-success">Add</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%-- 
               Form 3 -> Set Timetable
            --%>
            <div class="my-3 container w-auto text-center main-container-bg d-flex flex-column justify-content-center align-content-center align-items-center" style="border-radius:0.75rem!important">
                <div class="text-center my-2 p-2" style="font-family: courier new; font-size: 1.5rem; font-weight: 500;">
                    Set Time Table
                </div>
                <div class="d-flex justify-content-center align-content-center align-items-center my-2">
                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="text-center my-2 ">
                            <div class="bg-transparent">
                                <img class="bg-tranparent p-2" src="img/timetable.png" alt="Faculty Login"width="150" height="150"/>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <div class="vl" style="height: 400px !important">
                        </div>
                    </div>

                    <form method="POST" action="<%=request.getContextPath()%>/SetTimeTable" class="d-flex flex-column justify-content-center align-content-center align-items-center my-2 mx-5">
                        <%--
                           Dynamically bring the list of all courses
                        --%>
                        <select name="courseOne" class="form-select my-1 bg-transparent p-2" aria-label="Default select example" required>
                            <%
                                for (SUBJECT_MODEL course : courses) {
                            %>
                            <option class="bg-transparent p-2" value=<%=course.getSUBJECT_CODE()%>><%=course.getSUBJECT_CODE()%></option>
                            <%
                                }
                            %>
                        </select>
                        <%--
                           Dynamically bring the list of all faculties
                        --%>
                        <select name="facultyOne" class="form-select my-1 bg-transparent p-2" aria-label="Default select example" required>
                            <!--                            <option class="bg-transparent p-2" selected>Faculty</option>-->
                            <%
                                for (FACULTY_MODEL faculty : faculties) {
                            %>
                            <option class="bg-transparent p-2" value=<%=faculty.getFACULTY_ID()%>><%=faculty.getFACULTY_ID()%></option>
                            <%
                                }
                            %>
                        </select>
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input name="block" type="text" class="form-control bg-transparent h-auto border-1" id="floatingBlock" placeholder="name@example.com" required>
                            <label for="floatingBlock">Block</label>
                        </div>
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input name="room" type="number" class="form-control bg-transparent h-auto border-1" id="floatingRoom" placeholder="name@example.com" required>
                            <label for="floatingRoom">Room Number</label>
                        </div>
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input name="startTime" type="time" class="form-control bg-transparent h-auto border-1" id="floatingS" placeholder="name@example.com" required>
                            <label for="floatingS">Start Time</label>
                        </div>
                        <div class="form-floating my-1 bg-transparent p-1">
                            <input name="endTime" type="time" class="form-control bg-transparent h-auto border-1" id="floatingE" placeholder="name@example.com" required>
                            <label for="floatingE">End Time</label>
                        </div>
                        <select name="day" class="form-select my-1 bg-transparent p-2" aria-label="Default select example" required>
                            <option class="bg-transparent p-2" value="Monday">Monday</option>
                            <option class="bg-transparent p-2" value="Tuesday">Tuesday</option>
                            <option class="bg-transparent p-2" value="Wednesday">Wednesday</option>
                            <option class="bg-transparent p-2" value="Thursday">Thursday</option>
                            <option class="bg-transparent p-2" value="Friday">Friday</option>
                            <option class="bg-transparent p-2" value="Saturday">Saturday</option>
                            <option class="bg-transparent p-2" value="Sunday">Sunday</option>


                        </select>
                        <div class="d-flex justify-content-center align-content-center align-items-center">
                            <div class="my-2">                                
                                <button type="submit" class="btn btn-outline-success">Add</button>
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
