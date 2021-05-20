package BL;

import DAO.SellerDAOh;
import DAO.GenericDAO;
import Entities.Seller;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerBLh implements GenericBL <Seller> {

    SessionFactory factory;
    GenericDAO<Seller> sellerDAO;

    public SellerBLh() {
        factory = new Configuration().configure().buildSessionFactory();
        sellerDAO = new SellerDAOh(factory);
    }
    
    @Override
    public void Add(Seller seller) throws SQLException {
        sellerDAO.Add(seller);
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        List<Seller> sellers = new ArrayList<>();
        for (Object s: sellerDAO.getAll())
            sellers.add((Seller) s);
        return sellers;
    }

    @Override
    public Seller getById(int id) throws SQLException {
        return sellerDAO.getById(id);
    }

    @Override
    public void Update(Seller seller) throws SQLException {
        Seller updatableSeller = sellerDAO.getById(seller.getID());
        updatableSeller.setName(seller.Name);
        sellerDAO.Update(updatableSeller);
    }

    @Override
    public void Delete(Seller seller) throws SQLException {
        sellerDAO.Delete(sellerDAO.getById(seller.getID()));
    }
}
