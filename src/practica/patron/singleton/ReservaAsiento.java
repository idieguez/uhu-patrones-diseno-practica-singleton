package practica.patron.singleton;




public class ReservaAsiento {
    
    private String asiento;
    private long idUsuario;
    
    
    
    
    public ReservaAsiento(String asiento, long idUsuario) {
        
        this.asiento = asiento;
        this.idUsuario = idUsuario;
        
    }
    
    
    
    
    public String getAsiento() {
        return this.asiento;
    }
    
    public long getIdUsuario() {
        return this.idUsuario;
    }
    
}
