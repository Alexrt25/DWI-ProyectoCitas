/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Modelo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lisbetmoron
 */
public class EspecialidadDAO {
      Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    
    public List listar() {
        String sql = "select "
                + "e.especialidadID,"
                + "e.nombre "
                + "from especialidad e ";
        
        List<Especialidad> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Especialidad especialidad = new Especialidad();
                especialidad.setEspecialidadID(rs.getInt("especialidadID"));
                especialidad.setNombre(rs.getString("nombre"));
                //especialidad.setActivo(Boolean.valueOf(rs.getString("activo")));
                
                lista.add(especialidad);
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return lista;
    }
}
