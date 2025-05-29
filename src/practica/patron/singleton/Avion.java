package practica.patron.singleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public final class Avion {
    
    private static final Avion avion = new Avion();
    
    private static String compania;
    private static String numVuelo;
    
    private static String salidaAeropuerto;
    private static LocalDateTime salidaFechaHora;
    private static String llegadaAeropuerto;
    private static LocalDateTime llegadaFechaHora;
    
    private static String fabricante;
    private static String modelo;
    private static int anoFabricacion;
    private static int capacidadAsientos;
    
    private static List<String> asientos;
    private static Map<String, ReservaAsiento> asientosReservados;
    
    
    
    
    // Constructor.
    private Avion() {
        
        // Datos.
        compania = "Iberia";
        numVuelo = "IB243";
        
        salidaAeropuerto = "MAD - Aeropuerto Adolfo Suárez Madrid-Barajas (Madrid, España)";
        salidaFechaHora = LocalDateTime.of(2025, 8, 12, 15, 00);
        
        llegadaAeropuerto = "SJO - Aeropuerto Juan Santamaría-Alajuela (San José, Costa Rica)";
        llegadaFechaHora = LocalDateTime.of(2025, 8, 12, 17, 50);
        
        fabricante = "Airbus";
        modelo = "A320-200";
        anoFabricacion = 2022;
        capacidadAsientos = 180;
        
        // Asientos.
        asientos = new ArrayList<>();
        asientosReservados = new HashMap<>();
        
        // Inicialización de los asientos.
        List<Integer> filas = getFilasAsientos();
        List<Character> letras = getLetrasAsientos();
        
        for (int fila : filas) {
            for (char letra : letras) {
                asientos.add(String.valueOf(fila) + String.valueOf(letra));
            }
        }
        
    }
    
    
    
    
    // Reservar asientos para un usuario.
    public static List<String> reservar(int numAsientos, long idUsuario) {
        
        // Protección.
        if (numAsientos <= 0) return new ArrayList<>();                                                     // El numAsientos no puede ser 0 o negativo.
        if (numAsientos > (capacidadAsientos - asientosReservados.size())) return new ArrayList<>();        // El numAsientos no puede ser mayor a los asientos disponibles.
        
        
        // Declaraciones.
        List<String> asientosRecienReservados = new ArrayList<>();
        
        
        // Recorrer todos los asientos que posee el avión y comprobar si están reservados.
        // Los que no estén aún reservados, se reservan para el usuario.
        for (String asiento : asientos) {
            if (!asientosReservados.containsKey(asiento)) {
                
                ReservaAsiento reservaAsiento = new ReservaAsiento(asiento, idUsuario);                     // Crear la reserva: asiento + usuario.
                asientosReservados.put(asiento, reservaAsiento);                                            // Añadir a la lista de reservas.
                asientosRecienReservados.add(asiento);                                                      // Añadir los asientos a una lista para devolver al usuario.
                if (asientosRecienReservados.size() == numAsientos) break;                                  // Parar el proceso de reservas cuando ya se haya reservado el número de asientos solicitados.
            
            }
        }
        
        
        // Devolver.
        return asientosRecienReservados;
        
    }
    
    
    
    
    // Anular asientos reservados por un usuario.
    public static List<String> anular(int numAsientos, long idUsuario) {
        
        // Protección.
        if (numAsientos <= 0) return new ArrayList<>();                                                     // El numAsientos no puede ser 0 o negativo.
        if (numAsientos > getAsientosReservadosDeUsuario(idUsuario).size()) return new ArrayList<>();       // El numAsientos no puede ser superior a los asientos reservados por el usuario.
        
        
        // Declaraciones.
        List<String> asientosReservadosDeUsuario = getAsientosReservadosDeUsuario(idUsuario);
        List<String> asientosAnuladosDeUsuario = new ArrayList<String>();
        
        
        // Recorrer los asientos reservados por el usuario y eliminarlos de la lista de reservas hasta llegar al número indicado.
        for (String asientoReservadoDeUsuario : asientosReservadosDeUsuario) {
            
            asientosReservados.remove(asientoReservadoDeUsuario);                                           // Eliminar de la lista de reservas.
            asientosAnuladosDeUsuario.add(asientoReservadoDeUsuario);                                       // Añadir en listado que se devuelve al usuario con los asientos anulados.
            if (asientosAnuladosDeUsuario.size() == numAsientos) break;                                     // Parar el proceso de anulación cuando haya llegado al número indicado.
            
        }
        
        
        // Devolver.
        return asientosAnuladosDeUsuario;
        
    }
    
    
    
    
    // Obtener los asientos reservados por un usuario.
    public static List<String> getAsientosReservadosDeUsuario(long idUsuario) {
        
        // Declaraciones.
        List<String> asientosReservadosPorUsuario = new ArrayList<String>();
        
        
        // Recorrer la lista de reservas y localizar los asientos asignados al usuario.
        // Almacenar estos asientos en una lista para luego devolverla.
        for (Map.Entry<String, ReservaAsiento> reserva : asientosReservados.entrySet()) {
            
            String asientoReserva = reserva.getValue().getAsiento();
            long idUsuarioReserva = reserva.getValue().getIdUsuario();
            
            if (idUsuarioReserva == idUsuario) {
                asientosReservadosPorUsuario.add(asientoReserva);
            }
            
        }
        
        
        // Devolver.
        return asientosReservadosPorUsuario;
        
    }
    
    
    
    
    // Utilidad para inicializar las filas de asientos del avión.
    private static List<Integer> getFilasAsientos() {
        
        List<Integer> filas = new ArrayList<>();
        
        filas.add(1);
        filas.add(2);
        filas.add(3);
        filas.add(4);
        filas.add(5);
        filas.add(6);
        filas.add(7);
        filas.add(8);
        filas.add(9);
        filas.add(10);
        filas.add(11);
        filas.add(12);
        filas.add(13);
        filas.add(14);
        filas.add(15);
        filas.add(16);
        filas.add(17);
        filas.add(18);
        filas.add(19);
        filas.add(20);
        
        return filas;
        
    }
    
    
    
    
    // Utilidad para inicializar las letras de asientos del avión.
    private static List<Character> getLetrasAsientos() {
        
        List<Character> letras = new ArrayList<>();
        
        letras.add('A');
        letras.add('B');
        letras.add('C');
        letras.add('D');
        letras.add('E');
        letras.add('F');
        letras.add('G');
        letras.add('H');
        letras.add('I');
        
        return letras;
        
    }
    
    
    
    
    // Obtener el número de asientos aún disponibles para reserva.
    public static int getNumAsientosDisponibles() {
        
        return capacidadAsientos - asientosReservados.size();
        
    }
    
    
    
    
    public static Avion getAvion() {
        return avion;
    }

    public static String getCompania() {
        return compania;
    }

    public static String getNumVuelo() {
        return numVuelo;
    }

    public static String getSalidaAeropuerto() {
        return salidaAeropuerto;
    }

    public static LocalDateTime getSalidaFechaHora() {
        return salidaFechaHora;
    }

    public static String getLlegadaAeropuerto() {
        return llegadaAeropuerto;
    }

    public static LocalDateTime getLlegadaFechaHora() {
        return llegadaFechaHora;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static String getModelo() {
        return modelo;
    }

    public static int getAnoFabricacion() {
        return anoFabricacion;
    }

    public static int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public static List<String> getAsientos() {
        return asientos;
    }

    public static Map<String, ReservaAsiento> getAsientosReservados() {
        return asientosReservados;
    }
    
}
