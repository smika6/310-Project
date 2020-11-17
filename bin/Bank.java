public interface Bank {

    /**
     * Add a customer
     * @param customerNum - the number of the customer
     * @param maxDemand  -
     */
    public void addCustomer(int customerNum, int[] maxDemand);

    public void getState();
    
    public boolean requestRecources(int customerNumber, int[] request);

    public boolean releaseRecources(int customerNumber, int[] release);
}
