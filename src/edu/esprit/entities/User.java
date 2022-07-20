/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Slimen OUNI
 */
public class User {
     private int id;
    private String pseudo;
    private String password;
  private String email;
  private int role;
 private String RandCode;
 private int Status;

    public User(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    
    
    public String getRandCode() {
        return RandCode;
    }

    public void setRandCode(String RandCode) {
        this.RandCode = RandCode;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", pseudo=" + pseudo + ", password=" + password + ", email=" + email + ", role=" + role + ", RandCode=" + RandCode + ", Status=" + Status + '}';
    }

   
  
    
}
