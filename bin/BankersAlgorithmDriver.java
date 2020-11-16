import java.util.Scanner;

public class BankersAlgorithmDriver {

  public static void main(String[] args) {
    int recourceCount, threadCount;

    Scanner commandlineScanner = new Scanner(System.in);

    System.out.print("Input the number of recource types: ");
    recourceCount = commandlineScanner.nextInt();

    System.out.print("Input the number of threads: ");
    threadCount = commandlineScanner.nextInt();

    String displayInputs = String.format("%nRunning Simulation with %s recources and %s threads.", recourceCount, threadCount);
    System.out.println(displayInputs);

    
  }

}
