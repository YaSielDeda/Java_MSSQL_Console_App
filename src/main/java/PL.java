//AdminPassword9

import BL.GenericBL;
import BL.ProductBLh;
import Entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import service.Auth;
import service.CryptWorker;
import service.SerializationWorker;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PL {
    static Boolean cicle = true;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int Switcher = 0;
        //Scanner in = new Scanner(System.in);
        Boolean exit = false;
        Boolean loggining = false;

        while(exit == false){
//            try {
//                loggining = Verification(in, loggining);
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }

            Menu();
            Switcher = in.nextInt();
            switch (Switcher){
                case 0:
                    StringBuilder ExitConfirm = new StringBuilder();

                    System.out.println("Are You sure You want to close program? [Y/N]");
                    while(cicle == true){
                        ExitConfirm.setLength(0);
                        System.out.println("Please, type 'Y' or 'N'");
                        ExitConfirm.append(in.next());
                        if (ExitConfirm.toString().equalsIgnoreCase("y")){
                            exit = true;
                            break;
                        }
                        else if(ExitConfirm.toString().equalsIgnoreCase("n"))
                            break;
                    }
                    ExitConfirm.setLength(0);
                    break;
                case 1:
                    ProductSwitcher();
                    break;
                case 2:

                    break;
                default:
                    System.out.println("You have entered invalid data");
            }
        }
    }

    public static Boolean Loggining(String login, String password){
        Auth auth = new Auth();

        try {
            return auth.TryAuth(login, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static Boolean Verification(Scanner in, Boolean loggining) throws NoSuchAlgorithmException {
        while(loggining == false){
            System.out.print("Login: ");
            String login = in.next();
            System.out.print("Password: ");
            String password = in.next();

            CryptWorker cw = new CryptWorker();
            password = cw.Crypt(password);

            loggining = Loggining(login, password);
            if (!loggining)
                System.out.println("Incorrect. Try again.");
            else
                System.out.println("Hi, " + login);
        }
        return loggining;
    }

    static private void ProductSwitcher(){
        int Switcher = 0;
        SerializationWorker sw = new SerializationWorker();
        ProductBLh productBLh = new ProductBLh();
        //Scanner in = new Scanner(System.in);
        Boolean exit = false;
        Product product = null;
        StringBuilder id = null;

        while(exit == false){
            ProductMenu();
            Switcher = in.nextInt();
            switch (Switcher){
                case 0:
                    exit = true;
                    break;
                case 1:
                    try{
                        for(Product p: productBLh.getAll()){
                            try {
                                sw.SerializeProduct(p);
                                System.out.println(sw.SerializeProduct((Product) productBLh.getById(p.ID)));
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            } catch (SQLException e){
                                e.printStackTrace();
                            }
                        }
                    }catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("To add new product, write into console information, following this format:\n" +
                            "Name_of_product, Category_of_product, Cost, Product_amount_in_stock\n" +
                            "[information must be split by comma and space]\n" +
                            "Type 0 for exit");
                    while (cicle == true){
                        try {
                            String ProductString = in.nextLine();

                            if(ProductString.length() == 1 && ProductString.equals("0")){
                                exit = true;
                                break;
                            }

                            List<String> StringsList = new ArrayList<String>(Arrays.asList(ProductString.split(", ")));
                            product = new Product(StringsList.get(0), Integer.valueOf(StringsList.get(1)), Double.valueOf(StringsList.get(2)), Integer.valueOf(StringsList.get(3)));
                            productBLh.Add(product);
                            System.out.println("New product added!");
                            exit = true;
                            break;
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println("On what basis to search?\n" +
                            "1. ID\n" +
                            "2. Name\n" +
                            "3. Cost\n" +
                            "0. Cancel");
                    while (cicle == true){
                        in.nextLine();
                        String option = in.next();

                        if(!isDigit(option)){
                            System.out.println("Incorrect input");
                            exit = true;
                            break;
                        }

                        in.nextLine();
                        Session session = productBLh.factory.openSession();
                        Criteria criteria = session.createCriteria(Product.class);
                        String ProductString = in.next();
                        switch(Integer.valueOf(option)){
                            case 0:
                                exit = true;
                                break;
                            case 1:
                                System.out.println("Enter the ID: ");
                                criteria.add(Restrictions.eq("ID", Integer.valueOf(ProductString.toString())));
                                break;
                            case 2:
                                System.out.println("Enter the name: ");
                                criteria.add(Restrictions.eq("Name", ProductString.toString()));
                                break;
                            case 3:
                                System.out.println("Enter the cost: ");
                                criteria.add(Restrictions.eq("Cost", Double.valueOf(ProductString.toString())));
                                break;
                            default:
                                System.out.println("The inputted option doesn't exist!");
                                break;
                        }
                        List<Product> products = criteria.list();
                        for(Product p: products){
                            try {
                                sw.SerializeProduct(p);
                                System.out.println(sw.SerializeProduct((Product) productBLh.getById(p.ID)));
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            } catch (SQLException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.print("Enter the product ID (0 to cancel): ");
                    id = new StringBuilder(in.next());
                    while(cicle == true){
                        if(isDigit(id.toString())){
                            if(id.toString().equals("0")){
                                exit = true;
                                break;
                            }
                            try{
                                sw = new SerializationWorker();
                                if(productBLh.getById(Integer.parseInt(id.toString())) != null)
                                    System.out.println(sw.SerializeProduct((Product) productBLh.getById(Integer.parseInt(id.toString()))));
                                else
                                    System.out.println("The product doesn't exist!");
                                exit = true;
                                break;
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        id.setLength(0);
                        id.append(in.next());
                    }
                    break;
                case 4:
                    System.out.print("Enter the product ID (0 to cancel): ");
                    id = new StringBuilder(in.next());
                    while (cicle == true){
//                        if(isDigit(id.toString())){
//                            if(id.toString().equals("0")){
//                                exit = true;
//                                break;
//                            }
                            try{
                                System.out.print("To update the product, write into console information, following this format:\n" +
                                        "Name_of_product, Category_of_product, Cost, Product_amount_in_stock\n" +
                                        "[information must be split by comma and space]\n" +
                                        "Type 0 for exit\n");
                                String ProductString = in.next();
                                List<String> StringsList = new ArrayList<String>(Arrays.asList(ProductString.split(", ")));
                                product = new Product(StringsList.get(0), Integer.valueOf(StringsList.get(1)), Double.valueOf(StringsList.get(2)), Integer.valueOf(StringsList.get(3)));
                                productBLh.Update(product);
                                System.out.println("The product is updated!");
                                exit = true;
                                break;
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        id.setLength(0);
                        id.append(in.next());
//                    }
                    break;
                default:
                    System.out.println("You trying to enter wrong data");
                    break;
            }
        }
    }

    private static Boolean isDigit(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Inputted value isn't a number!");
        }
        return false;
    }

    static private void Menu(){
        System.out.println("MAIN MENU\n" +
                "1.Operations with products\n" +
                "2.Operations with categories\n" +
                "3.Operations with shops\n" +
                "0.Close");
    }

    static private void ProductMenu(){
        System.out.println("PRODUCTS MENU\n" +
                "1.Show all existing products\n" +
                "2.Add new\n" +
                "3.Show info about product\n" +
                "4.Update info by id\n" +
                "5.Delete by name\n" +
                "0.Back");
    }

    static private void CategoryMenu(){
        System.out.println("CATEGORIES MENU\n" +
                "1.Show all existing categories\n" +
                "2.Add new\n" +
                "3.Show info by id\n" +
                "4.Update info by id\n" +
                "5.Delete by name\n" +
                "0.Back");
    }
}
