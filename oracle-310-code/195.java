/*  w  w w  .  jav  a  2s .com*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Enter an integer: ");
    int i = GetInteger();
    System.out.println("You entered " + i);
  }

  public static int GetInteger() {
    while (true) {
      try {
        return sc.nextInt();
      } catch (InputMismatchException e) {
        sc.next();
        System.out.print("That's not " + "an integer. Try again: ");
      }
    }
  }
}
