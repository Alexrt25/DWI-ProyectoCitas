/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alex Ramos
 */
public class Especialidad {
    
    //Variables de clase
    private Integer especialidadId;
    private String nombre;
    //private Boolean activo;

    public Especialidad() {
    }

    /*GETTER AND SETTER*/
    public Integer getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Integer especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }*/
    
}
