/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author preet
 */
public class STUDENT_MODEL {
    public String USERNAME;
    public String NAME;
    public String STUDENTID;

    public STUDENT_MODEL() {
    }

    @Override
    public String toString() {
        return "STUDENT_MODEL{" + "USERNAME=" + USERNAME + ", NAME=" + NAME + ", STUDENTID=" + STUDENTID + '}';
    }

    public STUDENT_MODEL(String USERNAME, String NAME) {
        this.USERNAME = USERNAME;
        this.NAME = NAME;
    }

    public STUDENT_MODEL(String USERNAME, String NAME, String STUDENTID) {
        this.USERNAME = USERNAME;
        this.NAME = NAME;
        this.STUDENTID = STUDENTID;
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

    public String getSTUDENTID() {
        return STUDENTID;
    }

    public void setSTUDENTID(String STUDENTID) {
        this.STUDENTID = STUDENTID;
    }
    
    
}
