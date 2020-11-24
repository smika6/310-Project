public interface Bank {

    /**
     * Add a customer
     * 
     * @param customerNum - the number of the customer
     */
    public void addCustomer(int customerNum);

    /**
     * Output the value of available, maximum, allocation, and need
     */
    public void getState();

    /**
     * Request resources
     * 
     * @param customerNumber - the customer requesting resources
     * @return
     */
    public boolean requestResources(int customerNumber);

    /**
     * Release resources
     * 
     * @param customerNumber - the customer releasing resources
     * @param release        - the resources being released
     */
    public void releaseRecources(int customerNumber, int[] release);

    /**
     * Check and see if processor can run
     * 
     * @param customerNumber - the customer number
     */
    public void runProcess(int customerNumber);
}
