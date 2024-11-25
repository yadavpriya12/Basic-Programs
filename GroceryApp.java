
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GroceryApp {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m"; 

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        DeliveryService deliveryService = new DeliveryService();
        User loggedInUser = null;

        System.out.println("**************************************************************************");
        System.out.println();
        System.out.println(MAGENTA + "              Welcome to the Grocery Delivery App SPEEDYGROCER !              " + RESET);
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println();
        System.out.println("Groceries at Your Doorstep, Hassle-Free – Freshness Just a Click Away!");
        System.out.println(CYAN + "****  Lines Mein Mat Khade Raho, Grocery Ghar Pe Mangwao!  ****" + RESET);
        System.out.println();
        System.out.println("**************************************************************************");

        while (true) {
            if (loggedInUser == null) {
                displayMainMenu();
                int choice = getValidIntegerInput(sc, 1, 3);

                switch (choice) {
                    case 1:
                        userService.registerUser(sc);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();
                        System.out.print("Enter password: ");
                        String password = sc.nextLine();
                        loggedInUser = userService.loginUser(username, password);
                        if (loggedInUser != null) {
                            System.out.println(GREEN + "\n*** Login Successful! Welcome, " + username + "! ***" + RESET);
                            showCategories(productService);
                        } else {
                            System.out.println("***********************************************************************");
                            System.out.println(RED +"Invalid login credentials."+ RESET);
                            System.out.println("***********************************************************************");
                        }
                        break;
                    case 3:
                        System.out.println("***********************************************************************");
                        System.out.println(MAGENTA +"                     Exiting... Goodbye!                 "+ RESET);
                        System.out.println("***********************************************************************");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println(RED + "Invalid choice. Please select between 1 and 3." + RESET);
                }

                
            } else {
                displayUserMenu();
                int choice = getValidIntegerInput(sc, 1, 8);

                switch (choice) {
                    case 1:
                        System.out.print("Enter category number: ");
                        int index = getValidIntegerInput(sc, 1, Integer.MAX_VALUE);
                        List<Product> products = productService.getProductsByCategoryIndex(index);
                        if (products.isEmpty()) {
                            System.out.println(RED + "No products found for this category." + RESET);
                        } else {
                            System.out.println("     ");
                            System.out.println("---------------------------------------------------");
                            System.out.printf("| %-11s | %-35s | %-6s |%n", "Product ID", "Product Name", "Price");
                            System.out.println("---------------------------------------------------");
                            for (Product product : products) {
                                System.out.printf("| %-11d | %-35s | $%-5.2f |%n", product.getProductId(), product.getName(), product.getPrice());
                            }
                            System.out.println("---------------------------------------------------");

                            System.out.println("     ");
                            System.out.print("Enter product ID to add to cart: ");
                            int productId = getValidIntegerInput(sc, 1, Integer.MAX_VALUE);
                            System.out.print("Enter quantity: ");
                            int quantity = getValidIntegerInput(sc, 1, Integer.MAX_VALUE);
                            System.out.println("***********************************************************************");
                            cartService.addToCart(loggedInUser.getUserId(), productId, quantity);
                            System.out.println("***********************************************************************");
                        }
                        break;
                    /*case 2:
                        System.out.print("Enter product ID: ");
                        int productId = getValidIntegerInput(sc, 1, Integer.MAX_VALUE);
                        Product product = productService.getProductById(productId);
                        if (product != null) {
                            System.out.printf(GREEN + "%d - %s: $%.2f" + RESET + "%n", product.getProductId(), product.getName(), product.getPrice());
                            System.out.print("Enter quantity to add to cart: ");
                            int qty = getValidIntegerInput(sc, 1, Integer.MAX_VALUE);
                            System.out.println("***********************************************************************");
                            cartService.addToCart(loggedInUser.getUserId(), product.getProductId(), qty);
                            System.out.println("***********************************************************************");
                        } else {
                            System.out.println(RED + "Product not found." + RESET);
                        }
                        break;*/
                    case 2:
                        cartService.viewCart(loggedInUser.getUserId());
                        
                        break;
                    case 3:
                        cartService.placeOrder(loggedInUser.getUserId());
                        break;
                    case 4:
                        userService.viewOrderHistory(loggedInUser.getUserId());
                        break;
                    case 5:
                        userService.updateUserInfo(loggedInUser.getUserId(), sc);
                        break;
                    case 6:
                        loggedInUser = null;
                        System.out.println("***********************************************************************");
                        System.out.println(GREEN + "    Logged out successfully.    " + RESET);
                        System.out.println("***********************************************************************");
                        break;
                    case 7:
                        System.out.println("***********************************************************************");
                        System.out.println(MAGENTA +"                       Exiting... Goodbye!               "+ RESET);
                        System.out.println(MAGENTA +"                Visit Again for a better Experience         "+ RESET);
                        System.out.println("***********************************************************************");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println(RED + "Invalid choice. Please select between 1 and 8." + RESET);
                }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("     ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
        System.out.println("     ");
    }

    private static void displayUserMenu() {
        System.out.println("     ");
        System.out.println("1. View category by index");
       // System.out.println("2. Search Products by ID");
        System.out.println("2. View Cart");
        System.out.println("3. Place Order");
        System.out.println("4. View Order History");
        System.out.println("5. Update User Information");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
        System.out.print("Enter your choice (1-7): ");
        System.out.println("     ");
    }

    private static int getValidIntegerInput(Scanner sc, int min, int max) {
        while (true) {
            try {
                int input = sc.nextInt();
                if (input >= min && input <= max) {
                    sc.nextLine(); 
                    return input;
                } else {
                    System.out.println(RED + "Invalid input. Please enter a number between " + min + " and " + max + "." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println("***********************************************************************");
                System.out.println(RED +" Invalid input. Please enter a valid number."+ RESET);
                System.out.println("***********************************************************************");
                sc.nextLine(); 
            }
        }
    }

    private static void showCategories(ProductService productService) {
        List<String> categories = productService.getCategories();
        System.out.println("     ");
        System.out.println("---------------------------------------------------");
        System.out.printf("| %-10s | %-30s |%n", "Index", "Category");
        System.out.println("---------------------------------------------------");
        if (categories.isEmpty()) {
            System.out.println(RED + "Oops! No categories available." + RESET);
        } else {
            int index = 1;
            for (String category : categories) {
                System.out.printf("| %-10d | %-30s |%n", index, category);
                index++;
            }
            System.out.println("---------------------------------------------------");
        }
        System.out.println("     ");
    }
}
