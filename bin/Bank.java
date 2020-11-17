public interface Bank {

    /**
     * Add a customer
     * 
     * @param customerNum - the number of the customer
     * @param maxDemand   - the maximum demand for this customer
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
