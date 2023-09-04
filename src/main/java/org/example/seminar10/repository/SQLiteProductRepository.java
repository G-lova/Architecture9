package org.example.seminar10.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteProductRepository implements ProductRepository {
    private Connection connection;

    public SQLiteProductRepository(String connectionString) {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS products " +
                    "(id INTEGER PRIMARY KEY, name TEXT, unit TEXT, energy DOUBLE)";
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Product getById(int id) {
        Product product = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                int energy = resultSet.getInt("energy");
                product = new Product(productId, name, unit, energy);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                int energy = resultSet.getInt("energy");
                Product product = new Product(id, name, unit, energy);
                products.add(product);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void add(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products (name, unit, energy) VALUES (?, ?, ?)");
            statement.setString(1, product.getName());
            statement.setString(2, product.getUnit());
            statement.setInt(2, product.getEnergy());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, unit = ?, energy = ? WHERE id = ?");
            statement.setString(1, product.getName());
            statement.setString(2, product.getUnit());
            statement.setInt(2, product.getEnergy());
            statement.setInt(3, product.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
