package services;

import database.DatabaseConnection;
import models.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private static final String SECRET_KEY = "1234";
    private final Connection connection;

    public ItemService() {
        this.connection = DatabaseConnection.getConnection();
        if (this.connection != null) {
            System.out.println("Conexión compartida establecida para ItemService.");
            createTable();
        }
    }

    public void createTable() {
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS items (id INTEGER PRIMARY KEY, name TEXT, description TEXT, price REAL);");
                System.out.println("Creación de tabla exitosa.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void insertItem(Item item, String userKey) {
        if (!SECRET_KEY.equals(userKey)) {
            System.out.println("Clave incorrecta, operación cancelada.");
            return;
        }
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO items (name, description, price) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, item.getName());
                stmt.setString(2, item.getDescription());
                stmt.setDouble(3, item.getPrice());
                stmt.executeUpdate();
                connection.commit();
                System.out.println("Item agregado exitosamente.");
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Error al agregar el item, operación revertida.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM items";
            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDouble("price")
                    );
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los items: " + e.getMessage());
        }
        return items;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
