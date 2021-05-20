package BL;

import DAO.GenericDAO;
import DAO.ProductDAOh;
import Entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBLh implements GenericBL <Product> {

    public SessionFactory factory;
    GenericDAO<Product> productDAO;

    public ProductBLh() {
        factory = new Configuration().configure().buildSessionFactory();
        productDAO = new ProductDAOh(factory);
    }

    @Override
    public void Add(Product product) throws SQLException {
        productDAO.Add(product);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        for (Object p: productDAO.getAll())
            products.add((Product) p);
        return products;
    }

    @Override
    public Product getById(int id) throws SQLException {
        return productDAO.getById(id);
    }

    @Override
    public void Update(Product product) throws SQLException {
        Product updatableProduct = productDAO.getById(product.getID());
        updatableProduct.setName(product.Name);
        updatableProduct.setCategoryID(product.CategoryID);
        updatableProduct.setInStock(product.InStock);
        updatableProduct.setCost(product.Cost);
        productDAO.Update(updatableProduct);
    }

    @Override
    public void Delete(Product product) throws SQLException {
        productDAO.Delete(productDAO.getById(product.getID()));
    }
}
