import BL.ConnectionObject;
import BL.ProductBL;
import DAO.ProductDAO;
import Entities.Product;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductBL productBL = new ProductBL();
        Product product = new Product(0, "Зубная паста", 6, 80, 6);

        //productBL.Add(product);
        //productBL.Delete(product);
        //productBL.Update(product);
    }
}
