package ejercicios.ejercicio01;

public class CalculadoraPago {
    public double calcularPagoMensual(Empleado empleado) {
        return empleado.getSalario() / 12;
    }
}

