/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author lisbetmoron
 */
public class Horario {
   //Variables de clase
    private Integer horarioId;
    private String diaSemana;
    private Time horaInicio;
    private Time horaFin;
    //private Boolean activo;
    
    //Relaciones
    //private DiaDeAtencion dia;
    private Medico medico;

    public Horario() {
    }

    /*GETTER AND SETTER*/
    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
    
    /*public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public DiaDeAtencion getDia() {
        return dia;
    }

    public void setDia(DiaDeAtencion dia) {
        this.dia = dia;
    }*/

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    
    
}
