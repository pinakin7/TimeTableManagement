<%-- 
    Document   : dashboard-student
    Created on : 07-May-2022, 6:12:55 PM
    Author     : preet
--%>

<%@page import="backend.DB_UTILS"%>
<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="backend.TIME_TABLE_MODEL"%>
<%@page import="backend.TIME_TABLE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard <%= (String) request.getAttribute("user")%></title>
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    </head>
    <body class="student-dashboard ">
        <div class="d-flex flex-column justify-content-center align-items-center align-content-center m-1">
            <div class="d-flex justify-content-between align-items-center align-content-center w-100 px-2 my-2">
                <div class="container text-end ms-6 ps-5" style="font-family: cooper black; font-size: 1.8rem;">
                    <span class="ms-6 ps-5">
                        Welcome <%= (String) request.getAttribute("ID")%>
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
            <div class="hl mx-5"></div>
            <div class="my-3 d-flex flex-column align-content-center align-items-center justify-content-center">

                <%
                    ArrayList<TIME_TABLE_MODEL> tm = null;
                    if (request.getAttribute("ID").toString().startsWith("STU")) {
                        tm = TIME_TABLE.GetStudentTimeTable(request.getAttribute("ID").toString());
                    } else if (request.getAttribute("ID").toString().startsWith("FAC")) {
                        tm = TIME_TABLE.GetFacultyTimeTable(request.getAttribute("ID").toString());
                    } else {
                        response.setStatus(401);
                        response.sendRedirect(request.getContextPath() + "/");
                    }

                    Calendar calendar = Calendar.getInstance();
                    Date date = calendar.getTime();
                    String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
                    SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss a");
                    sdfTime.setTimeZone(java.util.TimeZone.getTimeZone("IST"));

                %>

                <% for (TIME_TABLE_MODEL x : tm) {
//                        System.out.println(day);

                        if (DB_UTILS.getDayNumber(x.getDAY().toLowerCase()) == DB_UTILS.getDayNumber(day.toLowerCase())) {%>
                <div class="card text-center bg-tranparent w-100 my-2">
                    <div class="card-header bg-tranparent">
                        Course Code: <%=x.getCOURSE_CODE()%>
                    </div>
                    <div class="card-body bg-tranparent">
                        <h5 class="card-title mt-0">Faculty Code: <%=x.getFACULTY_CODE()%></h5>
                        <p class="card-text">Block: <%=x.getBLOCK()%> &nbsp; Room No.: <%=x.getROOM_NUMBER()%></p>

                        <p>
                            From: <%=sdfTime.format(x.getSTART_TIME())%> <br>
                            To: <%=sdfTime.format(x.getEND_TIME())%>
                        </p>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>

            <!--            <div class="d-flex align-items-center align-content-center justify-content-between w-100 mb-3 mt-5 mx-5 text-end">
                            <div class="mx-5 text-center" style="font-family: berlin sans fb; font-weight: 600; font-size: 1.5rem;">
                                <i class="bi bi-caret-left-fill"></i>  Yesterday's Time Table
                            </div>
                            <div class="mx-5 text-center" style="font-family: berlin sans fb; font-weight: 600; font-size: 1.5rem;">
                                Tomorrow's Time Table <i class="bi bi-caret-right-fill"></i>
                            </div>
                        </div>-->

        </div>
        <%--<%= (String)request.getAttribute("user")%>--%>
    </body>
</html>
