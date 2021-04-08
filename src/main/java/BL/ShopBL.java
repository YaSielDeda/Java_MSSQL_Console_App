package BL;

import DAO.ShopDAO;
import Entities.Product;
import Entities.Shop;

import java.sql.SQLException;
import java.util.List;

public class ShopBL extends ShopDAO implements GenericBL <Shop> {
    ShopDAO shopDAO = new ShopDAO();

    @Override
    public void Add(Shop shop){
        try {
            shopDAO.Add(shop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Shop> getAll(){
        List<Shop> shops = null;

        try {
            shops = shopDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    @Override
    public Shop getById(int id){
        Shop shop = null;

        try {
            shop = shopDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }

    @Override
    public void Update(Shop shop){
        try {
            shopDAO.Update(shop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(Shop shop){
        try {
            shopDAO.Delete(shop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
