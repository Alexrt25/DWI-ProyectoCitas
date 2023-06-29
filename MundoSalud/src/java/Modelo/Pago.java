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
public class Pago {
    private Integer pagoID;
    private LocalDate fecha;
    private Double monto;
    private String metodoPago;

    public Pago() {
    }

    public Pago(Integer pagoID, LocalDate fecha, Double monto, String metodoPago) {
        this.pagoID = pagoID;
        this.fecha = fecha;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public Integer getPagoID() {
        return pagoID;
    }

    public void setPagoID(Integer pagoID) {
        this.pagoID = pagoID;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
    
}
