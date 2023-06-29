/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Grupo 5
 */
public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost/bdmundosalud";
    String user="root";
    String pass="";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión establecida");
        } catch (Exception e) {
        }
        return con;
    }
}
