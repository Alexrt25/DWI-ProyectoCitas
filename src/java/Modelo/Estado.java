/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Grupo 5
 */
public class Estado {
    private Integer estadoID;
    private String descripcion;

    public Estado() {
    }

    public Estado(Integer estadoID, String descripcion) {
        this.estadoID = estadoID;
        this.descripcion = descripcion;
    }

    public Integer getEstadoID() {
        return estadoID;
    }

    public void setEstadoID(Integer estadoID) {
        this.estadoID = estadoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     
}


