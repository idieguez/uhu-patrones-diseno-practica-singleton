package practica.patron.singleton;

import java.util.List;




public class Agencia {
    
    private static int contadorId = 0;
    
    private final int idAgencia;
    private String nombre;
    private String direccionPostal;
    private String horario;
    
    private Avion avion;
    
    
    
    
    // Constructor.
    public Agencia(String nombre, String direccionPostal, String horario) {
        
        this.idAgencia = ++contadorId;
        this.nombre = nombre;
        this.direccionPostal = direccionPostal;
        this.horario = horario;
        
        this.avion = Avion.getAvion();
        
    }
    
    
    
    
    // Anular asientos reservados por un usuario.
    public boolean anularAsientos(int numAsientosAnular, int idUsuario) {
        
        // Declaraciones.
        boolean anularAsientos = false;
        
        
        // Anular asientos.
        List<String> asientosAnulados = avion.anular(numAsientosAnular, idUsuario);
        if (asientosAnulados.size() == numAsientosAnular) anularAsientos = true;
        
        
        // Devolver.
        return anularAsientos;
        
    }
    
    
    
    
    public int getIdAgencia() {
        return idAgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
