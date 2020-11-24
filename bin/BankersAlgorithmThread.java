public class BankersAlgorithmThread extends Thread{

    Bank bank;
    int customerNumber;

    public BankersAlgorithmThread(Bank b, int customerNumber){
        this.bank = b;
        this.customerNumber = customerNumber;
    }

    @Override
    public void run() {
        System.out.println("Hello from a thread " + customerNumber +"!");

    }
    
}
