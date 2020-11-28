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
                    while ( !bank.runProcess(customerID, i) ){
                        wait();
                    }
                }

                int sleep = (int) Math.round(Math.random() * (5 - 1) + 1);

                sleep = sleep * 1000;

                Thread.sleep(sleep);

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

        synchronized(bank){
            bank.releaseResources(customerID);
            bank.notifyAll();
        }
        
    
    }
    
}
