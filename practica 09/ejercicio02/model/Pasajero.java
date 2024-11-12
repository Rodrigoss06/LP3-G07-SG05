package Ejercicio02.model;

public class Pasajero {
    private String nombre;
    private String documento;
    private String fechaViaje;
    private boolean auriculares;
    private boolean manta;
    private boolean revistas;
    private String origen;
    private String destino;
    private String calidadServicio;

    public Pasajero() {}

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public boolean isAuriculares() {
        return auriculares;
    }

    public void setAuriculares(boolean auriculares) {
        this.auriculares = auriculares;
    }

    public boolean isManta() {
        return manta;
    }

    public void setManta(boolean manta) {
        this.manta = manta;
    }

    public boolean isRevistas() {
        return revistas;
    }

    public void setRevistas(boolean revistas) {
        this.revistas = revistas;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCalidadServicio() {
        return calidadServicio;
    }

    public void setCalidadServicio(String calidadServicio) {
        this.calidadServicio = calidadServicio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Documento: " + documento + "\n" +
               "Fecha de Viaje: " + fechaViaje + "\n" +
               "Servicios Opcionales: " + 
               (auriculares ? "Auriculares " : "") +
               (manta ? "Manta " : "") +
               (revistas ? "Revistas" : "") + "\n" +
               "Origen: " + origen + "\n" +
               "Destino: " + destino + "\n" +
               "Calidad de Servicio: " + calidadServicio;
    }
}
