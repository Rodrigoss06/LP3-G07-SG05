package ejercicio01;


public class GestorNotificaciones {

    public static void main(String[] args) {
        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan");
        Usuario usuario2 = new Usuario("Ana");
        Usuario usuario3 = new Usuario("Carlos");

        // Crear un objeto de notificación
        Notificacion notificacion = new Notificacion();
        
        // Suscribir usuarios a las notificaciones
        notificacion.agregar(usuario1);
        notificacion.agregar(usuario2);
        notificacion.agregar(usuario3);

        // Enviar una notificación
        notificacion.setMensaje("¡Promoción especial de fin de año!");

        // Desuscribir a un usuario
        notificacion.eliminar(usuario2);

        // Enviar otra notificación
        notificacion.setMensaje("Nuevo producto disponible en la tienda.");
    }
}
