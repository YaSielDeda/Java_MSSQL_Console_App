import BL.CategoryBL;
import BL.ConnectionObject;
import BL.GenericBL;
import BL.ProductBL;
import DAO.ProductDAO;
import Entities.Category;
import Entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PL {
    static Boolean cicle = true;

    public static void main(String[] args) {
        int Switcher = 0;
        Scanner in = new Scanner(System.in);
        Boolean exit = false;

        while(exit == false){
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

    static private void ProductSwitcher(){
        int Switcher = 0;
        GenericBL productBL = new ProductBL();
        Scanner in = new Scanner(System.in);
        Boolean exit = false;

        while(exit == false){
            ProductMenu();
            Switcher = in.nextInt();
            switch (Switcher){
                case 0:
                    exit = true;
                    break;
                case 1:
                    for (Object pr:
                            productBL.getAll()) {
                        System.out.println(pr.toString());
                    }
                    break;
                case 2:
                    Product product = null;
                    System.out.println("To add new product write into console information following this format:\n" +
                            "Name_of_product, Category_of_product, Cost, Product_amount_in_stock\n" +
                            "[information must be split by comma and space]\n" +
                            "Type 0 for exit\n");
                    while (cicle == true){
                        if(in.next().toString().equals("0")){
                            exit = true;
                            break;
                        }
                        try {
                            String ProductString = in.nextLine();
                            List<String> StringsList = new ArrayList<String>(Arrays.asList(ProductString.split(", ")));
                            product = new Product(0, StringsList.get(0), Integer.valueOf(StringsList.get(1)), Integer.valueOf(StringsList.get(2)), Integer.valueOf(StringsList.get(3)));
                            productBL.Add(product);
                            System.out.println("New product added!");
                            exit = true;
                            break;
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
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
                "3.Show info by id\n" +
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
