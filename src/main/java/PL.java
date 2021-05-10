//AdminPassword9

public class PL {
//    static Boolean cicle = true;
//
//    public static void main(String[] args) {
//        int Switcher = 0;
//        Scanner in = new Scanner(System.in);
//        Boolean exit = false;
//        Boolean loggining = false;
//
//        while(exit == false){
//            try {
//                loggining = Verification(in, loggining);
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//            Menu();
//            Switcher = in.nextInt();
//            switch (Switcher){
//                case 0:
//                    StringBuilder ExitConfirm = new StringBuilder();
//
//                    System.out.println("Are You sure You want to close program? [Y/N]");
//                    while(cicle == true){
//                        ExitConfirm.setLength(0);
//                        System.out.println("Please, type 'Y' or 'N'");
//                        ExitConfirm.append(in.next());
//                        if (ExitConfirm.toString().equalsIgnoreCase("y")){
//                            exit = true;
//                            break;
//                        }
//                        else if(ExitConfirm.toString().equalsIgnoreCase("n"))
//                            break;
//                    }
//                    ExitConfirm.setLength(0);
//                    break;
//                case 1:
//                    ProductSwitcher();
//                    break;
//                case 2:
//
//                    break;
//                default:
//                    System.out.println("You have entered invalid data");
//            }
//        }
//    }
//
//    public static Boolean Loggining(String login, String password){
//        Auth auth = new Auth();
//
//        try {
//            return auth.TryAuth(login, password);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//    private static Boolean Verification(Scanner in, Boolean loggining) throws NoSuchAlgorithmException {
//        while(loggining == false){
//            System.out.print("Login: ");
//            String login = in.next();
//            System.out.print("Password: ");
//            String password = in.next();
//
//            CryptWorker cw = new CryptWorker();
//            password = cw.Crypt(password);
//
//            loggining = Loggining(login, password);
//            if (!loggining)
//                System.out.println("Incorrect. Try again.");
//            else
//                System.out.println("Hi, " + login);
//        }
//        return loggining;
//    }
//
//    static private void ProductSwitcher(){
//        int Switcher = 0;
//        GenericBL productBL = new ProductBL();
//        Scanner in = new Scanner(System.in);
//        Boolean exit = false;
//        Product product = null;
//        StringBuilder id = null;
//
//        while(exit == false){
//            ProductMenu();
//            Switcher = in.nextInt();
//            switch (Switcher){
//                case 0:
//                    exit = true;
//                    break;
//                case 1:
//                    for (Object pr:
//                            productBL.getAll()) {
//                        System.out.println(pr.toString());
//                    }
//                    break;
//                case 2:
//                    System.out.println("To add new product, write into console information, following this format:\n" +
//                            "Name_of_product, Category_of_product, Cost, Product_amount_in_stock\n" +
//                            "[information must be split by comma and space]\n" +
//                            "Type 0 for exit\n");
//                    while (cicle == true){
//                        if(in.next().toString().equals("0")){
//                            exit = true;
//                            break;
//                        }
//                        try {
//                            String ProductString = in.nextLine();
//                            List<String> StringsList = new ArrayList<String>(Arrays.asList(ProductString.split(", ")));
//                            product = new Product(0, StringsList.get(0), Integer.valueOf(StringsList.get(1)), Integer.valueOf(StringsList.get(2)), Integer.valueOf(StringsList.get(3)));
//                            productBL.Add(product);
//                            System.out.println("New product added!");
//                            exit = true;
//                            break;
//                        }
//                        catch (Exception e){
//                            System.out.println(e.getMessage());
//                        }
//                    }
//                    break;
//                case 3:
//                    ProductSerializationWorker psw = null;
//                    System.out.print("Enter the product ID (0 to cancel): ");
//                    id = new StringBuilder(in.next());
//                    while(cicle == true){
//                        if(isDigit(id.toString())){
//                            if(id.toString().equals("0")){
//                                exit = true;
//                                break;
//                            }
//                            try{
//                                psw = new ProductSerializationWorker();
//                                System.out.println(psw.SerializeProduct((Product) productBL.getById(Integer.parseInt(id.toString()))));
//                                exit = true;
//                                break;
//                            }catch (Exception e){
//                                System.out.println(e.getMessage());
//                            }
//                        }
//                        id.setLength(0);
//                        id.append(in.next());
//                    }
//                    break;
//                case 4:
//                    System.out.print("Enter the product ID (0 to cancel):");
//                    id = new StringBuilder(in.next());
//                    while (cicle == true){
//                        if(isDigit(id.toString())){
//                            if(id.toString().equals("0")){
//                                exit = true;
//                                break;
//                            }
//                            try{
//                                System.out.print("To update the product, write into console information, following this format:\n" +
//                                        "Name_of_product, Category_of_product, Cost, Product_amount_in_stock\n" +
//                                        "[information must be split by comma and space]\n" +
//                                        "Type 0 for exit\n");
//                                String ProductString = in.nextLine();
//                                List<String> StringsList = new ArrayList<String>(Arrays.asList(ProductString.split(", ")));
//                                product = new Product(0, StringsList.get(0), Integer.valueOf(StringsList.get(1)), Integer.valueOf(StringsList.get(2)), Integer.valueOf(StringsList.get(3)));
//                                productBL.Update(product);
//                                System.out.println("The product is updated!");
//                                exit = true;
//                                break;
//                            }catch (Exception e){
//                                System.out.println(e.getMessage());
//                            }
//                        }
//                    }
//
//                    break;
//                default:
//                    System.out.println("You trying to enter wrong data");
//                    break;
//            }
//        }
//    }
//
//    private static Boolean isDigit(String str){
//        try{
//            Integer.parseInt(str);
//            return true;
//        }catch (NumberFormatException e){
//            System.out.println("Inputted value isn't a number!");
//        }
//        return false;
//    }
//
//    static private void Menu(){
//        System.out.println("MAIN MENU\n" +
//                "1.Operations with products\n" +
//                "2.Operations with categories\n" +
//                "3.Operations with shops\n" +
//                "0.Close");
//    }
//
//    static private void ProductMenu(){
//        System.out.println("PRODUCTS MENU\n" +
//                "1.Show all existing products\n" +
//                "2.Add new\n" +
//                "3.Show info by id\n" +
//                "4.Update info by id\n" +
//                "5.Delete by name\n" +
//                "0.Back");
//    }
//
//    static private void CategoryMenu(){
//        System.out.println("CATEGORIES MENU\n" +
//                "1.Show all existing categories\n" +
//                "2.Add new\n" +
//                "3.Show info by id\n" +
//                "4.Update info by id\n" +
//                "5.Delete by name\n" +
//                "0.Back");
//    }
}
