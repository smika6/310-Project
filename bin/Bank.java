public class Bank {

    int numberOfThreads;
    int numberOfResources;

    int minAvailable = 1;
    int maxAvailable = 10;
    int minNeed = 0;

    int[] available;

    int[] currentAvailable;

    int[] customerResource;

    int[] safeSequencedCustomers;

    int[][] maximum;
    int[][] allocation;

    int[][] need;

    public Bank(int m, int n) {
        this.numberOfResources = m;
        this.numberOfThreads = n;

        // populate available array with the max available for each resource
        available = new int[this.numberOfResources];

        currentAvailable = new int[this.numberOfResources];

        safeSequencedCustomers = new int[this.numberOfThreads];

        for (int i = 0; i < this.numberOfResources; i++) {
            int allocationOfResource = (int) Math
                    .round(Math.random() * (this.maxAvailable - minAvailable) + minAvailable);
            available[i] = allocationOfResource;
            currentAvailable[i] = allocationOfResource;
        }

        // create the max recource matrix in available
        maximum = new int[numberOfThreads][numberOfResources];

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {

                int maxs = (int) Math.round(Math.random() * (this.available[j] - minNeed) + minNeed);
                maximum[i][j] = maxs;

            }
        }

        // initialize allocation table
        allocation = new int[numberOfThreads][numberOfResources];

        // initialize customer resource need table
        need = new int[numberOfThreads][numberOfResources];

        // initialize customer resource request array
        customerResource = new int[this.numberOfResources];

        getState();

        // TEST RUN
        /*
        requestResources(0);
        calculateCustomerNeed(0);
        runProcess(0);
        */
        

    }

    /**
     * 
     * @param customerNum - the number of the customer
     */
    public void calculateCustomerNeed(int customerNum) {

        for (int i = 0; i < this.numberOfResources; i++) {
            int customerNeed = maximum[customerNum][i] - allocation[customerNum][i];

            need[customerNum][i] = customerNeed = Math.abs(customerNeed);

        }

        displayNeed();

    }

    /**
     * Request resources
     * 
     * @param customerNumber - the customer requesting resources
     * @param request        - the resources being requested
     * @return
     */
    public boolean requestResources(int customerNumber) {

        for (int i = 0; i < this.numberOfResources; i++) {
            int customerNeed = (int) Math.round(Math.random() * (this.maximum[customerNumber][i] - minNeed) + minNeed);
            customerResource[i] = customerNeed;

            // Track resource already allocation + new resource request from the same
            // customer
            allocation[customerNumber][i] += customerResource[i];

            // Make sure allocation resource doesn't exceed maximum resource
            if (allocation[customerNumber][i] > maximum[customerNumber][i])
                allocation[customerNumber][i] = maximum[customerNumber][i];

        }

        // Diplay customer resource request
        displayCustomerRequest(customerNumber);
        
        displayAllocation();

        return false;
    }

    /**
     * Release resources
     * 
     * @param customerNumber - the customer releasing resources
     * @param release        - the resources being released
     */
    public void releaseRecources(int customerNumber, int[] release) {
        // TODO Auto-generated method stub

    }

    public boolean safeProcess(int customerNumber) {
        boolean safe = false;

        // Can process run?
        for (int i = 0; i < this.numberOfResources; i++) {
            if (currentAvailable[i] >= need[customerNumber][i])
                safe = true;
            else {
                safe = false;
                break;
            }

        }

        return safe;
    }

    /**
     * Check and see if processor can run
     * 
     * @param customerNumber - the customer number
     */
    public void runProcess(int customerNumber, int cycles) {

        /*
         * Process is clear to run Display current available resource after a process
         * run
         */
        if (safeProcess(customerNumber)) {

            for (int j = 0; j < this.numberOfResources; j++) {
                currentAvailable[j] = allocation[customerNumber][j] + currentAvailable[j];

            }
            displayOnCommandLine("Customer " + customerNumber + " Request " + cycles +" Is Granted\n");
            
            displayCurrentlyAvailable();

            displayOnCommandLine("\n");

        }
    }

    private static void displayOnCommandLine(Object o) {

        System.out.print(o);

    }
    

    public void displayCustomerRequest(int customerNumber){

        displayOnCommandLine("[DISPLAY]: Customer " + customerNumber + " Is Making A Request\n");

        for (int b : this.customerResource) {
            displayOnCommandLine(b + " ");
        }

        displayOnCommandLine("\n");


    }

    public void displayAllocation() {
        // Display customer allocation
        displayOnCommandLine("\n[DISPLAY]: Bank - Allocation: \n");

        for (int j = 0; j < this.allocation.length; j++) {
            for (int k = 0; k < this.allocation[j].length; k++) {
                displayOnCommandLine(this.allocation[j][k] + " ");
            }

            displayOnCommandLine("\n");

        }
    }

    public void displayNeed() {
        // Display customer resource need
        displayOnCommandLine("\n[DISPLAY]: Bank - Need: \n");

        for (int j = 0; j < this.need.length; j++) {
            for (int k = 0; k < this.need[j].length; k++) {
                displayOnCommandLine(this.need[j][k] + " ");
            }

            displayOnCommandLine("\n");
        }

        displayOnCommandLine("\n");
    }

    public void displayMax() {

        displayOnCommandLine("\n[DISPLAY]: Bank - Max:\n");

        for (int i = 0; i < this.maximum.length; i++) {
            for (int j = 0; j < this.maximum[i].length; j++) {
                displayOnCommandLine(this.maximum[i][j] + " ");
            }
            displayOnCommandLine("\n");
        }
    }

    public void displayAvailable() {
        // Display Allocation
        displayOnCommandLine("\n[DISPLAY]: Bank - Initial Resources Available:\n");

        for (int a : this.available) {
            displayOnCommandLine(a + " ");
        }

        displayOnCommandLine("\n");
    }

    public void displayCurrentlyAvailable(){
        displayOnCommandLine("\n[DISPLAY]: Current Available Work: \n");

        for (int c : this.currentAvailable) {
            displayOnCommandLine(c + " ");
        }

        displayOnCommandLine("\n");
    }

    /**
     * Output the value of available, maximum, allocation, and need
     */
    public void getState() {

        displayAvailable();
        displayMax();
        displayAllocation();
        displayNeed();
    }
}