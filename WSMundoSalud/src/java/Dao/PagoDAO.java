/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Pago;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Grupo 5
 */
public class PagoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int agregar(Pago pg) {
        Integer pagoID = 0;
        String sql = "insert into pago (fecha, monto, metodoPago)values (DATE(NOW()),?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pg.getMonto());
            ps.setString(2, pg.getMetodoPago());
            ps.setInt(3, pg.getPagoID());
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    pagoID = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return pagoID;
    }
    
    public boolean editar(Pago pg) {
        boolean resultado = false;
        String sql = "update pago set fecha=DATE(NOW()), monto=?, metodoPago=?  where pagoID=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setDouble(1, pg.getMonto());
            ps.setString(2, pg.getMetodoPago());
            ps.setInt(3, pg.getPagoID());

            ps.executeUpdate();
            resultado = true;

            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
    
    public boolean eliminar(int id){
        boolean resultado  = false;
        String sql="delete from pago where pagoID="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
}
