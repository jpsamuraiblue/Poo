/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Reserva;

/**
 *
 * @author tpp
 */
public interface IReservaDao {
    //metodo para insert una reserva
    public boolean insert(Reserva reserva);
    //metodo  para actualizar
    public boolean update(Reserva reserva);
    //metodo para buscar por id
    public Reserva serchbyid(int id);
    //metodo para elminar la sreserva
    public boolean delete(Reserva reserva);
    //metodo para listar las reservas
    public List<Reserva> listAll();
    
    
}
