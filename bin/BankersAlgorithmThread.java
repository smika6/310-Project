public class BankersAlgorithmThread extends Thread{

    Bank bank;
    int customerNumber;
    int cycles;

    public BankersAlgorithmThread(Bank b, int customerNumber){
        this.bank = b;
        this.customerNumber = customerNumber;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++){

            try{

                synchronized(bank){
                    
                    bank.requestResources(customerNumber);
                    bank.calculateCustomerNeed(customerNumber);
                    bank.runProcess(customerNumber, i);            
                }

                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println("\nException has been caught");
            }

        }
    
    }
    
}
