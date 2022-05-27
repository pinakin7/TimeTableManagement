/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class TIME_TABLE {
    public static boolean SetTimeTable(TIME_TABLE_MODEL tm){
       Connection con;
        PreparedStatement ps;
        
        DB_CONNECT db = new DB_CONNECT();
        
        boolean res;
        String sql;
        
        try{
            con = db.getConnection();
            sql = "insert into " + DB_UTILS.DB_TIME_TABLE+ " values(?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, tm.getCOURSE_CODE());
            ps.setString(2, tm.getFACULTY_CODE());
            ps.setString(3, tm.getBLOCK());
            ps.setInt(4, tm.getROOM_NUMBER());
            ps.setTime(5, tm.getSTART_TIME());
            ps.setTime(6, tm.getEND_TIME());
            ps.setString(7, tm.getDAY());
            
            ps.executeUpdate();
            res = true;       
        }catch(SQLException x){
            System.err.println(x);
            res = false;
        }
        
        return res;
    }
    
    public static ArrayList<TIME_TABLE_MODEL> GetTimeTable(){
        ArrayList<TIME_TABLE_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_TIME_TABLE;
            rs = st.executeQuery(str);
            while(rs.next()){
                TIME_TABLE_MODEL tm = new TIME_TABLE_MODEL();
                
                tm.setBLOCK(rs.getString("BLOCK"));
                tm.setCOURSE_CODE(rs.getString("COURSE_CODE"));
                tm.setDAY(rs.getString("DAY"));
                tm.setEND_TIME(rs.getTime("END_TIME"));
                tm.setFACULTY_CODE(rs.getString("FACULTY_CODE"));
                tm.setROOM_NUMBER(rs.getInt("ROOM_NUMBER"));
                tm.setSTART_TIME(rs.getTime("START_TIME"));
                
                res.add(tm);
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
    }
    
    public static ArrayList<TIME_TABLE_MODEL> GetFacultyTimeTable(String FACULTY_CODE){
        ArrayList<TIME_TABLE_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_TIME_TABLE + " where FACULTY_CODE = '" + FACULTY_CODE + "';";
            rs = st.executeQuery(str);
            while(rs.next()){
                TIME_TABLE_MODEL tm = new TIME_TABLE_MODEL();
                
                tm.setBLOCK(rs.getString("BLOCK"));
                tm.setCOURSE_CODE(rs.getString("COURSE_CODE"));
                tm.setDAY(rs.getString("DAY"));
                tm.setEND_TIME(rs.getTime("END_TIME"));
                tm.setFACULTY_CODE(rs.getString("FACULTY_CODE"));
                tm.setROOM_NUMBER(rs.getInt("ROOM_NUMBER"));
                tm.setSTART_TIME(rs.getTime("START_TIME"));
                
                res.add(tm);
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
    }
    
    public static ArrayList<TIME_TABLE_MODEL> GetStudentTimeTable(String STUDENT_ID){
        ArrayList<TIME_TABLE_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        ArrayList<SUBJECT_MODEL> subm = ENROLLMENTS.GetStudentCourses(STUDENT_ID);
        
        for(SUBJECT_MODEL sm:subm){
            
             try{
                con = db.getConnection();
                st = con.createStatement();
                str = "select * from " + DB_UTILS.DB_TIME_TABLE + " where COURSE_CODE = '" + sm.getSUBJECT_CODE() + "';";
                rs = st.executeQuery(str);
                while(rs.next()){
                    TIME_TABLE_MODEL tm = new TIME_TABLE_MODEL();

                    tm.setBLOCK(rs.getString("BLOCK"));
                    tm.setCOURSE_CODE(rs.getString("COURSE_CODE"));
                    tm.setDAY(rs.getString("DAY"));
                    tm.setEND_TIME(rs.getTime("END_TIME"));
                    tm.setFACULTY_CODE(rs.getString("FACULTY_CODE"));
                    tm.setROOM_NUMBER(rs.getInt("ROOM_NUMBER"));
                    tm.setSTART_TIME(rs.getTime("START_TIME"));

                    res.add(tm);
                }
            }catch(SQLException e){            
                System.err.println(e);

                res = null;
            }
        }
        
       
        
        return res;
    }
    
}
