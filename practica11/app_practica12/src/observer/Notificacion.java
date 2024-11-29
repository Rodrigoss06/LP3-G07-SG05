package observer;

import java.util.ArrayList;
import java.util.List;

public class Notificacion implements Subject {
    private List<Observer> usuarios = new ArrayList<>();
    private String mensaje;

    @Override
    public void agregar(Observer observer) {
        usuarios.add(observer);
    }

    @Override
    public void eliminar(Observer observer) {
        usuarios.remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer usuario : usuarios) {
            usuario.actualizar(mensaje);
        }
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        notificar();
    }
}

