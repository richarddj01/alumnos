/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    private static Connection _cn = null;
    
    private conexion(){
        
    } 
    
    public static Connection cn(){
        try{
            if(_cn == null){
                Class.forName("org.sqlite.JDBC");
                _cn = DriverManager.getConnection("jdbc:sqlite:alumnos.db");
            }
            return _cn;
        }catch(Exception e){
            System.err.println("Error "+e.getMessage());
            return null;
        }
    }
}
