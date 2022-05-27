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
public class FACULTY {

    public static String GetFacultyID(String userName) {
        String res = null;

        Connection con;
        Statement st;
        ResultSet rs;

        DB_CONNECT db = new DB_CONNECT();

        String str;

        try {
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_FACULTY + " where USERNAME = '" + userName + "' ;";
            rs = st.executeQuery(str);
            while (rs.next()) {
                res = rs.getString("FACULTY_ID");
            }
        } catch (SQLException e) {
            System.err.println(e);

            res = null;
        }

        return res;
    }

    private int faculty_counter;

    public FACULTY() {
        int temp = FILE_HANDLER_HELPER.readBinaryFile(DB_UTILS.FOLDER_NAME, DB_UTILS.FACULTY_FILE_NAME);

        this.faculty_counter = temp;

    }

    public void SetFacultyID(FACULTY_MODEL fm) {
        String id = "FAC-" + String.valueOf(getFaculty_counter());
        setFaculty_counter(getFaculty_counter() + 1);

        fm.setFACULTY_ID(id);

        try {
            FILE_HANDLER_HELPER.writeBinaryFile(DB_UTILS.FOLDER_NAME, DB_UTILS.FACULTY_FILE_NAME, faculty_counter);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FACULTY.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean SetFaculty(FACULTY_MODEL fm) {
        Connection con;
        PreparedStatement ps;

        DB_CONNECT db = new DB_CONNECT();

        boolean res;
        String sql;
        try {
            con = db.getConnection();
            sql = "insert into " + DB_UTILS.DB_FACULTY + " values(?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, fm.getFACULTY_ID());
            ps.setString(2, fm.getUSERNAME());
            ps.setString(3, fm.getNAME());
            ps.executeUpdate();
            res = true;

        } catch (SQLException x) {
            System.err.println(x);
            res = false;
        }
        return res;
    }

    /**
     * @return the faculty_counter
     */
    public int getFaculty_counter() {
        return faculty_counter;
    }

    /**
     * @param faculty_counter the faculty_counter to set
     */
    public void setFaculty_counter(int faculty_counter) {
        this.faculty_counter = faculty_counter;
    }

    public static ArrayList<FACULTY_MODEL> GetFaculties() {

        ArrayList<FACULTY_MODEL> res = new ArrayList<>();

        Connection con;
        Statement st;
        ResultSet rs;

        DB_CONNECT db = new DB_CONNECT();

        String str;

        try {
            con = db.getConnection();
            st = con.createStatement();
            str = "select * from " + DB_UTILS.DB_FACULTY;
            rs = st.executeQuery(str);
            while (rs.next()) {
                FACULTY_MODEL fm = new FACULTY_MODEL();
                fm.setNAME(rs.getString("NAME"));
                fm.setFACULTY_ID(rs.getString("FACULTY_ID"));
                fm.setUSERNAME(rs.getString("USERNAME"));

                res.add(fm);
            }
        } catch (SQLException e) {
            System.err.println(e);

            res = null;
        }

        return res;

    }
}
