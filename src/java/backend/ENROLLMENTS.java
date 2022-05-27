/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class ENROLLMENTS {
    public static boolean EnrollStudentCourse(ENROLLMENTS_MODEL em){
        
        Connection con;
        PreparedStatement ps;
        
        DB_CONNECT db = new DB_CONNECT();
        
        boolean res;
        String sql;
        
        try{
            con = db.getConnection();
            sql = "insert into " + DB_UTILS.DB_ENROLLMENTS+ " values(?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCOURSE_ID());
            ps.setString(2, em.getSTUDENT_ID());
            ps.executeUpdate();
            res = true;       
        }catch(SQLException x){
            System.err.println(x);
            res = false;
        }
        
        
        return res;
    }
    
    public static ArrayList<ENROLLMENTS_MODEL> GetEnrollments(){
        ArrayList<ENROLLMENTS_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_ENROLLMENTS;
            rs = st.executeQuery(str);
            while(rs.next()){
                ENROLLMENTS_MODEL em = new ENROLLMENTS_MODEL();
                em.setCOURSE_ID(rs.getString("COURSE_ID"));
                em.setSTUDENT_ID(rs.getString("STUDENT_ID"));
                
                res.add(em);
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
    }
    
    public static ArrayList<SUBJECT_MODEL> GetStudentCourses(String STUDENT_ID){
        ArrayList<SUBJECT_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_ENROLLMENTS + " where STUDENT_ID = '"+STUDENT_ID+"';";
            rs = st.executeQuery(str);
            while(rs.next()){
                SUBJECT_MODEL sm = SUBJECT.GetSubject(rs.getString("COURSE_ID"));
                
                res.add(sm);
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
    }
}
