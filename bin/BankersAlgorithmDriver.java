import java.util.Scanner;

public class BankersAlgorithmDriver {

  public static void main(String[] args) {

    int lowerRange = 1;
    int upperRange = 10;

    int recourceCount = -1;
    int threadCount = -1;

    // m and n are provided through the command line
    if (args.length >= 2) {

      boolean validInput = true;

      try { // Attempt to convert command line inputs into integers

        recourceCount = Integer.parseInt(args[0]);
        threadCount = Integer.parseInt(args[1]);

      } catch (NumberFormatException e) {
        System.out.println("[ERROR]: Command Line Parameters could not be converted to Integers.");
        validInput = false;
      }

      String recourceCountInvalidString = String.format(
          "[ERROR]: Invalid input for count of resources: %s, value must be between %s and %s.", recourceCount,
          lowerRange, upperRange);
      String threadCountInvalidString = String.format(
          "[ERROR]: Invalid input for count of threads: %s, value must be between %s and %s.", threadCount, lowerRange,
          upperRange);

      if (recourceCount < lowerRange || recourceCount > upperRange) {
        System.out.println(recourceCountInvalidString);
        validInput = false;
      }

      if (threadCount < lowerRange || threadCount > upperRange) {
        System.out.println(threadCountInvalidString);
        validInput = false;
      }

      if (!validInput) {
        System.out.println("[ERROR]: Invalid parameters provided. Exiting...");
        System.exit(0);
      }

    } else if (args.length == 0) { // user did not specify m and n through the command line

      Scanner commandlineScanner = new Scanner(System.in);

      String recourceCountRequestString = String.format("[REQUEST]: Input the number of recource types (%s-%s): ",
          lowerRange, upperRange);
      String threadCountRequestString = String.format("[REQUEST]: Input the number of threads (%s-%s): ", lowerRange,
          upperRange);

      // read in the count of resources, ensuring valid input
      while (recourceCount < lowerRange || recourceCount > upperRange) {
        System.out.print(recourceCountRequestString);
        recourceCount = commandlineScanner.nextInt();
      }

      System.out.println();

      // read in the count of threads, ensuring valid input
      while (threadCount < lowerRange || threadCount > upperRange) {
        System.out.print(threadCountRequestString);
        threadCount = commandlineScanner.nextInt();
      }

      // release recource
      commandlineScanner.close();

    } else { // not enough command line parameters provided
      System.out.println("[ERROR]: Insufficient number of command line parameters provided.");
      System.exit(0);
    }

    // alert user of inputs provided.
    String displayInputsString = String.format("%n[INFO]: Running Simulation with %s recource(s) and %s thread(s).",
        recourceCount, threadCount);
    System.out.println(displayInputsString);

    // we have valid inputs from here and can run the simulation

  }// end of main

}// end of class
