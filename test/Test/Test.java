package Test;

import Utils.ConexionSingleton;
import controlador.IClienteDao;
import controlador.IReservaDao;
import controladorimpl.ClienteDaoimpl;
import controladorimpl.ReservaDaoImpl;


import java.sql.*;
import java.util.List;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Usuario;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Test test = new Test();
//        test.testConexion();
 //        test.listReservas();
      //   test.insert();
     //  test.delete();
    // test.Searchbyid();
    test.insertCliente();
        
        
    }
    // metodo para tester  metodos
    public void testConexion(){
        ConexionSingleton c = new ConexionSingleton();
        try {
            Connection connection = c.getConnection();
         if(connection != null && !connection.isClosed()){
             System.out.println("conexion exitosa");
            } else {
                System.out.println("Conexion fallida: La conexion está cerrada");

            }
                 
            
        } catch (Exception e) {
            System.out.println("Error de conexion"+ e.getMessage());
            e.printStackTrace();
        }
    }
    public void listReservas(){
        IReservaDao reservaDao = new ReservaDaoImpl();
        List<Reserva> listaResrva = reservaDao.listAll();
        if(listaResrva != null && !listaResrva.isEmpty()){
            for(Reserva reserva : listaResrva){
                System.out.println("idReserva"+reserva.getIdReserva());
                System.out.println("Fechaingreso"+reserva.getFechaIngreso());
                System.out.println("FechaSalida"+reserva.getFechaSalida());
                System.out.println("NumeroPiso"+reserva.getNumeroPiso());
                System.out.println("NumeroHabiacion"+reserva.getNumeroPiso());
                System.out.println("Costo"+reserva.getCosto());
                System.out.println("Estado:"+reserva.getEstado());
                System.out.println("Estado:"+reserva.getUsuario().getUser());
                System.out.println("Estado:"+reserva.getCliente().getNombre());
                
            }
        }
        
    }
    public void insert(){
        Reserva r = new Reserva();
        
        Cliente c = new Cliente();
        Usuario u = new Usuario();
        
        r.setFechaIngreso("10/10/2024");
        r.setFechaSalida("12/10/2024");
        r.setNumeroPiso("2");
        r.setNumeroHabitacion(202);
        r.setCosto(80.00);
        r.setEstado("R");
        c.setIdCliente(1);
        u.setIdUsuario(1);
        r.setCliente(c);
        r.setUsuario(u);
         IReservaDao reservaDao = new ReservaDaoImpl();
        boolean result = reservaDao.insert(r);
        if(result){
            System.out.println("success");
        }else{
            System.out.println("error");
        }
        
        
    }
    public void delete (){
        Reserva r = new Reserva();
        r.setIdReserva(4);
         IReservaDao reservaDao = new ReservaDaoImpl();
        boolean result = reservaDao.delete(r);
        if(result){
            System.out.println("success");
        }else{
            System.out.println("error");
        }
        
    }
    public void Searchbyid(){
        IReservaDao reservaDao =  new ReservaDaoImpl();
        Reserva r = reservaDao.serchbyid(1);
        if(r != null){
        System.out.println("idReserva"+r.getIdReserva());
                System.out.println("Fechaingreso"+r.getFechaIngreso());
                System.out.println("FechaSalida"+r.getFechaSalida());
                System.out.println("NumeroPiso"+r.getNumeroPiso());
                System.out.println("NumeroHabiacion"+r.getNumeroPiso());
                System.out.println("Costo"+r.getCosto());
                System.out.println("Estado:"+r.getEstado());
               
                System.out.println("Estado:"+r.getCliente().getNombre());
    }else{
            System.out.println("no exite ese id");
            }
    }
    public void  update(){
         Reserva r = new Reserva();
        
        Cliente c = new Cliente();
        Usuario u = new Usuario();
        
        r.setFechaIngreso("10/10/2024");
        r.setFechaSalida("12/10/2024");
        r.setNumeroPiso("2");
        r.setNumeroHabitacion(202);
        r.setCosto(80.00);
        r.setEstado("R");
     c.setIdCliente(1);
     u.setIdUsuario(1);
     r.setCliente(c);
        r.setUsuario(u);
        r.setIdReserva(1);
         IReservaDao reservaDao = new ReservaDaoImpl();
        boolean result = reservaDao.insert(r);
        if(result){
            System.out.println("success update ;");
        }else{
            System.out.println("error");
        }
    }
     public void insertCliente(){
        
        Cliente c = new Cliente();
        
        
        c.setNombre("10/10/2024");
       c.setApellidos("12/10/2024");
        c.setDni("2");
        c.getEmail();
        c.setGenero("Masculino");
        
       
         IClienteDao clienteDao = new ClienteDaoimpl();
        boolean result = clienteDao.insert(c);
        if(result){
            System.out.println("success");
        }else{
            System.out.println("error");
        }
        
        
    }
     

}
