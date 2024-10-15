/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorimpl;

import Utils.ConexionSingleton;
import controlador.IReservaDao;
import java.util.List;
import modelo.Reserva;
import java.sql.*;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author tpp
 */
public class ReservaDaoImpl implements IReservaDao {

    private Connection cn;
    
    @Override
    public boolean insert(Reserva reserva) {
     boolean flag = false;
     PreparedStatement st;
     String query = null;
        try {
            query = "INSERT INTO reserva (fechaIngreso, fechaSalida,numeroPiso, numeroHabitacion,"+" costo, estado, Cliente_id, usuario_id)"+" VALUES (?,?,?,?,?,?,?,?);";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, reserva.getFechaIngreso());
            st.setString(2, reserva.getFechaSalida());
            st.setString(3, reserva.getNumeroPiso());
            st.setInt(4, reserva.getNumeroHabitacion());
            st.setDouble(5, reserva.getCosto());
            st.setString(6, reserva.getEstado());
            st.setInt(7, reserva.getCliente().getIdCliente());
            st.setInt(8, reserva.getUsuario().getIdUsuario());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al inserta una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                
            }
            flag = false;
            System.out.println("Error,No se pudo agregar en registro");
        }finally{
             if (cn != null) {
                try {
                    
                } catch (Exception e) {
                }
            }
            
        }
        return flag;
    }
    
    @Override
    public boolean update(Reserva reserva) {
        boolean flag = false;
     PreparedStatement st;
     String query = null;
        try {
            query = "Update reserva  set fechaIngreso = ?, fechaSalida = ?,numeroPiso = ?, numeroHabitacion = ?,"
                    +" costo  = ?, estado = ?, Cliente_id = ?,)"
                    + "where idReserva = ?; ";
                  
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, reserva.getFechaIngreso());
            st.setString(2, reserva.getFechaSalida());
            st.setString(3, reserva.getNumeroPiso());
            st.setInt(4, reserva.getNumeroHabitacion());
            st.setDouble(5, reserva.getCosto());
            st.setString(6, reserva.getEstado());
            st.setInt(7, reserva.getCliente().getIdCliente());
            st.setInt(8, reserva.getIdReserva());
            
            
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al inserta una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                
            }
            flag = false;
            System.out.println("Error,No se pudo agregar en registro");
        }finally{
             if (cn != null) {
                try {
                    
                } catch (Exception e) {
                }
            }
            
        }
        return flag;
    }
    
    public Reserva serchbyid(int id) {
    Reserva re = null;
   Cliente cl;
   PreparedStatement st;
        //declaro la variable que va a conteer  la consulta
        ResultSet rs;
        String query = null;
        try {
             query = "SELECT r.idreserva, r.fechaIngreso, r.fechaSalida, r.numeroPiso, "
                + "r.numeroHabitacion, r.costo, r.estado, c.nombre, u.user "
                + "FROM reserva r, cliente c, usuario u "
                + "WHERE r.cliente_id = c.idcliente "
                + "AND r.usuario_id = u.idUsuario "
                + "AND r.idreserva = ?;"; // Consulta original
             cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
             rs  = st.executeQuery();
             if (rs.next()) {
                re = new Reserva();
                cl = new Cliente();
                re.setIdReserva(rs.getInt("idreserva"));
                re.setFechaIngreso(rs.getString("fechaIngreso"));
                re.setFechaSalida(rs.getNString("fechaSalida"));
                re.setNumeroPiso(rs.getString("numeroPiso"));
                re.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
                re.setCosto(rs.getDouble("costo"));
                re.setEstado(rs.getString("estado"));
                
                cl.setNombre(rs.getString("nombre"));
                
                re.setCliente(cl);
               
                
            }
        } catch (Exception e) {
            System.out.println("error al busca id " + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
        } finally {
            if (cn != null) {
                try {
                    
                } catch (Exception e) {
                }
            }
        }
        return re;
}

    
    @Override
    public boolean delete(Reserva reserva) {
       boolean flag = false;
     PreparedStatement st;
     String query = null;
        try {
        query = "DELETE from reserva WHERE idReserva = ?";
        
            cn = ConexionSingleton.getConnection();
           st = cn.prepareStatement(query);
            st.setInt(4, reserva.getIdReserva());
            st.executeUpdate();
            
            flag = true;
        } catch (Exception e) {
            System.out.println("error al inserta una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                
            }
            flag = false;
            System.out.println("Error,No se pudo agregar en registro");
        }finally{
             if (cn != null) {
                try {
                    
                } catch (Exception e) {
                }
            }
            
        }
        return flag;
    }
    
    @Override
    public List<Reserva> listAll() {
        //delcaracion de un arregalo
        List<Reserva> lista = null;
        //declar la clase reserva
        Reserva re;
        //decalarar la clase cliente
        
        Cliente cl;
        Usuario us;
        //declaro el que para la consulta a la  base de datis
        
        PreparedStatement st;
        //declaro la variable que va a conteer  la consulta
        ResultSet rs;
        String query = null;
        try {
            query = " Select r.idreserva,r.fechaIngreso,r.fechaSalida, r.numeroPiso, "
                    + " r.numeroHabitacion,r.costo,r.estado,c.nombre,u.user from reserva r,cliente c,usuario u"
                    + " where r.cliente_id = c.idcliente"
                    + " And r.usuario_id = u.idUsuario;";
            //obreescribir la lisa en un arreglo
            lista = new ArrayList<>();
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            us = new Usuario();
            
            rs = st.executeQuery();
            while (rs.next()) {
                re = new Reserva();
                cl = new Cliente();
                re.setIdReserva(rs.getInt("idreserva"));
                re.setFechaIngreso(rs.getString("fechaIngreso"));
                re.setFechaSalida(rs.getNString("fechaSalida"));
                re.setNumeroPiso(rs.getString("numeroPiso"));
                re.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
                re.setCosto(rs.getDouble("costo"));
                re.setEstado(rs.getString("estado"));
                
                cl.setNombre(rs.getString("nombre"));
                us.setUser(rs.getString("user"));
                re.setCliente(cl);
                re.setUsuario(us);
                lista.add(re);
                
            }
            
        } catch (Exception e) {
            System.out.println("error al listar a las reservas" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
        } finally {
            if (cn != null) {
                try {
                    
                } catch (Exception e) {
                }
            }
        }
        return lista;
        
    }
    
    
}
