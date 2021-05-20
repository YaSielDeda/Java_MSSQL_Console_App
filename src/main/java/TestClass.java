import BL.CategoryBLh;
import BL.ProductBLh;
import BL.SellerBLh;
import BL.ShopBLh;
import Entities.Category;
import Entities.Product;
import Entities.Seller;
import Entities.Shop;
import com.fasterxml.jackson.core.JsonProcessingException;
import service.SerializationWorker;

import java.sql.SQLException;

public class TestClass {
    public static void main(String[] args) {

        ShopBLh shopBLh = new ShopBLh();
        Shop shop = new Shop();
        shop.setID(0);

        ProductBLh productBLh = new ProductBLh();
        Product product = new Product("Кружка", 6, 150, 9);
        product.setID(30);

        CategoryBLh categoryBLh = new CategoryBLh();
        Category category = new Category("New category");
        category.setID(14);

        SellerBLh sellerBLh = new SellerBLh();
        Seller seller = new Seller("New seller");
        seller.setID(7);

        SerializationWorker psw = new SerializationWorker();

        // SHOP
        // ADD
//        try{
//            shopBLh.Add(new Shop("new shop by BL object"));
//        } catch (SQLException e){
//            System.out.println("SQL Error!");
//        }

        // DELETE
//        try{
//            shopBLh.Delete(shop);
//        } catch (SQLException e){
//            System.out.println("SQL Error!");
//        }

        // GET ALL
//        try{
//            for(Shop s: shopBLh.getAll())
//            {
//                try {
//                    psw.SerializeShop(s);
//                    System.out.println(psw.SerializeProduct((Shop) shopBLh.getById(s.getID())));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException e){
//            System.out.println("SQL Error!");
//        }

        // UPDATE
//        try {
//            shop.setAddress("Ordinary adress");
//            shopBLh.Update(shop);
//        }catch (SQLException e){
//            System.out.println("SQL Error!");
//        }
/**/
        // PRODUCT
        // ADD
//        try {
//            productBLh.Add(product);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        // DELETE
//        try{
//            productBLh.Delete(product);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // GET ALL
//        try{
//            for(Product p: productBLh.getAll()){
//                try {
//                    psw.SerializeProduct(p);
//                    System.out.println(psw.SerializeProduct((Product) productBLh.getById(p.ID)));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        }catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // UPDATE
//        try{
//            product.setName("Чашка");
//            productBLh.Update(product);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
/**/
        // CATEGORY
        // ADD
//        try{
//            categoryBLh.Add(category);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // DELETE
//        try{
//            categoryBLh.Delete(category);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // GET ALL
//        try{
//            for(Category c: categoryBLh.getAll()){
//                try {
//                    psw.SerializeCategory(c);
//                    System.out.println(psw.SerializeCategory((Category) categoryBLh.getById(c.getID())));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        }catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // UPDATE
//        try {
//            category.setName("Other category");
//            categoryBLh.Update(category);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }

        // SELLER
        // ADD
//        try{
//            sellerBLh.Add(seller);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // DELETE
//        try{
//            sellerBLh.Delete(seller);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // GET ALL
//        try{
//            for(Seller s: sellerBLh.getAll()){
//                try {
//                    psw.SerializeSeller(s);
//                    System.out.println(psw.SerializeSeller((Seller) sellerBLh.getById(s.ID)));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        }catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
        // UPDATE
//        try {
//            seller.setName("New seller");
//            categoryBLh.Update(category);
//        } catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
    }
}
