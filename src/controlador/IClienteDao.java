/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author tpp
 */
public interface IClienteDao {
     public boolean insert(Cliente cliente);
    //metodo  para actualizar
    public boolean update(Cliente cliente);
    //metodo para buscar por id
    public Cliente serchbyid(int id);
    //metodo para elminar la sreserva
    public boolean delete(Cliente cliente);
    //metodo para listar las reservas
    public List<Cliente> listAll();
}
