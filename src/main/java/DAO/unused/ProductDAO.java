package DAO.unused;

import DAO.GenericDAO;
import service.ConnectionObject;
import Entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends ConnectionObject implements GenericDAO<Product> {
    private Connection connection = getConnection();

    @Override
    public void Add(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Products (Name, CategoryID, Cost, InStock) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.Name);
            preparedStatement.setInt(2, product.CategoryID);
            preparedStatement.setDouble(3, product.Cost);
            preparedStatement.setInt(4, product.InStock);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                closeConnection();
            }
        }
    }

    @Override
    public List<Product> getAll() throws SQLException {
        Statement statement = null;
        String sql = "SELECT * FROM Products";
        List<Product> productList = new ArrayList<>();

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Product product = new Product();

                product.setID(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCategoryID(resultSet.getInt("CategoryID"));
                product.setCost(resultSet.getInt("Cost"));
                product.setInStock(resultSet.getInt("InStock"));

                productList.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                closeConnection();
            }
        }

        return productList;
    }

    @Override
    public Product getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM Products WHERE ID = ?";
        Product product = new Product();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                product.setID(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setCategoryID(resultSet.getInt("CategoryID"));
                product.setCost(resultSet.getInt("Cost"));
                product.setInStock(resultSet.getInt("InStock"));
            }
        } catch (SQLException e){
            throw new SQLException("The product with this id doesn't exist!");
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                closeConnection();
            }
        }

        return product;
    }

    @Override
    public void Update(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Products SET Name=?, CategoryID=?, Cost=?, InStock=? WHERE Name=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryID());
            preparedStatement.setDouble(3, product.getCost());
            preparedStatement.setInt(4, product.getInStock());
            preparedStatement.setString(5, product.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                closeConnection();
            }
        }
    }

    @Override
    public void Delete(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Products WHERE Name = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                closeConnection();
            }
        }
    }
}
