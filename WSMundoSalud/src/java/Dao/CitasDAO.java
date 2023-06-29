/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Citas;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo 5
 */
public class CitasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Citas validar(String pacienteID) {
        Citas cis = new Citas();
        String sql = "select * from cita where pacienteID=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, pacienteID);
            rs = ps.executeQuery();
            while (rs.next()) {
                cis.setCitaID(rs.getInt("citaID"));
                cis.setFecha_reserva(LocalDate.parse(rs.getString("fecha_reserva")));
                cis.setDetalle(rs.getString("detalle"));
                cis.setPacienteID(rs.getInt("pacienteID"));
                cis.setEstadoID(rs.getInt("estadoID"));
                cis.setMedicoID(rs.getInt("medicoID"));
                cis.setPagoID(rs.getInt("pagoID"));
            }
        } catch (Exception e) {
        }
        return cis;
    }
    
    //Operaciones CRUD
    public List listar() {
        String sql = "select cs.citaID, cs.fecha_reserva, cs.detalle, p.nombre paciente, p.documento docpaciente, m.nombre medico, m.consultorio, p.monto, \n" + ""
                + "p.metodoPago, est.descripcion estado\n"
                + "from cita cs inner join paciente p on cs.pacienteID = p.pacienteID\n"
                + "inner join medico m on m.medicoID = cs.medicoID\n"
                + "inner join pago p on p.pagoID = cs.pagoID\n"
                + "inner join estado est on est.estadoID = cs.estadoID\n";
        List<Citas> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Citas cis = new Citas();
                cis.setCitaID(rs.getInt("citaID"));
                cis.setFecha_reserva(LocalDate.parse(rs.getString("fecha_reserva")));
                cis.setDetalle(rs.getString("detalle"));
                cis.setNombrePac(rs.getString("paciente"));
                cis.setDocumento(rs.getString("docpaciente"));
                cis.setNombreMed(rs.getString("medico"));
                cis.setConsultorio(rs.getString("consultorio"));
                cis.setMonto(rs.getDouble("monto"));
                cis.setMetodoPago(rs.getString("metodoPago"));
                cis.setDescripcion(rs.getString("estado"));
                lista.add(cis);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listInner(int id) {
        String sql = "SELECT descripcion FROM cita cs INNER JOIN estado est ON cs.estadoID=est.estadoID";
        List<Citas> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Citas cis = new Citas();
                cis.setDescripcion(rs.getString("descripcion"));
                lista.add(cis);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listInner2(int id) {
        String sql = "SELECT nombre FROM cita cs INNER JOIN medico m ON cs.medicoID=m.medicoID";
        List<Citas> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Citas cis = new Citas();
                cis.setNombreMed(rs.getString("nombre"));
                lista.add(cis);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Citas cis) {
        int citaID = 0;
        String sql = "insert into cita(fecha_reserva, detalle, pacienteID, estadoID, medicoID, pagoID)values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cis.getFecha_reserva().toString());
            ps.setString(2, cis.getDetalle());
            ps.setInt(3, cis.getPacienteID());
            ps.setInt(4, cis.getEstadoID());
            ps.setInt(5, cis.getMedicoID());
            ps.setInt(6, cis.getPagoID());
            
         //ps.executeUpdate();
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    citaID = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return citaID;
    }
    
    public Citas listarId(int id) {
        Citas cis = new Citas();
        String sql = "select * from cita where citaID=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cis.setCitaID(rs.getInt(1));
                cis.setFecha_reserva(LocalDate.parse(rs.getString(2)));
                cis.setDetalle(rs.getString(3));
                cis.setPacienteID(rs.getInt(4));
                cis.setEstadoID(rs.getInt(5));
                cis.setMedicoID(rs.getInt(6));
                cis.setPagoID(rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return cis;
    }
    
    public boolean editar(Citas cis) {
        String sql = "update cita set fecha_reserva=?, detalle=?, pacienteID=?, estadoID=?, medicoID=?, pagoID=? where citaID=?";
        boolean resul =false;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, cis.getFecha_reserva().toString());
            ps.setString(2, cis.getDetalle());
            ps.setInt(3, cis.getPacienteID());
            ps.setInt(4, cis.getEstadoID());
            ps.setInt(5, cis.getMedicoID());
            ps.setInt(6, cis.getPagoID());
            ps.setInt(7, cis.getCitaID());

            ps.executeUpdate();
            resul = true;
        } catch (Exception e) {
        }
        return resul;
    }
    
    public void eliminar(int id) {
        String sql = "delete from cita where citaID=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
