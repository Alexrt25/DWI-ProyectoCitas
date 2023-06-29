/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author lisbetmoron
 */
public class Especialidad {
    private Integer especialidadID;
    private String nombre;

    public Especialidad(Integer especialidadID, String nombre) {
        this.especialidadID = especialidadID;
        this.nombre = nombre;
    }
    
    public Especialidad(){
        
    }
    
    public Integer getEspecialidadID() {
        return especialidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEspecialidadID(Integer especialidadID) {
        this.especialidadID = especialidadID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
