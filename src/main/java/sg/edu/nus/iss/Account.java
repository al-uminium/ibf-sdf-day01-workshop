package sg.edu.nus.iss;

import java.util.ArrayList;

public class Account {
  private String name;
  private ArrayList<String> cartItems;

  public Account(String name) {
    this.name = name;
    this.cartItems = new ArrayList<>();
  }

  public Account(String name, ArrayList<String> cartItems) {
    this.name = name;
    this.cartItems = cartItems;
  }

  public void addCartItem(String item) {
    this.cartItems.add(item);
    System.out.println(item + " added to the cart.");
  }

  public void removeCartItem(int index) {
    this.cartItems.remove(index-1);
  }

  public ArrayList<String> getCartItems() {
    return this.cartItems;
  }

  public void printCartItems() {
    if (this.cartItems.size() == 0 ) {
      System.out.println("Your cart is empty");
    } else {
      for (int i = 0; i < this.cartItems.size(); i++) {
        System.out.println((i+1) + ". " + this.cartItems.get(i));
      }
    }
  }

  public void accountLogin() {
    if (this.cartItems.size() == 0) {
      System.out.println(this.name + ", your cart is empty.");
    } else {
      System.out.println(this.name + " your cart contains the following items:");
      this.printCartItems();
    }
  }
}

