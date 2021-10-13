/**
 * The package com.scraper contains all the files for the project
 *
 * @author Toby Godfrey
 */
package com.scraper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main is the class which calls all the functions for the application to run, and it contains the *
 * main method.
 */
public class Main {

  public static void main(String[] args) {
    String username;
    String name = new String();
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the username: ");
    username = input.nextLine();
    Retriever retriever = new Retriever();
    String line = retriever.getContent(username);
    if (line == null) {
      System.out.println("Invalid URL");
      return;
    } else {
      name = retriever.getName(line);
      if (name != null) System.out.println(name);
      else System.out.println("Invalid Username");
      return;
    }
  }
}
