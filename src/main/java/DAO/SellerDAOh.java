package DAO;

import Entities.Product;
import Entities.Seller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAOh implements GenericDAO <Seller> {

    private final SessionFactory factory;

    public SellerDAOh(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void Add(Seller seller) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            int id = (Integer) session.createSQLQuery("SELECT MAX(ID) FROM Sellers").uniqueResult();
            seller.setID(id + 1);
            session.save(seller);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        try(final Session session = factory.openSession()){
            return session.createCriteria(Seller.class).list();
        }catch (Exception e){
            return new ArrayList();
        }
    }

    @Override
    public Seller getById(int id) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            Seller seller = session.get(Seller.class, id);
            session.getTransaction().commit();
            return seller;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void Update(Seller seller) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.update(seller);
            session.getTransaction().commit();
        }
    }

    @Override
    public void Delete(Seller seller) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(seller);
            session.getTransaction().commit();
        }
    }
}
