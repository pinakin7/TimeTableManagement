/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.HashMap;

/**
 *
 * @author preet
 */
public class DB_UTILS {

    public static final String DB_NAME = "tt_management_db";
    public static final String DB_USER = "root";
    public static final String DB_USER_PASSWORD = "pinakin7";
    public static final String DB_AUTH_USER = "auth_user";
    public static final String DB_FACULTY = "faculties";
    public static final String DB_STUDENT = "students";
    public static final String DB_SUBJECT = "subject";
    public static final String DB_ENROLLMENTS = "enrollments";
    public static final String DB_TIME_TABLE = "time_table";
    public static final String FOLDER_NAME = "data";
    public static final String STUDENT_FILE_NAME = "student.dat";
    public static final String FACULTY_FILE_NAME = "faculty.dat";

    public static int getDayNumber(String day) {
        HashMap<String, Integer> dayMap = new HashMap<>();

        dayMap.put("sunday", 0);
        dayMap.put("monday", 1);
        dayMap.put("tuesday", 2);
        dayMap.put("wednesday", 3);
        dayMap.put("thursday", 4);
        dayMap.put("friday", 5);
        dayMap.put("saturday", 6);

        return dayMap.get(day);
        
    }

}
