/**
 * The package com.scraper contains all the files for the project
 *
 * @author Toby Godfrey
 */
package com.scraper;

import java.util.Scanner;

/**
 * The Main class calls all the functions for the application to run, and it contains the *
 * main method.
 */
public class Main{

  /**
   * This is the main method. This is the entry point for the application. It starts by getting the username as a string input from the user. Then it creates a Retriever function and calls the getContent method.
   * @param args The args parameter is an array of strings of command line arguments.
   */
  public static void main(String[] args) {
    String username;
    String name = null;

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the username: ");
    username = input.nextLine();
    Retriever retriever = new Retriever();
    String line = retriever.getContent(username);
    if(line == null) {
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
