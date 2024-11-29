package observer;

public class Usuario implements Observer {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " ha recibido la notificación: " + mensaje);
    }
}

