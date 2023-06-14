/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class CitaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cita validar(String idcliente) {
        Cita ci = new Cita();
        String sql = "select * from cita where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, idcliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                ci.setIdCita(rs.getInt("IdCita"));
                ci.setFechaCreacion(rs.getString("FechaCreacion"));
                ci.setIdCliente(rs.getInt("IdCliente"));
                ci.setIdAsesor(rs.getInt("IdAsesor"));
                ci.setInicio(rs.getString("Inicio"));
                // ci.setFinEsperado(rs.getString("FinEsperado"));
                ci.setFin(rs.getString("Fin"));
                ci.setEnlaceMeet(rs.getString("EnlaceMeet"));
                ci.setIdEstadoCita(rs.getInt("IdEStadoCita"));
                ci.setIdMotivo(rs.getInt("IdMotivo"));

            }
        } catch (Exception e) {
        }
        return ci;
    }

    //Operaciones CRUD
    public List listar() {
        String sql = "select c.idCita, c.Inicio fechaReserva ,uc.Nombre cliente, cl.DocumentoIdentidad docCliente,\n" +
        "u.Nombre asesor, m.DescripcionMotivo motivo, e.EstadoCita estado, c.EnlaceMeet, a.IdAsesor, h.HoraRango\n" +
        "from cita c inner join asesor a on c.idAsesor = a.idAsesor\n" +
        "inner join usuario u on u.IdUsuario = a.IdUsuario\n" +
        "inner join estado_cita e on e.IdEstadoCita = c.IdEstadoCita\n" +
        "inner join cliente cl on cl.IdCliente = c.IdCliente\n" +
        "inner join usuario uc on uc.IdUsuario = cl.IdUsuario\n" +
        "inner join motivo m on m.IdMotivo = c.IdMotivo\n"+
        "inner join rango_horario h on h.IdRango = c.IdRango";
        List<Cita> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Cita ci = new Cita();
                ci.setIdCita(rs.getInt("IdCita"));
                ci.setInicio(rs.getString("fechaReserva"));
                ci.setNombreCliente(rs.getString("cliente"));
                ci.setDocuCliente(rs.getString("docCliente"));
                ci.setNombreAsesor(rs.getString("asesor"));
                ci.setNombreMotivo(rs.getString("motivo"));
                ci.setNombreEstado(rs.getString("estado"));
                ci.setEnlaceMeet(rs.getString("EnlaceMeet"));
                ci.setIdAsesor(rs.getInt("IdAsesor"));
                ci.setHoraRango(rs.getString("HoraRango"));
                //listInner(id);
                lista.add(ci);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listarParaAsesor(int asesor) {
        String sql = "select c.idCita, c.Inicio fechaReserva ,uc.Nombre cliente, cl.DocumentoIdentidad docCliente,\n" +
        "u.Nombre asesor, m.DescripcionMotivo motivo, e.EstadoCita estado, c.EnlaceMeet, a.IdUsuario, h.HoraRango\n" +
        "from cita c inner join asesor a on c.idAsesor = a.idAsesor\n" +
        "inner join usuario u on u.IdUsuario = a.IdUsuario\n" +
        "inner join estado_cita e on e.IdEstadoCita = c.IdEstadoCita\n" +
        "inner join cliente cl on cl.IdCliente = c.IdCliente\n" +
        "inner join usuario uc on uc.IdUsuario = cl.IdUsuario\n" +
        "inner join motivo m on m.IdMotivo = c.IdMotivo\n"+
        "inner join rango_horario h on h.IdRango = c.IdRango WHERE a.IdUsuario=" + asesor;
        List<Cita> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Cita ci = new Cita();
                ci.setIdCita(rs.getInt("IdCita"));
                ci.setInicio(rs.getString("fechaReserva"));
                ci.setNombreCliente(rs.getString("cliente"));
                ci.setDocuCliente(rs.getString("docCliente"));
                ci.setNombreAsesor(rs.getString("asesor"));
                ci.setNombreMotivo(rs.getString("motivo"));
                ci.setNombreEstado(rs.getString("estado"));
                ci.setEnlaceMeet(rs.getString("EnlaceMeet"));
                ci.setIdAsesor(rs.getInt("IdUsuario"));
                ci.setHoraRango(rs.getString("HoraRango"));
                //listInner(id);
                lista.add(ci);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listarParaClientes(int cliente) {
        String sql = "select c.idCita, c.Inicio fechaReserva ,uc.Nombre cliente, cl.DocumentoIdentidad docCliente,\n" +
        "u.Nombre asesor, m.DescripcionMotivo motivo, e.EstadoCita estado, c.EnlaceMeet, cl.IdUsuario, h.HoraRango\n" +
        "from cita c inner join asesor a on c.idAsesor = a.idAsesor\n" +
        "inner join usuario u on u.IdUsuario = a.IdUsuario\n" +
        "inner join estado_cita e on e.IdEstadoCita = c.IdEstadoCita\n" +
        "inner join cliente cl on cl.IdCliente = c.IdCliente\n" +
        "inner join usuario uc on uc.IdUsuario = cl.IdUsuario\n" +
        "inner join motivo m on m.IdMotivo = c.IdMotivo\n"+
        "inner join rango_horario h on h.IdRango = c.IdRango WHERE cl.IdUsuario=" + cliente;
        List<Cita> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Cita ci = new Cita();
                ci.setIdCita(rs.getInt("IdCita"));
                ci.setInicio(rs.getString("fechaReserva"));
                ci.setNombreCliente(rs.getString("cliente"));
                ci.setDocuCliente(rs.getString("docCliente"));
                ci.setNombreAsesor(rs.getString("asesor"));
                ci.setNombreMotivo(rs.getString("motivo"));
                ci.setNombreEstado(rs.getString("estado"));
                ci.setEnlaceMeet(rs.getString("EnlaceMeet"));
                ci.setIdCliente(rs.getInt("IdUsuario"));
                ci.setHoraRango(rs.getString("HoraRango"));
                //listInner(id);
                lista.add(ci);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
        //Operaciones CRUD
    public List listarPRUEBA() {
        String sql2 = "SELECT idCita as Cita,FechaCreacion,idCliente as Cliente,idAsesor as Asesor,"
                + "Inicio,Fin,EnlaceMeet,EstadoCita as EstadoCita,IdMotivo as Motivo FROM cita c "
                + "INNER JOIN estado_cita ec ON c.IdEstadoCita=ec.IdEstadoCita";
        List<Cita> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita ci = new Cita();
                ci.setIdCita(rs.getInt("Cita"));
                ci.setFechaCreacion(rs.getString("FechaCreacion"));
                ci.setIdCliente(rs.getInt("Cliente"));
                ci.setIdAsesor(rs.getInt("Asesor"));
                ci.setInicio(rs.getString("Inicio"));
                //ci.setFinEsperado(rs.getString("FinEsperado"));
                ci.setFin(rs.getString("Fin"));
                ci.setEnlaceMeet(rs.getString("EnlaceMeet"));
                ci.setSidEstadoCita(rs.getString("EstadoCita"));
                ci.setIdMotivo(rs.getInt("Motivo"));
                lista.add(ci);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    

    public List listInner(int id) {
        String sql = "SELECT EstadoCita FROM cita c INNER JOIN estado_cita ec ON c.IdEstadoCita=ec.IdEstadoCita";
        List<Cita> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita ci = new Cita();
                ci.setSidEstadoCita(rs.getString("SidEstadoCita"));
                lista.add(ci);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Cita ci) {
        int idCita = 0;
        String sql = "insert into cita(FechaCreacion,IdCliente,IdAsesor,Inicio,FinEsperado,Fin,EnlaceMeet,EstadoCita,IdMotivo)values(?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ci.getFechaCreacion());
            ps.setInt(2, ci.getIdCliente());
            ps.setInt(3, ci.getIdAsesor());
            ps.setString(4, ci.getInicio());
            ps.setString(5, ci.getFinEsperado());
            ps.setString(6, ci.getFin());
            ps.setString(7, ci.getEnlaceMeet());
            ps.setInt(8, ci.getIdEstadoCita());
            ps.setInt(9, ci.getIdMotivo());

            //ps.executeUpdate();
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idCita = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return idCita;
    }

    public int addCita(Cita ci) {
        int idCita = 0;
        String sql = "insert into cita(IdCliente,IdAsesor,Inicio,EnlaceMeet,IdEstadoCita,IdMotivo,IdRango)values(?,?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ci.getIdCliente());
            ps.setInt(2, ci.getIdAsesor());
            ps.setString(3, ci.getInicio());
            ps.setString(4, ci.getEnlaceMeet());
            ps.setInt(5, ci.getIdEstadoCita());
            ps.setInt(6, ci.getIdMotivo());
            ps.setInt(7, ci.getIdRango());
            //ps.executeUpdate();
            if (ps.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idCita = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return idCita;
    }

    public Cita listarId(int id) {
        Cita ci = new Cita();
        String sql = "select * from cita where IdCita=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ci.setIdCita(rs.getInt(1));
                ci.setFechaCreacion(rs.getString(2));
                ci.setIdCliente(rs.getInt(3));
                ci.setIdAsesor(rs.getInt(4));
                ci.setInicio(rs.getString(5));
                //ci.setFinEsperado(rs.getString(6));
                ci.setFin(rs.getString(6));
                ci.setEnlaceMeet(rs.getString(7));
                ci.setIdEstadoCita(rs.getInt(8));
                ci.setIdMotivo(rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return ci;
    }

    public boolean editar(Cita ci) {
        String sql = "update cita set IdAsesor=?,IdEstadoCita=?,EnlaceMeet=? where IdCita=?";
        boolean resul =false;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, ci.getIdAsesor());
            ps.setInt(2, ci.getIdEstadoCita());
            ps.setString(3, ci.getEnlaceMeet());
          //  ps.setString(3, ci.getEnlaceMeet());
            ps.setInt(4, ci.getIdCita());

            ps.executeUpdate();
            resul = true;
        } catch (Exception e) {
        }
        return resul;
    }
    
    public boolean editarPorAsesor(Cita ci) {
        String sql = "update cita set IdEstadoCita=?,EnlaceMeet=? where IdCita=?";
        boolean resul =false;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, ci.getIdEstadoCita());
            ps.setString(2, ci.getEnlaceMeet());
          //  ps.setString(3, ci.getEnlaceMeet());
            ps.setInt(3, ci.getIdCita());

            ps.executeUpdate();
            resul = true;
        } catch (Exception e) {
        }
        return resul;
    }

    public void eliminar(int id) {
        String sql = "delete from cita where IdCita=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
