public interface Bank {

    /**
     * Add a customer
     * 
     * @param customerNum - the number of the customer
     * @param maxDemand   - the maximum demand for this customer
     */
    public void addCustomer(int customerNum, int[] maxDemand);

    /**
     * Output the value of available, maximum, allocation, and need
     */
    public void getState();

    /**
     * Request resources
     * 
     * @param customerNumber - the customer requesting resources
     * @param request        - the resources being requested
     * @return
     */
    public boolean requestRecources(int customerNumber, int[] request);

    /**
     * Release resources
     * 
     * @param customerNumber - the customer releasing resources
     * @param release        - the resources being released
     */
    public void releaseRecources(int customerNumber, int[] release);
}
