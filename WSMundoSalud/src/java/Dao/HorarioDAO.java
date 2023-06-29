/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Modelo.Citas;
import Modelo.Horario;
import Modelo.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lisbetmoron
 */
public class HorarioDAO {
    
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar() {
        String sql = "select "
                + "h.horarioId,"
                + "h.horaInicio,"
                + "h.horaFin,"
                + "h.diaId,"
                + "h.activo "
                + "from horario h ";
        
        List<Horario> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Horario horario = new Horario();
                horario.setHorarioId(rs.getInt("horarioId"));
                horario.setDiaSemana(rs.getString("diaSemana"));
                horario.setHoraInicio(rs.getTime("horaInicio"));
                horario.setHoraFin(rs.getTime("horaFin"));
                //horario.setActivo(Boolean.valueOf(rs.getString("activo")));
                
                /*DiaDeAtencion diaDeAtencion = new DiaDeAtencion();
                diaDeAtencion.setDiaId(rs.getInt("diaId"));
                horario.setDia(diaDeAtencion);*/
                
                Medico medico = new Medico();
                medico.setMedicoId(rs.getInt("meidcoID"));
                
                lista.add(horario);
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return lista;
    }
    
    public int agregar(Horario horario) {
        int horarioId = 0;
        String sql = "insert into horario("
                + "diaSemana,"
                + "horaInicio,"
                + "horaFin,"
                + "medicoID "
                + "values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, horario.getDiaSemana());
            ps.setTime(2, horario.getHoraInicio());
            ps.setTime(3, horario.getHoraFin());
            ps.setInt(4, horario.getMedico().getMedicoId());
            //ps.setBoolean(4, horario.getActivo());

            //ps.executeUpdate();
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    horarioId = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return horarioId;
    }
    
    public boolean editar(Horario horario) {
        String sql = "update horario "
                + "set "
                + "diaSemana = ?,"
                + "horaInicio = ?,"
                + "horaFin = ?,"
                + "medicoID = ? "
                + "where horarioId = ?";
        boolean resul =false;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, horario.getDiaSemana());
            ps.setTime(2, horario.getHoraInicio());
            ps.setTime(3, horario.getHoraFin());
            ps.setInt(4, horario.getMedico().getMedicoId());
            //ps.setBoolean(4, horario.getActivo());

            ps.setInt(5, horario.getHorarioId());

            ps.executeUpdate();
            resul = true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return resul;
    }
    
}
