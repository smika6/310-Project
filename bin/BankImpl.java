public class BankImpl implements Bank {

    int numberOfThreads;
    int numberOfResources;

    int minAvailable = 1;
    int maxAvailable = 10;
    int minNeed = 0;

    int[] available;

    int[][] maximum;
    int[][] allocation;
    
    int[][] need;

    public BankImpl(int m, int n) {
        this.numberOfResources = m;
        this.numberOfThreads = n;

        // populate available array with the max available for each recource
        available = new int[this.numberOfResources];

        for (int i = 0; i < this.numberOfResources; i++) {
            int allocationOfResource = (int) Math
                    .round(Math.random() * (this.maxAvailable - minAvailable) + minAvailable);
            available[i] = allocationOfResource;
        }

        // create the max recource matrix in available
        maximum = new int[numberOfThreads][numberOfResources];

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {

                int maxs = (int) Math.round(Math.random() * (this.available[j] - minNeed) + minNeed);
                maximum[i][j] = maxs;

            }
        }

        getState();

    }

    /**
     * Add a customer
     * 
     * @param customerNum - the number of the customer
     * @param maxDemand   - the maximum demand for this customer
     */
    @Override
    public void addCustomer(int customerNum, int[] maxDemand) {
        // TODO Auto-generated method stub

    }

    /**
     * Output the value of available, maximum, allocation, and need
     */
    @Override
    public void getState() {

        // Display Allocation
        displayOnCommandLine("\n[DISPLAY]: Bank - Initial Resources Available:\n");

        for (int a : this.available) {
            displayOnCommandLine(a + " ");
        }
        
        // Display Banker Max
        displayOnCommandLine("\n\n[DISPLAY]: Bank - Max:\n");

        for (int i = 0; i < this.maximum.length; i++) {
            for (int j = 0; j < this.maximum[i].length; j++) {
                displayOnCommandLine(this.maximum[i][j] + " ");
            }
            displayOnCommandLine("\n");
        }
        displayOnCommandLine("\n");

    }

    /**
     * Request resources
     * 
     * @param customerNumber - the customer requesting resources
     * @param request        - the resources being requested
     * @return
     */
    @Override
    public boolean requestRecources(int customerNumber, int[] request) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Release resources
     * 
     * @param customerNumber - the customer releasing resources
     * @param release        - the resources being released
     */
    @Override
    public void releaseRecources(int customerNumber, int[] release) {
        // TODO Auto-generated method stub
    }

    private static void displayOnCommandLine(Object o) {

        System.out.print(o);

    }
}