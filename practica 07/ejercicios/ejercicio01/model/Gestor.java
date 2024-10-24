package ejercicio01.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private static final String FILE_NAME = "personajes.txt";
    private List<Personaje> personajes;

    public Gestor() {
        personajes = leerPersonajes();
    }

    // Leer personajes desde el archivo
    private List<Personaje> leerPersonajes() {
        List<Personaje> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            lista = (List<Personaje>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando una nueva lista.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }

    // Guardar personajes en el archivo
    private void guardarPersonajes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(personajes);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Añadir personaje
    public void anadirPersonaje(Personaje personaje) {
        if (buscarPersonaje(personaje.getNombre()) == null) {
            personajes.add(personaje);
            guardarPersonajes();
            System.out.println("Personaje añadido exitosamente.");
        } else {
            System.out.println("El personaje ya existe.");
        }
    }

    // Buscar personaje
    public Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // Modificar personaje
    public void modificarPersonaje(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) {
            personaje.setVida(nuevaVida);
            personaje.setAtaque(nuevoAtaque);
            personaje.setDefensa(nuevaDefensa);
            personaje.setAlcance(nuevoAlcance);
            guardarPersonajes();
            System.out.println("Personaje modificado exitosamente.");
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    // Eliminar personaje
    public void eliminarPersonaje(String nombre) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) {
            personajes.remove(personaje);
            guardarPersonajes();
            System.out.println("Personaje eliminado exitosamente.");
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    // Mostrar todos los personajes
    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
        } else {
            personajes.forEach(System.out::println);
        }
    }
}
