public class BankImpl implements Bank{

    int numberOfThreads;
    int numberOfRecources;

    int[] available;
    int[][] maximum;

    public Bank(int m, int n){
        this.numberOfRecources = m;
        this.numberOfThreads = n;

        //create the max recource matrix in available
        maximum = new int[numberOfRecources][numberOfThreads];
    }

    @Override
    public void addCustomer(int customerNum, int[] maxDemand) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getState() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean requestRecources(int customerNumber, int[] request) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean releaseRecources(int customerNumber, int[] release) {
        // TODO Auto-generated method stub
        return false;
    }
}


interface Bank {

    /**
     * Add a customer
     * @param customerNum - the number of the customer
     * @param maxDemand  - the maximum demand for this customer
     */
    public void addCustomer(int customerNum, int[] maxDemand);

    /**
     * Output the value of available
     */
    public void getState();
    
    /**
     * 
     * @param customerNumber
     * @param request
     * @return
     */
    public boolean requestRecources(int customerNumber, int[] request);

    /**
     * 
     * @param customerNumber
     * @param release
     * @return
     */
    public boolean releaseRecources(int customerNumber, int[] release);
}
