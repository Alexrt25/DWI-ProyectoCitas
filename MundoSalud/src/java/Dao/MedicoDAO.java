/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Especialidad;
import Modelo.Medico;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Ramos
 */
public class MedicoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar() {
        String sql = "select "
                + "m.medicoID,"
                + "m.nombre,"
                + "m.telefono,"
                + "m.email,"
                + "m.documento,"
                + "m.consultorio,"
                + "m.especialidadID "
                + "from medico m";
        
        List<Medico> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Medico medico = new Medico();
                medico.setMedicoId(rs.getInt("medicoID"));
                medico.setNombre(rs.getString("nombre"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setEmail(rs.getString("email"));
                medico.setDocumento(rs.getString("documento"));
                medico.setConsultorio(rs.getString("consultorio"));
                //medico.setActivo(Boolean.valueOf(rs.getString("activo")));
                
                Especialidad especialidad = new Especialidad();
                especialidad.setEspecialidadId(rs.getInt("especialidadID"));
                medico.setEspecialidad(especialidad);
                
                //medico.setAsignacionHorarioMedicoList(new ArrayList<>());
                
                lista.add(medico);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public int agregar(Medico medico) {
        int medicoId = 0;
        String sql = "insert into medico("
                + "nombre,"
                + "telefono,"
                + "email,"
                + "documento,"
                + "consultorio,"
                + "especialidadID) "
                + "values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getTelefono());
            ps.setString(3, medico.getEmail());
            ps.setString(4, medico.getDocumento());
            ps.setString(5, medico.getConsultorio());
            ps.setInt(6, medico.getEspecialidad().getEspecialidadId());
            //ps.setBoolean(7, medico.getActivo());

            //ps.executeUpdate();
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    medicoId = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return medicoId;
    }
    
    public boolean editar(Medico medico) {
        String sql = "update medico"
                + "set "
                + "nombre = ?,"
                + "telefono = ?,"
                + "email = ?,"
                + "documento = ?,"
                + "consultorio = ?,"
                + "especialidadID = ?"
                + "where medicoId = ?";
        boolean resul =false;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getTelefono());
            ps.setString(3, medico.getEmail());
            ps.setString(4, medico.getDocumento());
            ps.setString(5, medico.getConsultorio());
            ps.setInt(6, medico.getEspecialidad().getEspecialidadId());
            //ps.setBoolean(7, medico.getActivo());

            ps.setInt(8, medico.getMedicoId());

            ps.executeUpdate();
            resul = true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return resul;
    }
    
    
}
