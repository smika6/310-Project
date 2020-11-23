public class BankImpl implements Bank {

    int numberOfThreads;
    int numberOfResources;

    int minAvailable = 1;
    int maxAvailable = 10;
    int minNeed = 0;

    int[] available;

    int[] customerResource;

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

        // TEST RUN 
        requestResources(1);
        addCustomer(1);

    }

    /**
     * Add a customer
     * 
     * @param customerNum - the number of the customer
     * @param maxDemand   - the maximum demand for this customer
     */
    @Override
    public void addCustomer(int customerNum) {
        // TODO Auto-generated method stub

        // Create customer resource need
        need = new int[numberOfThreads][numberOfResources];

        for (int i = 0; i < this.numberOfResources; i++){
            
            
            int customerNeed = maximum[customerNum][i] - allocation[customerNum][i];

            // In case it a negative value, change it to positive
            customerNeed = Math.abs(customerNeed);

            need[customerNum][i] = customerNeed;

        }

        // Display customer allocation
        // CAN MOVE CODE LATER
        displayOnCommandLine("\n[DISPLAY]: Customer Allocation: \n");

        for (int j = 0; j < this.allocation.length; j++){
            for (int k = 0; k <this.allocation[j].length; k++){
                 displayOnCommandLine(this.allocation[j][k] + " ");
            }

            displayOnCommandLine("\n");

        }

        // Display customer resource need
        // CAN MOVE CODE LATER
        displayOnCommandLine("\n[DISPLAY]: Customer Resource Need: \n");

        for (int j = 0; j < this.need.length; j++){
            for (int k = 0; k <this.need[j].length; k++){
                displayOnCommandLine(this.need[j][k] + " ");
            }

            displayOnCommandLine("\n");
        
        }

        displayOnCommandLine("\n");

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
        
        // Display customer resource need
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
    public boolean requestResources(int customerNumber) {
        // TODO Auto-generated method stub

        customerResource = new int[this.numberOfResources];

        allocation = new int[numberOfThreads][numberOfResources];

        // Create customer resource request
        // ISSUE HERE: SOMETIME IT GENERATE A VALUE BETTER THAN BANK MAX.
        for (int l = 0; l < this.numberOfResources; l++) {
            int customerNeed = (int) Math.round(Math.random() * (this.maximum[customerNumber][l] - minAvailable) + minAvailable);
            customerResource[l] = customerNeed;

            // Track resource already allocation + new resource request from the same customer
            allocation[customerNumber][l] += customerResource[l]; 

        }

        // Diplay customer resource request
        // CAN MOVE THIS CODE LATER
        displayOnCommandLine("[DISPLAY]: Customer " + customerNumber + " Making A Request: \n");
   
        for (int b : this.customerResource) {
            displayOnCommandLine(b + " ");
        }

        displayOnCommandLine("\n");

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