/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author preet
 */
public class SUBJECT_MODEL {
    public String SUBJECT_CODE;
    public String NAME;
    public String FACULTY_CODE;

    public SUBJECT_MODEL() {
    }

    @Override
    public String toString() {
        return "SUBJECT_MODEL{" + "SUBJECT_CODE=" + SUBJECT_CODE + ", NAME=" + NAME + ", FACULTY_CODE=" + FACULTY_CODE + '}';
    }

    public SUBJECT_MODEL(String SUBJECT_CODE, String NAME, String FACULTY_CODE) {
        this.SUBJECT_CODE = SUBJECT_CODE;
        this.NAME = NAME;
        this.FACULTY_CODE = FACULTY_CODE;
    }

    public SUBJECT_MODEL(String SUBJECT_CODE, String NAME) {
        this.SUBJECT_CODE = SUBJECT_CODE;
        this.NAME = NAME;
    }

    public String getSUBJECT_CODE() {
        return SUBJECT_CODE;
    }

    public void setSUBJECT_CODE(String SUBJECT_CODE) {
        this.SUBJECT_CODE = SUBJECT_CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getFACULTY_CODE() {
        return FACULTY_CODE;
    }

    public void setFACULTY_CODE(String FACULTY_CODE) {
        this.FACULTY_CODE = FACULTY_CODE;
    }
    
    
}
