/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Time;

  
        

/**
 *
 * @author preet
 */

public class TIME_TABLE_MODEL {
    public String COURSE_CODE;
    public String FACULTY_CODE;
    public String BLOCK;
    public int ROOM_NUMBER;
    public Time START_TIME;
    public Time END_TIME;
    public String DAY;

    public TIME_TABLE_MODEL(String COURSE_CODE, String FACULTY_CODE, String BLOCK, int ROOM_NUMBER, Time START_TIME, Time END_TIME, String DAY) {
        this.COURSE_CODE = COURSE_CODE;
        this.FACULTY_CODE = FACULTY_CODE;
        this.BLOCK = BLOCK;
        this.ROOM_NUMBER = ROOM_NUMBER;
        this.START_TIME = START_TIME;
        this.END_TIME = END_TIME;
        this.DAY = DAY;
    }

    @Override
    public String toString() {
        return "TIME_TABLE_MODEL{" + "COURSE_CODE=" + COURSE_CODE + ", FACULTY_CODE=" + FACULTY_CODE + ", BLOCK=" + BLOCK + ", ROOM_NUMBER=" + ROOM_NUMBER + ", START_TIME=" + START_TIME + ", END_TIME=" + END_TIME + ", DAY=" + DAY + '}';
    }

    public TIME_TABLE_MODEL() {
    }

    public String getCOURSE_CODE() {
        return COURSE_CODE;
    }

    public void setCOURSE_CODE(String COURSE_CODE) {
        this.COURSE_CODE = COURSE_CODE;
    }

    public String getFACULTY_CODE() {
        return FACULTY_CODE;
    }

    public void setFACULTY_CODE(String FACULTY_CODE) {
        this.FACULTY_CODE = FACULTY_CODE;
    }

    public String getBLOCK() {
        return BLOCK;
    }

    public void setBLOCK(String BLOCK) {
        this.BLOCK = BLOCK;
    }

    public int getROOM_NUMBER() {
        return ROOM_NUMBER;
    }

    public void setROOM_NUMBER(int ROOM_NUMBER) {
        this.ROOM_NUMBER = ROOM_NUMBER;
    }

    public Time getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(Time START_TIME) {
        this.START_TIME = START_TIME;
    }

    public Time getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(Time END_TIME) {
        this.END_TIME = END_TIME;
    }

    public String getDAY() {
        return DAY;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }
    
    
    
}
