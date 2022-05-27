/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backend;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class TimeTableBackEnd {

    /**
     *
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TODO Testing the code
        DB_CONNECT dbConnect = new DB_CONNECT();
        Connection connection = dbConnect.getConnection();

        USER u = new USER();
        USER_MODEL ums = new USER_MODEL("aryaa", "aruu", "S");
//        USER_MODEL umf = new USER_MODEL("sumit", "sumitchahar", "F");
//
//        
        System.out.println(u.RegisterUser(ums));
        System.out.println(u.LoginUser(ums));
//        
//        System.out.println(u.RegisterUser(umf));
//        System.out.println(u.LoginUser(umf));

        STUDENT_MODEL stm = new STUDENT_MODEL("aryaa", "Aryaa");
//        FACULTY_MODEL fm = new FACULTY_MODEL("sumit", "Sumit");
//        
        STUDENT s = new STUDENT();
//        FACULTY f = new FACULTY();
//        
        s.SetStudentID(stm);
//        f.SetFacultyID(fm);
//        
        System.out.println(s.SetStudent(stm));
        System.out.println(stm.getNAME());
//        System.out.println(sm.getSTUDENTID());
//                System.out.println(sm.getUSERNAME());

//        System.out.println(f.SetFaculty(fm));
//        try {
//            System.out.println(FILE_HANDLER_HELPER.writeBinaryFile(DB_UTILS.FACULTY_FILE_NAME, 100));
//            System.out.println(FILE_HANDLER_HELPER.writeBinaryFile(DB_UTILS.STUDENT_FILE_NAME, 100));
//
//            
////
////        try {
////            System.out.println(FILE_HANDLER_HELPER.readBinaryFile("temp.dat"));
////        } catch (FileNotFoundException ex) {
////            Logger.getLogger(TimeTableBackEnd.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(TimeTableBackEnd.class.getName()).log(Level.SEVERE, null, ex);
//        }
        SUBJECT_MODEL sm = new SUBJECT_MODEL("PHY101", "Physics", "FAC-100");

//          System.out.println(SUBJECT.AddSubject(sm));
        ENROLLMENTS_MODEL em = new ENROLLMENTS_MODEL("PHY101", "STU-100");

//           System.out.println(ENROLLMENTS.EnrollStudentCourse(em));
        ArrayList<STUDENT_MODEL> arrs = STUDENT.GetStudents();

        System.out.println(arrs);

        ArrayList<FACULTY_MODEL> arrf = FACULTY.GetFaculties();

        System.out.println(arrf);

        ArrayList<SUBJECT_MODEL> arrsu = SUBJECT.GetSubjects();
        System.out.println(arrsu);

        ArrayList<ENROLLMENTS_MODEL> arrer = ENROLLMENTS.GetEnrollments();
        System.out.println(arrer);

        Time ts = new Time(1000000);
        Time ts1 = new Time(1500000);

        TIME_TABLE_MODEL tm = new TIME_TABLE_MODEL("PHY101", "FAC-100", "A", 101, ts, ts1, "Monday");

//            System.out.println(TIME_TABLE.SetTimeTable(tm));
        ArrayList<TIME_TABLE_MODEL> arrtm = TIME_TABLE.GetTimeTable();

        System.out.println(arrtm);

        ArrayList<SUBJECT_MODEL> arrser = ENROLLMENTS.GetStudentCourses("STU-100");
        System.out.println(arrser);

        ArrayList<TIME_TABLE_MODEL> arrftm = TIME_TABLE.GetFacultyTimeTable("FAC-100");

        System.out.println(arrftm);

        SUBJECT_MODEL smr = SUBJECT.GetSubject("PHY101");
        System.out.println(smr);

        ArrayList<TIME_TABLE_MODEL> arrstm = TIME_TABLE.GetStudentTimeTable("STU-100");

        System.out.println(arrftm);

    }

}
