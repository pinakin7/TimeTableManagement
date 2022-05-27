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
public class SUBJECT {
    
    public static boolean AddSubject(SUBJECT_MODEL sm){
        
        Connection con;
        PreparedStatement ps;
        
        DB_CONNECT db = new DB_CONNECT();
        
        boolean res;
        String sql;
        
        try{
            con = db.getConnection();
            sql = "insert into " + DB_UTILS.DB_SUBJECT+ " values(?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, sm.getSUBJECT_CODE());
            ps.setString(2, sm.getNAME());
            ps.setString(3, sm.getFACULTY_CODE());
            ps.executeUpdate();
            res = true;       
        }catch(SQLException x){
            System.err.println(x);
            res = false;
        }
        
        return res;
    }
    
    public static ArrayList<SUBJECT_MODEL> GetSubjects(){
        ArrayList<SUBJECT_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_SUBJECT;
            rs = st.executeQuery(str);
            while(rs.next()){
                SUBJECT_MODEL sm = new SUBJECT_MODEL();
                sm.setNAME(rs.getString("NAME"));
                sm.setSUBJECT_CODE(rs.getString("SUBJECT_CODE"));
                sm.setFACULTY_CODE(rs.getString("FACULTY_CODE"));
                
                res.add(sm);
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
    }
    public static SUBJECT_MODEL GetSubject(String SUBJECT_CODE){
        SUBJECT_MODEL res = new SUBJECT_MODEL();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_SUBJECT + " where SUBJECT_CODE = '"+SUBJECT_CODE+"';";
            rs = st.executeQuery(str);
            while(rs.next()){
                res.setNAME(rs.getString("NAME"));
                res.setSUBJECT_CODE(rs.getString("SUBJECT_CODE"));
                res.setFACULTY_CODE(rs.getString("FACULTY_CODE"));
            }
        }catch(SQLException e){
            System.err.println(e);
            
            res = null;
        }
        
        return res;
    }
    
    
}
