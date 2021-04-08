import BL.CategoryBL;
import BL.ConnectionObject;
import BL.ProductBL;
import DAO.ProductDAO;
import Entities.Category;
import Entities.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PL {
    public static void main(String[] args) {
        //CategoryBL categoryBL = new CategoryBL();
        //ProductBL productBL = new ProductBL();

        //Product product = new Product(0, "Зубная паста", 6, 75, 6);
        //Category category = new Category(13, "Гигиена");

        //categoryBL.Add(category);
        //categoryBL.Delete(category);
        //categoryBL.Update(category);

        //productBL.Add(product);
        //productBL.Delete(product);
        //productBL.Update(product);

        int Switcher = 0;
        StringBuilder ExitConfirm = new StringBuilder();
        Scanner in = new Scanner(System.in);

        while(ExitConfirm.toString() != "Y" || ExitConfirm.toString() != "y"){
            Menu();
            Switcher = in.nextInt();
            switch (Switcher){
                case 0:
                    System.out.println("Are You sure You want to close program? [Y/N]");
                    ExitConfirm.append(in.next());
                    while
                    (
                            ExitConfirm.toString() != "Y"
                            || ExitConfirm.toString() != "y"
                            || ExitConfirm.toString() != "N"
                            || ExitConfirm.toString() != "n"
                    ){
                        ExitConfirm.setLength(0);
                        System.out.println("Please, type 'Y' or 'N'");
                        ExitConfirm.append(in.next());
                    }
                    ExitConfirm.setLength(0);
                    break;
                case 1:

                    break;
            }
        }
    }

    static private void Menu(){
        System.out.println("MAIN MENU" +
                "1.Operations with products\n" +
                "2.Operations with categories\n" +
                "3.Operations with shops\n" +
                "0.Close");
    }

    static private void CategoryMenu(){
        System.out.println("CATEGORIES MENU" +
                "1.Show all existing categories" +
                "2.Add new" +
                "3.Show info by id" +
                "4.Update info by id" +
                "5.Delete by name" +
                "0.Back");
    }
}
