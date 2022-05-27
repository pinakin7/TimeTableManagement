/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author preet
 */
public class USER_MODEL {
    public String USERNAME;
    public String PASSWORD;
    public String USERCODE;

    public USER_MODEL(String USERNAME, String PASSWORD, String USERCODE) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.USERCODE = USERCODE;
    }

    public USER_MODEL() {
    }

    @Override
    public String toString() {
        return "USER_MODEL{" + "USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", USERCODE=" + USERCODE + '}';
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSERCODE() {
        return USERCODE;
    }

    public void setUSERCODE(String USERCODE) {
        this.USERCODE = USERCODE;
    }
    
    
}
