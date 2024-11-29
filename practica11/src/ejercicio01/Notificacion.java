package ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Notificacion implements Subject {
    private List<Observer> usuarios;
    private String mensaje;
    
    public Notificacion() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void agregar(Observer usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void eliminar(Observer usuario) {
        usuarios.remove(usuario);
    }

    @Override
    public void notificar() {
        for (Observer usuario : usuarios) {
            usuario.actualizar(mensaje);
        }
    }

    // Método para establecer el mensaje y notificar a todos los usuarios
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        notificar();
    }
}

