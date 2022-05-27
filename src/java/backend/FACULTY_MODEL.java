/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author preet
 */
public class FACULTY_MODEL {
    public String USERNAME;
    public String NAME;
    public String FACULTY_ID;

    public FACULTY_MODEL(String USERNAME, String NAME) {
        this.USERNAME = USERNAME;
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "FACULTY_MODEL{" + "USERNAME=" + USERNAME + ", NAME=" + NAME + ", FACULTY_ID=" + FACULTY_ID + '}';
    }

    public FACULTY_MODEL() {
    }

    public FACULTY_MODEL(String USERNAME, String NAME, String FACULTY_ID) {
        this.USERNAME = USERNAME;
        this.NAME = NAME;
        this.FACULTY_ID = FACULTY_ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getFACULTY_ID() {
        return FACULTY_ID;
    }

    public void setFACULTY_ID(String FACULTY_ID) {
        this.FACULTY_ID = FACULTY_ID;
    }
    
    
}
