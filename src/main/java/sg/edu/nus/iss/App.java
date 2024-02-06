package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // List<String> shoppingCartList = new ArrayList<String>();
        ArrayList<Account> accountList = new ArrayList<>(); 

        // Create directory based on args

        if (args.length > 0) {
            String dirName = args[0];
            Files.createDirectories(Paths.get(dirName));
        } else {
            Files.createDirectory(Paths.get("db"));
        }
        
        Console cons = System.console(); 
        System.out.println("Welcome to your shopping cart.");

        boolean isLogin = false;

        while (true) {
            String userInput = cons.readLine("> ");
            Scanner inputReader = new Scanner(userInput); 
            String command = inputReader.next().trim();
            String input = inputReader.nextLine();

            if (command.equals("exit")) {
                System.out.println("See you next time!");
                inputReader.close();
                break;
            } 

            if (command.equals("login")) {
                // making sure input is valid first
                if (input.split(",").length == 1) {
                    String accountName = input;

                    // check if file is present, if not make the file
                    File newFile = new File(args[0] +"/" + accountName);
                    if (!newFile.exists()) {
                        
                    }

                } else {
                    System.out.println("The user account '" + input + "' is not valid.");
                }

            }
      
            if (command.equals("list")) {
                if (shoppingCartList.size()>0) {
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    System.out.println((i+1) + ". " + shoppingCartList.get(i));
                }
                } else {
                    System.out.println("Your cart is empty.");
                }
            }

            if (command.equals("add")) {
                while (inputReader.hasNext()) {
                    String item = inputReader.next().replace(",", "");
                    if (shoppingCartList.contains(item)) {
                        System.out.printf("You have %s in your cart. \n", item);
                    } else {
                        shoppingCartList.add(item);
                        System.out.printf("Added %s in your cart. \n", item);
                    }
                };
            }

            if (command.equals("delete")) {
                int index = Integer.valueOf(inputReader.next()) - 1;
                if (index < shoppingCartList.size() && index >= 0) {
                shoppingCartList.remove(index);
                } else {
                System.out.println("The index you have listed does not exist.");
                }
            }
        }
    }
}
