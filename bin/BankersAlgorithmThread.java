public class BankersAlgorithmThread extends Thread{

    Bank bank;
    int customerID;
    int cycles;

    public BankersAlgorithmThread(Bank b, int customerID){
        this.bank = b;
        this.customerID = customerID;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++){

            try{

                synchronized(bank){
                    
                    bank.requestResources(customerID);
                    bank.calculateCustomerNeed(customerID);
                    bank.runProcess(customerID, i);            
                }

                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println("\nException has been caught");
            }

        }
    
    }
    
}
