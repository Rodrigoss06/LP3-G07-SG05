package observer;

public interface Subject {
    void agregar(Observer observer);
    void eliminar(Observer observer);
    void notificar();
}

