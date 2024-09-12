package ejercicios.ejercicio01;

public class Principal {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan Pérez", 60000, "Recursos Humanos");
        CalculadoraPago calculadoraPago = new CalculadoraPago();

        double pagoMensual = calculadoraPago.calcularPagoMensual(empleado);
        System.out.println("El pago mensual de " + empleado.getNombre() + " es: " + pagoMensual);
    }
}

