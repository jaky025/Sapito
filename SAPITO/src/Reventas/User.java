/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reventas;

import javax.swing.JFrame;

/**
 *
 * @author Curso
 */
public class User  {
    private String name;
    private String lastname;
    private String secondname;
    private int id;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the employeeno
     */
    public int getId() {
        return id;
    }

    /**
     * @param employeeno the employeeno to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the secondname
     */
    public String getSecondname() {
        return secondname;
    }

    /**
     * @param secondname the secondname to set
     */
    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
    
    
}
