/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Alex Ramos
 */
public class Medico {
    
    //Variables de clase
    private Integer medicoId;
    private String nombre;
    private String telefono;
    private String email;
    private String documento;
    private String consultorio;
    //private Boolean activo;
    
    //Relaciones
    private Especialidad especialidad;
    //private List<AsignacionHorarioMedico> asignacionHorarioMedicoList;

    public Medico() {
    }
    
    /*GETTER AND SETTER*/
    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    /*public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }*/

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /*public List<AsignacionHorarioMedico> getAsignacionHorarioMedicoList() {
        return asignacionHorarioMedicoList;
    }

    public void setAsignacionHorarioMedicoList(List<AsignacionHorarioMedico> asignacionHorarioMedicoList) {
        this.asignacionHorarioMedicoList = asignacionHorarioMedicoList;
    }*/
}
