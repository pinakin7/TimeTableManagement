/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author preet
 */
public class ENROLLMENTS_MODEL {

    public String COURSE_ID;
    public String STUDENT_ID;

    public ENROLLMENTS_MODEL(String COURSE_ID, String STUDENT_ID) {
        this.COURSE_ID = COURSE_ID;
        this.STUDENT_ID = STUDENT_ID;
    }

    @Override
    public String toString() {
        return "ENROLLMENTS_MODEL{" + "COURSE_ID=" + COURSE_ID + ", STUDENT_ID=" + STUDENT_ID + '}';
    }

    public String getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(String COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getSTUDENT_ID() {
        return STUDENT_ID;
    }

    public void setSTUDENT_ID(String STUDENT_ID) {
        this.STUDENT_ID = STUDENT_ID;
    }
    
    
    
    public ENROLLMENTS_MODEL() {
    }
    
    
}
