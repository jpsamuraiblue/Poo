
package modelo;


public class Cliente extends Persona {
    private int idCliente; 
    private String email;
    private String genero;

    public Cliente() {
    }

    public Cliente(int idCliente, String email, String genero, String nombre, String apellidos, String dni) {
        super(nombre, apellidos, dni);
        this.idCliente = idCliente;
        this.email = email;
        this.genero = genero;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

   
    
    
    
}
