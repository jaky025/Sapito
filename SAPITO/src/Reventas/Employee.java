/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reventas;

import java.util.Date;

/**
 *
 * @author Curso
 */
public class Employee extends User{
    private int employeeid;
    private String position;
    private String password;
    private String username;
    private Date hiringdate;

    /**
     * @return the employeeid
     */
    public int getEmployeeid() {
        return employeeid;
    }

    /**
     * @param employeeid the employeeid to set
     */
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the hiringdate
     */
    public Date getHiringdate() {
        return hiringdate;
    }

    /**
     * @param hiringdate the hiringdate to set
     */
    public void setHiringdate(Date hiringdate) {
        this.hiringdate = hiringdate;
    }
    
}
