package BL;

import DAO.ProductDAO;
import Entities.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBL extends ProductDAO{
    ProductDAO productDAO = new ProductDAO();

    public void Add(Product product){
        try {
            productDAO.Add(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAll(){
        List<Product> products = null;

        try {
            products = productDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getByID(int id){
        Product product = null;

        try {
            product = productDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  product;
    }

    public void Update(Product product){
        try {
            productDAO.Update(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(Product product){
        try {
            productDAO.Delete(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
