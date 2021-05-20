package BL;

import DAO.GenericDAO;
import DAO.ShopDAOh;
import Entities.Shop;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopBLh implements GenericBL <Shop> {

    SessionFactory factory;
    GenericDAO<Shop> shopDAO;

    public ShopBLh() {
        factory = new Configuration().configure().buildSessionFactory();
        shopDAO = new ShopDAOh(factory);
    }

    @Override
    public void Add(Shop shop) throws SQLException {
        shopDAO.Add(shop);
    }

    @Override
    public List<Shop> getAll() throws SQLException {
        List<Shop> shops = new ArrayList<>();
        for (Object s: shopDAO.getAll())
            shops.add((Shop) s);
        return shops;
    }

    @Override
    public Shop getById(int id) throws SQLException {
        return shopDAO.getById(id);
    }

    @Override
    public void Update(Shop shop) throws SQLException {
        Shop updatableShop = shopDAO.getById(shop.getID());
        updatableShop.setAddress(shop.Address);
        shopDAO.Update(updatableShop);
    }

    @Override
    public void Delete(Shop shop) throws SQLException {
        shopDAO.Delete(shopDAO.getById(shop.getID()));
    }
}
