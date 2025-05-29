package practica.patron.singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;




public class Practica1Singleton {
    
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_ROJO = "\u001B[31m";
    private static final String COLOR_SUBR_ROJO = "\u001B[41m";
    
    private static final DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    
    
    
    public static void main(String[] args) {
        
        //
        // Mensaje inicial.
        //
        
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--  IBERIA APP                                                                                                        --");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        
        System.out.println("");
        System.out.println("Bienvenido a la aplicación de gestión de reservas de Iberia.");
        System.out.println("Espere mientras accedemos a los datos...");
        LockSupport.parkNanos(2_000_000_000L);
        
        System.out.println("");
        System.out.println(COLOR_SUBR_ROJO + "[Esta es una aplicación de uso académico. No se aplican las restricciones en materia de Protección de Datos.]" + COLOR_RESET);
        System.out.println("");
        
        
        //
        // Carga inicial.
        //
        
        Avion avion = Avion.getAvion();
        
        Map<Integer, Agencia> agencias = new HashMap<>();
        
        Agencia aHuelva  = new Agencia("Iberia Huelva", "Av. Martín Alonso Pinzón, 6, 21003, Huelva", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aSevilla = new Agencia("Iberia Sevilla", "Av. de la Constitución, 32, 41001, Sevilla", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aCadiz   = new Agencia("Iberia Cádiz", "Pl. de San Juan de Dios, 13, 11005, Cádiz", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aCordoba = new Agencia("Iberia Córdoba", "C. Capitulares, 1, 14002, Córdoba", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aJaen    = new Agencia("Iberia Jaén", "Pl. Santa María, 4, 23002, Jaén", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aGranada = new Agencia("Iberia Granada", "Pl. del Carmen, 3, 18009, Granada", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aMalaga  = new Agencia("Iberia Málaga", "Av. de Cervantes, 4, 29016, Málaga", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        Agencia aAlmeria = new Agencia("Iberia Almería", "Pl. de la Constitución, 7, 04003, Almería", "L-V: 10:00 - 14:00, 17:00 - 21:00");
        
        agencias.put(aHuelva.getIdAgencia(),  aHuelva);
        agencias.put(aSevilla.getIdAgencia(), aSevilla);
        agencias.put(aCadiz.getIdAgencia(),   aCadiz);
        agencias.put(aCordoba.getIdAgencia(), aCordoba);
        agencias.put(aJaen.getIdAgencia(),    aJaen);
        agencias.put(aGranada.getIdAgencia(), aGranada);
        agencias.put(aMalaga.getIdAgencia(),  aMalaga);
        agencias.put(aAlmeria.getIdAgencia(), aAlmeria);
        
        Map<Integer, Usuario> usuarios = new HashMap<>();
        
        Usuario uRN  = new Usuario("Rafael", "Nadal", "28000000A", LocalDate.of(1989, 6, 29));
        Usuario uSD  = new Usuario("Salvador", "Dalí", "28000000B", LocalDate.of(1985, 6, 11));
        Usuario uSRC = new Usuario("Santiago", "Ramón y Cajal", "28000000C", LocalDate.of(1982, 3, 16));
        Usuario uAM  = new Usuario("Antonio", "Machado", "28000000D", LocalDate.of(1984, 4, 23));
        Usuario uFG  = new Usuario("Francisco", "de Goya", "28000000E", LocalDate.of(1987, 10, 3));
        Usuario uDV  = new Usuario("Diego", "Velázquez", "28000000F", LocalDate.of(1984, 2, 28));
        
        usuarios.put(uRN.getIdUsuario(),  uRN);
        usuarios.put(uSD.getIdUsuario(),  uSD);
        usuarios.put(uSRC.getIdUsuario(), uSRC);
        usuarios.put(uAM.getIdUsuario(),  uAM);
        usuarios.put(uFG.getIdUsuario(),  uFG);
        usuarios.put(uDV.getIdUsuario(),  uDV);
        
        uRN.reservarAsientos(7);
        uSD.reservarAsientos(5);
        uSRC.reservarAsientos(3);
        uAM.reservarAsientos(1);
        uFG.reservarAsientos(5);
        uDV.reservarAsientos(2);
        
        
        //
        // Menú.
        //
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do {

            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                
                // 1. Consultar datos del vuelo.
                case 1:
                    System.out.println("\nOpción 1. Consultar datos del vuelo.\n");
                    consultarDatosVuelo(avion);
                    break;
                
                // 2. Consultar usuarios.
                case 2:
                    System.out.println("\nOpción 2. Consultar usuarios.\n");
                    consultarUsuarios(usuarios);
                    break;
                    
                // 3. Crear usuario.
                case 3:
                    System.out.println("\nOpción 3. Crear usuario.\n");
                    crearUsuario(usuarios, scanner);
                    break;
                    
                // 4. Consultar reservas de todos los usuarios.
                case 4:
                    System.out.println("\nOpción 4. Consultar reservas de todos los usuarios.\n");
                    consultarReservasTodosUsuarios(avion);
                    break;
                    
                // 5. Consultar reservas de un usuario.
                case 5:
                    System.out.println("\nOpción 5. Consultar reservas de un usuario.\n");
                    consultarReservasUsuario(avion, usuarios, scanner);
                    break;
                    
                // 6. Reservar asientos.
                case 6:
                    System.out.println("\nOpción 6. Reservar asientos.\n");
                    reservarAsientos(avion, usuarios, scanner);
                    break;
                    
                // 7. Anular asientos.
                case 7:
                    System.out.println("\nOpción 7. Anular asientos.\n");
                    anularAsientos(avion, usuarios, agencias, scanner);
                    break;
                    
                // 0. Salir.
                case 0:
                    System.out.println("\nGracias por visitar Iberia. ¡Que tenga un buen día!\n");
                    LockSupport.parkNanos(2_000_000_000L);
                    break;
                    
                default:
                    System.out.println("\nOpción inválida. Inténtelo de nuevo.\n");
                    
            }
        } while (opcion != 0);
        
        scanner.close();
        
    }
    
    
    
    
    // Mostrar menú principal.
    private static void mostrarMenu() {
        
        System.out.println("Seleccione una opción del menú:");
        System.out.println("");
        System.out.println("1. Consultar datos del vuelo.");
        System.out.println("2. Consultar usuarios.");
        System.out.println("3. Crear usuario.");
        System.out.println("4. Consultar reservas de todos los usuarios.");
        System.out.println("5. Consultar reservas de un usuario.");
        System.out.println("6. Reservar asientos.");
        System.out.println("7. Anular asientos.");
        System.out.println("0. Salir.");
        System.out.println("");
        
        System.out.print("Selección: ");
        
    }
    
    
    
    
    // Consultar los datos del vuelo.
    private static void consultarDatosVuelo(Avion avion) {
        
        // Protección.
        if (avion == null) return;
        
        
        // Mostrar datos del vuelo.
        System.out.println(avion.getCompania() + " " + avion.getNumVuelo() + ".");
        System.out.println(avion.getFabricante() + " " + avion.getModelo() + " (" + avion.getAnoFabricacion() + ") / " + avion.getCapacidadAsientos() + " asientos.");
        System.out.println("");
        
        System.out.println("Salida:");
        System.out.println("· " + avion.getSalidaAeropuerto() + ".");
        System.out.println("· " + avion.getSalidaFechaHora().format(dateTimeFormatter));
        System.out.println("");
        
        System.out.println("Llegada:");
        System.out.println("· " + avion.getLlegadaAeropuerto() + ".");
        System.out.println("· " + avion.getLlegadaFechaHora().format(dateTimeFormatter));
        System.out.println("");
        
    }
    
    
    
    
    // Consultar los usuarios.
    private static void consultarUsuarios(Map<Integer, Usuario> usuarios) {
        
        // Protección.
        if (usuarios == null) return;
        
        
        // Obtener y mostrar los datos de los usuarios.
        System.out.printf("%-4s %-20s %-40s %-12s %-17s %n", "Id", "Nombre", "Apellidos", "DNI", "Fecha Nacimiento");
        System.out.println("--------------------------------------------------------------------------------------------------");
        
        for (Map.Entry<Integer, Usuario> entry : usuarios.entrySet()) {
            Usuario usuario = entry.getValue();
            System.out.printf("%-4s %-20s %-40s %-12s %-17s %n", usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellidos(), usuario.getDni(), usuario.getFechaNacimiento().format(dateFormatter));
        }
        
        System.out.println("");
        
    }
    
    
    
    
    // Crear un nuevo usuario.
    private static void crearUsuario(Map<Integer, Usuario> usuarios, Scanner scanner) {
        
        // Protección.
        if (usuarios == null) return;
        if (scanner == null) return;
        
        
        // Solicitud de los datos.
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        
        System.out.print("Fecha de nacimiento (día): ");
        int dia = scanner.nextInt();
        
        System.out.print("Fecha de nacimiento (mes): ");
        int mes = scanner.nextInt();
        
        System.out.print("Fecha de nacimiento (año): ");
        int ano = scanner.nextInt();
        
        
        // Creación del usuario.
        Usuario usuario = new Usuario(nombre, apellidos, dni, LocalDate.of(ano, mes, dia));
        usuarios.put(usuario.getIdUsuario(), usuario);
        
        
        // Mostrar los datos del usuario.
        System.out.println("");
        System.out.println("El usuario ha sido creado:");
        System.out.println("");
        consultarUsuario(usuario);
        System.out.println("");
        
    }
    
    
    
    
    // Consultar un usuario.
    private static void consultarUsuario(Usuario usuario) {
        
        // Protección.
        if (usuario == null) return;
        
        
        // Obtener y mostrar todos los usuario.
        System.out.printf("%-4s %-20s %-40s %-12s %-17s %n", "Id", "Nombre", "Apellidos", "DNI", "Fecha Nacimiento");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s %-20s %-40s %-12s %-17s %n", usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellidos(), usuario.getDni(), usuario.getFechaNacimiento().format(dateFormatter));
        System.out.println("");
        
    }
    
    
    
    
    // Consultar las reservas de todos los usuarios.
    private static void consultarReservasTodosUsuarios(Avion avion) {
        
        // Protección.
        if (avion == null) return;
        
        
        // Obtener y mostrar todas las reservas.
        Map<String, ReservaAsiento> asientosReservados = avion.getAsientosReservados();
        
        System.out.printf("%-8s %-4s %n", "Asiento", "Id Usuario");
        System.out.println("-------------");
        
        for (Map.Entry<String, ReservaAsiento> entry : asientosReservados.entrySet()) {
            ReservaAsiento reservaAsiento = entry.getValue();
            System.out.printf("%-8s %-4s %n", reservaAsiento.getAsiento(), reservaAsiento.getIdUsuario());
        }
        
        System.out.println("");
        
    }
    
    
    
    
    // Consultar las reservas de un usuario.
    private static void consultarReservasUsuario(Avion avion, Map<Integer, Usuario> usuarios, Scanner scanner) {
        
        // Protección.
        if (avion == null) return;
        if (usuarios == null) return;
        if (scanner == null) return;
        
        
        // Elección de usuario.
        System.out.println("Los usuarios que existen en el sistema son los siguientes:");
        System.out.println("");
        
        consultarUsuarios(usuarios);
        
        System.out.print("Introduzca el Id del usuario del que quiere consultar sus reservas: ");
        int idUsuario = scanner.nextInt();
        
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario == null) {
            System.out.println("");
            System.out.println("No existe ningún usuario con el Id introducido.");
            System.out.println("");
            return;
        }
        
        
        // Obtener y preparar reservas del usuario.
        List<String> asientosReservados = avion.getAsientosReservadosDeUsuario(idUsuario);
        String asientos = "";
        
        for (String asiento : asientosReservados) {
            asientos = asientos + asiento + ", ";
        }
        
        
        // Mostrar reservas del usuario.
        if (asientosReservados.size() == 0) {
            System.out.println("");
            System.out.println("El usuario " + idUsuario + " no tiene asientos reservados.");
            System.out.println("");
            
        } else {
            asientos = asientos.substring(0, asientos.length()-2);
            System.out.println("");
            System.out.println("Los asientos reservados por el usuario " + idUsuario + " son los siguientes: " + asientos + ".");
            System.out.println("");
        }
        
    }
    
    
    
    
    // Reservar asientos para un usuario.
    private static void reservarAsientos(Avion avion, Map<Integer, Usuario> usuarios, Scanner scanner) {
        
        // Protección.
        if (avion == null) return;
        if (usuarios == null) return;
        if (scanner == null) return;
        
        
        // Obtener número de asientos disponibles.
        int numAsientosDisponibles = avion.getNumAsientosDisponibles();
        
        if (numAsientosDisponibles == 0) {
            System.out.println("Ya no quedan más asientos  para reservar. Sentimos las molestias.");
            System.out.println("");
            return;
        }
        
        
        // Elección del usuario.
        System.out.println("Los usuarios que existen en el sistema son los siguientes:");
        System.out.println("");
        
        consultarUsuarios(usuarios);
        
        System.out.print("Introduzca el Id de su usuario. Si no dispone de un usuario aún, introduzca '0' para volver atrás y crear uno. Introduzca el Id de su usuario: ");
        int idUsuario = scanner.nextInt();
        if (idUsuario == 0) {
            System.out.println("");
            return;
        }
        
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario == null) {
            System.out.println("");
            System.out.println("No existe ningún usuario con el Id introducido.");
            System.out.println("");
            return;
        }
        
        
        // Solicitud de número asientos a reservar.
        System.out.println("");
        System.out.print("El número de asientos que aún quedan disponibles para reservar son " + numAsientosDisponibles + ". Introduzca el número que quiere reservar: ");
        int numAsientosReservar = scanner.nextInt();
        
        if (numAsientosReservar > numAsientosDisponibles) {
            System.out.println("");
            System.out.println("Ha solicitado reservar " + numAsientosReservar + " asientos, pero sólo hay disponibles " + numAsientosDisponibles + ". No se ha procedido con la reserva de asientos.");
            System.out.println("");
            return;
        }
        
        
        // Reservar.
        boolean reservados = usuario.reservarAsientos(numAsientosReservar);
        
        if (reservados == true) {
            System.out.print("Se ha procedido a reservar el número de asientos solicitados. Gracias por confiar en Iberia.");
            System.out.println("");
            
        } else {
            System.out.print("Se ha producido un error durante la reserva de los asientos.");
            System.out.println("");
        }
        
    }
    
    
    
    
    // Anular asientos reservados por un usuario.
    private static void anularAsientos(Avion avion, Map<Integer, Usuario> usuarios, Map<Integer, Agencia> agencias, Scanner scanner) {
        
        // Protección.
        if (avion == null) return;
        if (usuarios == null) return;
        if (agencias == null) return;
        if (scanner == null) return;
        
        
        // Elección de la agencia.
        System.out.println("Esta gestión debe realizarse a través de una de nuestras agencias. Estas son las disponibles:");
        System.out.println("");
        
        consultarAgencias(agencias);
        
        System.out.print("Introduzca el Id de la agencia con la que quiere realizar la gestión: ");
        int idAgencia = scanner.nextInt();
        
        System.out.println("");
        System.out.println("Estamos conectando con la agencia seleccionada. Espere, por favor...");
        System.out.println("");
        LockSupport.parkNanos(4_000_000_000L);
        
        Agencia agencia = agencias.get(idAgencia);
        
        
        // Elección del usuario.
        System.out.println("Se encuentra en la agencia " + agencia.getNombre() + ".");
        System.out.println("");
        System.out.println("Ahora debe identificarse como usuario. Los que existen en el sistema son los siguientes:");
        System.out.println("");
        
        consultarUsuarios(usuarios);
        
        System.out.print("Introduzca el Id de su usuario: ");
        int idUsuario = scanner.nextInt();
        
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario == null) {
            System.out.println("");
            System.out.println("No existe ningún usuario con el Id introducido.");
            System.out.println("");
            return;
        }
        
        
        // Obtención de los asientos reservados por el usuario.
        int numAsientosReservados = avion.getAsientosReservadosDeUsuario(idUsuario).size();
        if (numAsientosReservados == 0) {
            System.out.println("");
            System.out.println("El usuario no tiene asientos reservados. Cancelamos el proceso de anulación.");
            System.out.println("");
            System.out.println("Estamos volviendo al sistema principal. Espere, por favor...");
            System.out.println("");
            LockSupport.parkNanos(4_000_000_000L);
            return;
        }
        
        
        // Solicitud de número asientos a anular.
        System.out.println("");
        System.out.print("El usuario tiene " + numAsientosReservados + " asientos reservados. Introduzca cuántos asientos quiere anular: ");
        int numAsientosAnular = scanner.nextInt();
        
        if (numAsientosAnular == 0) {
            System.out.println("");
            System.out.println("Ha elegido anular 0 asientos, por lo que no se ha procedido a anular ninguno. Cancelamos el proceso de anulación.");
            System.out.println("");
            System.out.println("Estamos volviendo al sistema principal. Espere, por favor...");
            System.out.println("");
            LockSupport.parkNanos(4_000_000_000L);
            return;
            
        } else if (numAsientosAnular > numAsientosReservados) {
            System.out.println("");
            System.out.println("No puede anular más asientos de los que tiene reservados. No se ha procedido a anular los asientos. Cancelamos el proceso de anulación.");
            System.out.println("");
            System.out.println("Estamos volviendo al sistema principal. Espere, por favor...");
            System.out.println("");
            LockSupport.parkNanos(4_000_000_000L);
            return;
        }
        
        
        // Anular.
        boolean anulados = agencia.anularAsientos(numAsientosAnular, idUsuario);
        
        if (anulados == true) {
            System.out.println("");
            System.out.print("Se ha procedido a anular el número de asientos solicitados. Gracias por confiar en Iberia.");
            System.out.println("");
            
        } else {
            System.out.println("");
            System.out.print("Se ha producido un error durante la anulación de los asientos.");
            System.out.println("");
        }
        
        System.out.println("Estamos volviendo al sistema principal. Espere, por favor...");
        System.out.println("");
        LockSupport.parkNanos(4_000_000_000L);
        
    }
    
    
    
    
    // Consultar las agencias.
    private static void consultarAgencias(Map<Integer, Agencia> agencias) {
        
        // Protección.
        if (agencias == null) return;
        
        
        // Obtener y mostrar las agencias.
        System.out.printf("%-4s %-20s %-60s %-40s %n", "Id", "Nombre", "Dirección Postal", "Horario");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        
        for (Map.Entry<Integer, Agencia> entry : agencias.entrySet()) {
            Agencia agencia = entry.getValue();
            System.out.printf("%-4s %-20s %-60s %-40s %n", agencia.getIdAgencia(), agencia.getNombre(), agencia.getDireccionPostal(), agencia.getHorario());
        }
        
        System.out.println("");
        
    }
    
}
