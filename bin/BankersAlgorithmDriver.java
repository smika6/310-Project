import java.util.Scanner;

public class BankersAlgorithmDriver {

  public static void main(String[] args) {

    int lowerRange = 1;
    int upperRange = 10;

    int countOfResources = -1;
    int countOfThreads = -1;

    // m and n are provided through the command line
    if (args.length >= 2) {

      boolean validInput = true;

      try { // Attempt to convert command line inputs into integers

        countOfResources = Integer.parseInt(args[0]);
        countOfThreads = Integer.parseInt(args[1]);

      } catch (NumberFormatException e) {
        displayOnCommandLine("[ERROR]: Command Line Parameters could not be converted to Integers.\n");
        validInput = false;
      }

      String resourceCountInvalidString = String.format(
          "[ERROR]: Invalid input for count of resources: %s, value must be between %s and %s.%n", countOfResources,
          lowerRange, upperRange);
      String threadCountInvalidString = String.format(
          "[ERROR]: Invalid input for count of threads: %s, value must be between %s and %s.%n", countOfThreads,
          lowerRange, upperRange);

      if (countOfResources < lowerRange || countOfResources > upperRange) {
        displayOnCommandLine(resourceCountInvalidString);
        validInput = false;
      }

      if (countOfThreads < lowerRange || countOfThreads > upperRange) {
        displayOnCommandLine(threadCountInvalidString);
        validInput = false;
      }

      if (!validInput) {
        displayOnCommandLine("[ERROR]: Invalid parameters provided. Exiting...\n");
        System.exit(0);
      }

    } else if (args.length == 0) { // user did not specify m and n through the command line

      Scanner commandlineScanner = new Scanner(System.in);

      String resourceCountRequestString = String.format("[REQUEST]: Input the number of resource types (%s-%s): ",
          lowerRange, upperRange);
      String threadCountRequestString = String.format("[REQUEST]: Input the number of threads (%s-%s): ", lowerRange,
          upperRange);

      // read in the count of resources, ensuring valid input
      while (countOfResources < lowerRange || countOfResources > upperRange) {
        displayOnCommandLine(resourceCountRequestString);
        countOfResources = commandlineScanner.nextInt();
      }

      displayOnCommandLine("\n");

      // read in the count of threads, ensuring valid input
      while (countOfThreads < lowerRange || countOfThreads > upperRange) {
        displayOnCommandLine(threadCountRequestString);
        countOfThreads = commandlineScanner.nextInt();
      }

      // release resource
      commandlineScanner.close();

    } else { // not enough command line parameters provided
      displayOnCommandLine("[ERROR]: Insufficient number of command line parameters provided.\n");
      System.exit(0);
    }

    // we have valid inputs from here and can run the simulation
    runBankersAlgorithm(countOfResources, countOfThreads); // temp name cuz im getting hungry

  }// end of main

  private static void displayOnCommandLine(Object o) {

    System.out.print(o);

  }

  private static void runBankersAlgorithm(int resourceCount, int threadCount) {

    // alert user of inputs provided.
    String displayInputsString = String.format("%n[INFO]: Running Simulation with %s resource(s) and %s thread(s).%n",
        resourceCount, threadCount);
    displayOnCommandLine(displayInputsString);

    // we can start the project

    Bank bank = new Bank(resourceCount, threadCount);

    BankersAlgorithmThread[] customers = new BankersAlgorithmThread[threadCount];

    for (int p = 0; p < customers.length; p++) {
      customers[p] = new BankersAlgorithmThread(bank, p);
    }

    for (BankersAlgorithmThread p : customers) {
      p.start();
    }

    //do nothing and wait until all bank threads are done
    boolean running = true;

    while(running){
      running = false;

      for (BankersAlgorithmThread p : customers) {
        if(p.isAlive()){
          running = true;
          break;
        }
      }
    }

    //show the bank that its done
    bank.displayAvailable();

  }

}// end of class
