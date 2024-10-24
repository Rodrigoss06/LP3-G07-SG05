package ejercicio02.model;

import java.io.*;
import java.util.*;

public class Gestor {

    private static final String FILE_NAME = "personajes.txt";
    private List<Personaje> personajes;

    public Gestor() {
        personajes = leerPersonajes();
        cargarPersonajesAleatorios();
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

    // Actualizar un atributo individual
    public void actualizarAtributoIndividual(String nombre, String atributo, int nuevoValor) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) {
            switch (atributo.toLowerCase()) {
                case "vida":
                    personaje.setVida(nuevoValor);
                    break;
                case "ataque":
                    personaje.setAtaque(nuevoValor);
                    break;
                case "defensa":
                    personaje.setDefensa(nuevoValor);
                    break;
                case "alcance":
                    personaje.setAlcance(nuevoValor);
                    break;
                default:
                    System.out.println("Atributo no válido.");
                    return;
            }
            guardarPersonajes();
            System.out.println("Atributo actualizado exitosamente.");
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

    // Filtrar personajes por atributo
    public void filtrarPersonajesPorAtributo(String atributo) {
        Comparator<Personaje> comparator;
        switch (atributo.toLowerCase()) {
            case "vida":
                comparator = Comparator.comparingInt(Personaje::getVida);
                break;
            case "ataque":
                comparator = Comparator.comparingInt(Personaje::getAtaque);
                break;
            case "defensa":
                comparator = Comparator.comparingInt(Personaje::getDefensa);
                break;
            case "alcance":
                comparator = Comparator.comparingInt(Personaje::getAlcance);
                break;
            default:
                System.out.println("Atributo no válido.");
                return;
        }

        personajes.stream()
                .sorted(comparator.reversed())
                .forEach(System.out::println);
    }

    // Mostrar estadísticas
    public void mostrarEstadisticas() {
        int totalPersonajes = personajes.size();
        double promedioVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promedioDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promedioAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("Estadísticas Generales:");
        System.out.println("Total de personajes: " + totalPersonajes);
        System.out.println("Vida promedio: " + promedioVida);
        System.out.println("Ataque promedio: " + promedioAtaque);
        System.out.println("Defensa promedio: " + promedioDefensa);
        System.out.println("Alcance promedio: " + promedioAlcance);
    }

    // Cargar personajes aleatorios
    private void cargarPersonajesAleatorios() {
        if (personajes.isEmpty()) {
            personajes.add(new Personaje("Caballero", 5, 4, 4, 3, 1));
            personajes.add(new Personaje("Arquero", 3, 5, 2, 8, 1));
            personajes.add(new Personaje("Guerrero", 4, 4, 5, 2, 1));
            guardarPersonajes();
        }
    }

    // Mejorar atributos con nivel
    public void mejorarNivel(String nombre) {
        Personaje personaje = buscarPersonaje(nombre);
        if (personaje != null) { 
        	personaje.subirNivel(); 
        	guardarPersonajes(); 
        	System.out.println("Personaje " + nombre + " ha subido de nivel a " + personaje.getNivel()); 
        } else { 
        	System.out.println("Personaje no encontrado."); 
        } 
     }
    public void importarPersonajesDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int vida = Integer.parseInt(partes[1]);
                int ataque = Integer.parseInt(partes[2]);
                int defensa = Integer.parseInt(partes[3]);
                int alcance = Integer.parseInt(partes[4]);
                int nivel = Integer.parseInt(partes[5]);
                Personaje personaje = new Personaje(nombre, vida, ataque, defensa, alcance, nivel);
                anadirPersonaje(personaje);
            }
        } catch (IOException e) {
            System.out.println("Error al importar personajes: " + e.getMessage());
        }
    }
   }
       
