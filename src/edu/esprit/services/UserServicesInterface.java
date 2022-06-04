/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import java.util.List;

/**
 *
 * @author Slimen OUNI
 */
public interface UserServicesInterface {
    
    
        public void updateUser(Object o);
        public  void addUser(Object o);
        public  void removeUser(Object o);
        public  List<Object> listUsers();
        public  Object listUsersById(Object o);

}
