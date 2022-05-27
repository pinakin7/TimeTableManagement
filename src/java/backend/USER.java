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


public class USER {
    public static boolean RegisterUser(USER_MODEL um){
        Connection con;
        PreparedStatement ps;
        
        DB_CONNECT db = new DB_CONNECT();
        
        boolean res;
        String sql;
        try{
            con = db.getConnection();
            sql = "insert into " + DB_UTILS.DB_AUTH_USER + " values(?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, um.getUSERNAME());
            ps.setString(2, um.getPASSWORD());
            ps.setString(3, um.getUSERCODE());
            ps.executeUpdate();
            res = true;
            
        }catch(SQLException x){
            System.err.println(x);
            res = false;
        }
        return res;
    }
    
    public static boolean LoginUser(USER_MODEL um){
        ResultSet rs;
        Statement st;
        Connection con;
        DB_CONNECT db = new DB_CONNECT();
        String str;
        boolean res = false;
        try{
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from "+DB_UTILS.DB_AUTH_USER+
                    " where USERNAME = '"+um.getUSERNAME()+
                    "' and PASSWORD='"+um.getPASSWORD()+
                    "' and USER_CODE='"+um.getUSERCODE()+
                    "';";
            rs = st.executeQuery(str);
            while(rs.next()){
                res=true;
            }
        }catch(SQLException e){            
            System.err.print(e);
            res = false;
        }
        return res;
    }
}
