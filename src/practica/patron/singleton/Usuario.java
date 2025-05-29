package practica.patron.singleton;

import java.time.LocalDate;
import java.util.List;




public class Usuario {
    
    private static int contadorId = 0;
    
    private final int idUsuario;
    private String nombre;
    private String apellidos;
    private String dni;
    private LocalDate fechaNacimiento;
    
    private Avion avion;
    
    
    
    
    // Constructor.
    public Usuario(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
        
        this.idUsuario = ++contadorId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        
        this.avion = Avion.getAvion();
        
    }
    
    
    
    
    // Reservar asientos para el usuario.
    public boolean reservarAsientos(int numAsientosReservar) {
        
        // Declaraciones.
        boolean reservarAsientos = false;
        
        
        // Reservar asientos.
        List<String> asientosReservados = avion.reservar(numAsientosReservar, idUsuario);
        if (asientosReservados.size() == numAsientosReservar) reservarAsientos = true;
        
        
        // Devolver.
        return reservarAsientos;
        
    }
    
    
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
