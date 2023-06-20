/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Grupo 5
 */
public class Citas {
    private Integer citaID;
    private LocalDate fecha_reserva;
    private String detalle;
    private Integer pacienteID;
    private String nombrePac;
    private String documento;
    private Integer medicoID;
    private String nombreMed;
    private String consultorio;
    private Integer pagoID;
    private Double monto;
    private String metodoPago;
    private Integer estadoID;
    private String descripcion;

    public Citas() {
    }

    public Citas(Integer citaID, LocalDate fecha_reserva, String detalle, Integer pacienteID, String nombrePac, String documento, Integer medicoID, String nombreMed, String consultorio, Integer pagoID, Double monto, String metodoPago, Integer estadoID, String descripcion) {
        this.citaID = citaID;
        this.fecha_reserva = fecha_reserva;
        this.detalle = detalle;
        this.pacienteID = pacienteID;
        this.nombrePac = nombrePac;
        this.documento = documento;
        this.medicoID = medicoID;
        this.nombreMed = nombreMed;
        this.consultorio = consultorio;
        this.pagoID = pagoID;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estadoID = estadoID;
        this.descripcion = descripcion;
    }

    public Integer getCitaID() {
        return citaID;
    }

    public void setCitaID(Integer citaID) {
        this.citaID = citaID;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Integer pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Integer medicoID) {
        this.medicoID = medicoID;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Integer getPagoID() {
        return pagoID;
    }

    public void setPagoID(Integer pagoID) {
        this.pagoID = pagoID;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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

    public void getDetalle(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
