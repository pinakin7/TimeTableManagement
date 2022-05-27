/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author preet
 */
public class STUDENT {
    
    private int student_counter;

    public STUDENT() {
        int temp = FILE_HANDLER_HELPER.readBinaryFile(DB_UTILS.FOLDER_NAME, DB_UTILS.STUDENT_FILE_NAME);
        
        this.student_counter = temp;
        
    }
    
    public void SetStudentID(STUDENT_MODEL sm){
        String id = "STU-"+String.valueOf(getStudent_counter());
        
        setStudent_counter(getStudent_counter() + 1);
        
        sm.setSTUDENTID(id);
        
        try {
            FILE_HANDLER_HELPER.writeBinaryFile(DB_UTILS.FOLDER_NAME, DB_UTILS.STUDENT_FILE_NAME, student_counter);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(STUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public boolean SetStudent(STUDENT_MODEL sm){
        Connection con;
        PreparedStatement ps;
        
        DB_CONNECT db = new DB_CONNECT();
        
        boolean res;
        String sql;
        try{
            con = db.getConnection();
            sql = "insert into " + DB_UTILS.DB_STUDENT + " values(?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, sm.getSTUDENTID());
            ps.setString(2, sm.getUSERNAME());
            ps.setString(3, sm.getNAME());
            ps.executeUpdate();
            res = true;
            
        }catch(SQLException x){
            System.err.println(x);
            res = false;
        }
        return res;
    }

    /**
     * @return the student_counter
     */
    public int getStudent_counter() {
        return student_counter;
    }

    /**
     * @param student_counter the student_counter to set
     */
    public void setStudent_counter(int student_counter) {
        this.student_counter = student_counter;
    }
    
    public static ArrayList<STUDENT_MODEL> GetStudents(){
        ArrayList<STUDENT_MODEL> res = new ArrayList<>();
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_STUDENT;
            rs = st.executeQuery(str);
            while(rs.next()){
                STUDENT_MODEL sm = new STUDENT_MODEL();
                sm.setNAME(rs.getString("NAME"));
                sm.setSTUDENTID(rs.getString("STUDENT_ID"));
                sm.setUSERNAME(rs.getString("USERNAME"));
                
                res.add(sm);
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
        
    }
    
    public static String GetStudentID(String userName){
        String res = null;
        
        Connection con;
        Statement st;
        ResultSet rs;
        
        DB_CONNECT db = new DB_CONNECT();
        
        String str;
        
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_STUDENT + " where USERNAME = '"+userName+"' ;";
            rs = st.executeQuery(str);
            while(rs.next()){ 
                res = rs.getString("STUDENT_ID");
            }
        }catch(SQLException e){            
            System.err.println(e);
            
            res = null;
        }
        
        return res;
        
    }
    
}
