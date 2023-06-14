/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author PC
 */
public class Cita {
    private Integer idCita;
    private String fechaCreacion;
    private Integer idCliente;
    private Integer idAsesor;
    private String inicio;
    private String finEsperado;
    private String fin;
    private String enlaceMeet;
    private Integer idEstadoCita;
    private String SidEstadoCita;
    private Integer idMotivo;
    private Integer idRango;
    private String horaRango;
    private String nombreAsesor;
    private String nombreEstado;
    private String nombreCliente;
    private String nombreMotivo;
    private String docuCliente;

public Cita(){};

    public Cita(Integer idCita, String fechaCreacion, Integer idCliente, Integer idAsesor, String inicio, String finEsperado, String fin, String enlaceMeet, Integer idEstadoCita, Integer idMotivo,
            String nombreAsesor, String nombreEstado,String nombreCliente, String nombreMotivo, String docuCliente) {
        this.idCita = idCita;
        this.fechaCreacion = fechaCreacion;
        this.idCliente = idCliente;
        this.idAsesor = idAsesor;
        this.inicio = inicio;
        this.finEsperado = finEsperado;
        this.fin = fin;
        this.enlaceMeet = enlaceMeet;
        this.idEstadoCita = idEstadoCita;
        this.idMotivo = idMotivo;
        this.nombreAsesor = nombreAsesor;
        this.nombreEstado = nombreEstado;
        this.nombreCliente = nombreCliente;
        this.nombreMotivo = nombreMotivo;
        this.docuCliente = docuCliente;
    }

    public Cita(Integer idCliente, Integer idAsesor, String inicio, String enlaceMeet, Integer idEstadoCita, Integer idMotivo, Integer idRango) {
        
      
        this.idCliente = idCliente;
        this.idAsesor = idAsesor;
        this.inicio = inicio;
        this.enlaceMeet = enlaceMeet;
        this.idEstadoCita = idEstadoCita;
        this.idMotivo = idMotivo;
        this.idRango = idRango;
    }

    public Cita(Integer idCita, String inicio, String fin, String enlaceMeet, Integer idEstadoCita, Integer idMotivo) {
        this.idCita = idCita;
        this.inicio = inicio;
        this.fin = fin;
        this.enlaceMeet = enlaceMeet;
        this.idEstadoCita = idEstadoCita;
        this.idMotivo = idMotivo;
    }

     public Cita(Integer idCita, Integer idAsesor, String enlaceMeet, Integer idEstadoCita) {
        this.idCita = idCita;
        this.idAsesor = idAsesor;
        this.enlaceMeet = enlaceMeet;
        this.idEstadoCita = idEstadoCita;
    }
     
    public Cita(Integer idCita, String fechaCreacion, Integer idCliente, Integer idAsesor, String inicio, String fin, String enlaceMeet, String SidEstadoCita, Integer idMotivo) {
        this.idCita = idCita;
        this.fechaCreacion = fechaCreacion;
        this.idCliente = idCliente;
        this.idAsesor = idAsesor;
        this.inicio = inicio;
        this.fin = fin;
        this.enlaceMeet = enlaceMeet;
        this.SidEstadoCita = SidEstadoCita;
        this.idMotivo = idMotivo;
    }
 


    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAsesor() {
        return idAsesor;
    }

    public void setIdAsesor(int idAsesor) {
        this.idAsesor = idAsesor;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFinEsperado() {
        return finEsperado;
    }

    public void setFinEsperado(String finEsperado) {
        this.finEsperado = finEsperado;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getEnlaceMeet() {
        return enlaceMeet;
    }

    public void setEnlaceMeet(String enlaceMeet) {
        this.enlaceMeet = enlaceMeet;
    }

    public int getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(int idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    public String getSidEstadoCita() {
        return SidEstadoCita;
    }

    public void setSidEstadoCita(String SidEstadoCita) {
        this.SidEstadoCita = SidEstadoCita;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreMotivo() {
        return nombreMotivo;
    }

    public String getDocuCliente() {
        return docuCliente;
    }

    public void setNombreMotivo(String nombreMotivo) {
        this.nombreMotivo = nombreMotivo;
    }

    public void setDocuCliente(String docuCliente) {
        this.docuCliente = docuCliente;
    }

    public Integer getIdRango() {
        return idRango;
    }

    public void setIdRango(Integer idRango) {
        this.idRango = idRango;
    }

    public String getHoraRango() {
        return horaRango;
    }

    public void setHoraRango(String horaRango) {
        this.horaRango = horaRango;
    }


}



