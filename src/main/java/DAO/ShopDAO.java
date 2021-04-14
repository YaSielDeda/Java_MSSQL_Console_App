package DAO;

import service.ConnectionObject;
import Entities.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO extends ConnectionObject implements GenericDAO <Shop> {
    Connection connection = getConnection();

    @Override
    public void Add(Shop shop) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Shops (Addr) VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, shop.Address);

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
        String sql = "SELECT * FROM Shops";
        List<Shop> shopList = new ArrayList<>();

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Shop shop = new Shop();

                shop.setID(resultSet.getInt("ID"));
                shop.setAddress(resultSet.getString("Addr"));

                shopList.add(shop);
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

        return shopList;
    }

    @Override
    public Shop getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM Shops WHERE ID = ?";
        Shop shop = new Shop();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                shop.setID(resultSet.getInt("ID"));
                shop.setAddress(resultSet.getString("Addr"));
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

        return shop;
    }

    @Override
    public void Update(Shop shop) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Shops SET Addr=? WHERE ID=?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shop.getAddress());
            preparedStatement.setInt(2, shop.getID());

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
    public void Delete(Shop shop) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Shops WHERE ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shop.getID());

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
