/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Estado;
import Config.Conexion;
import Modelo.Citas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo 5
 */
public class EstadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int agregar(Estado est) {
        Integer estadoID = 0;
        String sql = "insert into estado (descripcion)values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, est.getDescripcion());
            ps.setInt(2, est.getEstadoID());
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    estadoID = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return estadoID;
    }
    
    public boolean editar(Estado est) {
        boolean resultado = false;
        String sql = "update estado set descripcion=? where estadoID=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, est.getDescripcion());
            ps.setInt(2, est.getEstadoID());

            ps.executeUpdate();
            resultado = true;

            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
    
    public boolean eliminar(int id){
        boolean resultado  = false;
        String sql="delete from estado where estadoID="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
     public List listaPorId() {
        String sql = "SELECT * FROM estado";
        List<Estado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estado est = new Estado();
                est.setEstadoID(rs.getInt("estadoID"));
                est.setDescripcion(rs.getString("descripcion"));
                lista.add(est);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
}
