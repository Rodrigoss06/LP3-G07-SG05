package model;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private int saludMaxima = 100;  // Salud máxima del jugador
    private InventarioModel inventario;  // Inventario del jugador
    private Item itemEquipado;  // Item actualmente equipado para atacar

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();  // Inicializar el inventario vacío
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public InventarioModel getInventario() {
        return inventario;
    }

    public void recibirDanio(int danio) {
        this.salud -= danio;
        if (salud < 0) salud = 0;  // Evitar salud negativa
        System.out.println(nombre + " ha recibido " + danio + " de daño. Salud restante: " + salud);
    }

    public void usarItem(Item item) {
        if (item != null) {
            if (item.getTipo().equals("Poción")) {
                curar(item.getEfecto());
            } else {
                System.out.println("No puedes usar este ítem fuera del combate.");
            }
        }
    }

    private void curar(int cantidad) {
        this.salud += cantidad;
        if (this.salud > saludMaxima) {
            this.salud = saludMaxima;  // Limitar la salud a la salud máxima
        }
        System.out.println(nombre + " ha sido curado en " + cantidad + " puntos. Salud actual: " + salud);
    }

    public void equiparItem(Item item) {
        if (item.getTipo().equals("Arma")) {
            this.itemEquipado = item;
            System.out.println(nombre + " ha equipado " + item.getNombre());
        } else {
            System.out.println(item.getNombre() + " no es un arma y no se puede equipar.");
        }
    }

    public void atacar(Enemigo enemigo) {
        if (itemEquipado != null && itemEquipado.getTipo().equals("Arma")) {
            int danio = itemEquipado.getEfecto();  // La espada tiene un daño fijo alto
            enemigo.recibirDanio(danio);
            System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con " + itemEquipado.getNombre() + " y causa " + danio + " de daño.");
        } else {
            System.out.println(nombre + " no tiene ningún arma equipada para atacar.");
        }
    }
}