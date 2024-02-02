package src;

import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class shoppingcart {

  public static void main(String[] args) {

    List<String> shoppingCartList = new ArrayList<String>(); 
    Console cons = System.console(); 
    
    System.out.println("Welcome to your shopping cart.");

    while (true) {
      String userInput = cons.readLine("> ");
      Scanner inputReader = new Scanner(userInput); 
      String command = inputReader.next().trim();

      if (command.equals("exit")) {
        System.out.println("See you next time!");
        inputReader.close();
        break;
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