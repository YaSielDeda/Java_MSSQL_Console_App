package BL.unused;

import BL.GenericBL;
import DAO.unused.ProductDAO;
import Entities.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBL extends ProductDAO implements GenericBL<Product> {
    ProductDAO productDAO = new ProductDAO();

    @Override
    public void Add(Product product){
        try {
            productDAO.Add(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll(){
        List<Product> products = null;

        try {
            products = productDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(int id){
        Product product = null;

        try {
            product = productDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void Update(Product product){
        try {
            productDAO.Update(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(Product product){
        try {
            productDAO.Delete(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
