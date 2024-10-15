/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorimpl;

import Utils.ConexionSingleton;
import controlador.IClienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author tpp
 */
public class ClienteDaoimpl implements IClienteDao{
    private Connection cn;

    @Override
    public boolean insert(Cliente cliente) {
        boolean flag = false;
     PreparedStatement st;
     String query = null;
        try {
            query = "INSERT INTO cliente (Nombre, Apellidos,Dni,Email,Genero)"+" VALUES (?,?,?,?,?,?,?,?);";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, cliente.getNombre());
             st.setString(2, cliente.getApellidos());
            st.setString(3, cliente.getDni());
            st.setString(5, cliente.getEmail());
           st.setString(5, cliente.getGenero());
           
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al ingrear al cliente" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                
            }
            flag = false;
            System.out.println("Error,No se pudo al cliente");
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
    public boolean update(Cliente cliente) {
           boolean flag = false;
     PreparedStatement st;
     String query = null;
        try {
            query = "Update INTO cliente (Nombre, Apellidos,Dni,Email,Genero)";
                  
           cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, cliente.getNombre());
             st.setString(2, cliente.getApellidos());
            st.setString(3, cliente.getDni());
            st.setString(5, cliente.getEmail());
           st.setString(5, cliente.getGenero());
           
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al actualizar  al cliente" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                
            }
            flag = false;
            System.out.println("Error,No se pudo al cliente");
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
    public Cliente serchbyid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
