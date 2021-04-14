package DAO;

import service.ConnectionObject;
import Entities.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends ConnectionObject implements GenericDAO <Category> {
    Connection connection = getConnection();

    @Override
    public void Add(Category category) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Categories (Name) VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, category.Name);

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
    public List getAll() throws SQLException {
        Statement statement = null;
        String sql = "SELECT * FROM Categories";
        List<Category> categoryList = new ArrayList<>();

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Category category = new Category();

                category.setID(resultSet.getInt("ID"));
                category.setName(resultSet.getString("Name"));

                categoryList.add(category);
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

        return categoryList;
    }

    @Override
    public Category getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM Categories WHERE ID = ?";
        Category category = new Category();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                category.setID(resultSet.getInt("ID"));
                category.setName(resultSet.getString("Name"));
            }
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

        return category;
    }

    @Override
    public void Update(Category category) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Categories SET Name=? WHERE ID=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getID());

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
    public void Delete(Category category) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Categories WHERE Name = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());

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
