import java.util.Scanner;

public class BankersAlgorithmDriver {

  public static void main(String[] args) {
    //primitives
    int lowerRange = 1;
    int upperRange = 10;

    int recourceCount = -1;
    int threadCount = -1;

    //objects
    String recourceCountRequestString = String.format("Input the number of recource types (%s-%s): ", lowerRange, upperRange);
    String threadCountRequestString = String.format("Input the number of threads (%s-%s): ", lowerRange, upperRange);
    
    Scanner commandlineScanner = new Scanner(System.in);
    
    //read in the count of resources, ensuring valid input
    while (recourceCount < lowerRange || recourceCount > upperRange) {
      System.out.print(recourceCountRequestString);
      recourceCount = commandlineScanner.nextInt();
    }
    
    System.out.println();

    //read in the count of threads, ensuring valid input
    while (threadCount < lowerRange || threadCount > upperRange) {
      System.out.print(threadCountRequestString);
      threadCount = commandlineScanner.nextInt();
    }

    //release recource
    commandlineScanner.close();

    //alert user of inputs provided.
    String displayInputsString = String.format("%nRunning Simulation with %s recource(s) and %s thread(s).", recourceCount,
        threadCount);
    System.out.println(displayInputsString);

  }

}
