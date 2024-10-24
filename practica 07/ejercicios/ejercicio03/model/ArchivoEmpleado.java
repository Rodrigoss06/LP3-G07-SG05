package ejercicio03.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEmpleado {
    private static final String FILE_NAME = "empleados.dat";

	public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            empleados = (List<Empleado>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, iniciando con una lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
        return empleados;
    }

    public void guardarEmpleados(List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }

    public void agregarEmpleado(Empleado empleado) {
        List<Empleado> empleados = leerEmpleados();
        empleados.add(empleado);
        guardarEmpleados(empleados);
    }

    public Empleado buscarEmpleado(int numero) {
        List<Empleado> empleados = leerEmpleados();
        for (Empleado emp : empleados) {
            if (emp.getNumero() == numero) {
                return emp;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(int numero) {
        List<Empleado> empleados = leerEmpleados();
        boolean eliminado = empleados.removeIf(emp -> emp.getNumero() == numero);
        if (eliminado) {
            guardarEmpleados(empleados);
        }
        return eliminado;
    }
}
