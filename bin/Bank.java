public class Bank {

    int numberOfThreads;
    int numberOfResources;

    int minAvailable = 1;
    int maxAvailable = 10;
    int minNeed = 0;
    int safeIndex = 0;

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

        // initialize allocation table
        allocation = new int[numberOfThreads][numberOfResources];

        // initialize customer resource need table
        need = new int[numberOfThreads][numberOfResources];
  
        // initialize customer resource request array
        customerResource = new int[this.numberOfResources];

        // populate available array with the max available for each resource
        available = new int[this.numberOfResources];

        // initialize current available work resource
        currentAvailable = new int[this.numberOfResources];

        // initialize safe sequence
        safeSequencedCustomers = new int[this.numberOfThreads];

        // create allocation matrix
        for (int i = 0; i < this.numberOfResources; i++) {
            int allocationOfResource = (int) Math
                    .round(Math.random() * (this.maxAvailable - minAvailable) + minAvailable);
            available[i] = allocationOfResource;
            currentAvailable[i] = allocationOfResource;
        }

        // create the max resource matrix in available
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
     * @param customerNumber - the customer requesting resources
     * @return
     */
    public boolean requestResources(int customerNumber) {

        for (int i = 0; i < this.numberOfResources; i++) {
            int customerNeed = (int) Math.round(Math.random() * (this.maximum[customerNumber][i] - minNeed) + minNeed);
            customerResource[i] = customerNeed;

            // Track resource already allocation + new resource request from the same customer
            allocation[customerNumber][i] += customerResource[i];
        }

        // Diplay customer resource request
        displayCustomerRequest(customerNumber);
        
        displayAllocation();

        return false;
    }

    /**
     * Release resource
     * @param customerNumber - the customer releasing resources
     * @param release        - the resources being released
     */
    public void releaseResources(int customerNumber, int[] release) {
        // TODO Auto-generated method stub

    }

    /**
     * process can run
     * @param customerNumber - the customer number
     * @param cycles - thread cycles
     */
    public boolean runProcess(int customerNumber, int cycles) {

        // Check and see if process is clear to run
        for (int i = 0; i < this.numberOfResources; i++) 
            if (need[customerNumber][i] > currentAvailable[i])
               return false;
           
        
        // Run process
        for (int j = 0; j < this.numberOfResources; j++) 
            currentAvailable[j] = allocation[customerNumber][j] + currentAvailable[j];

            displayOnCommandLine("Customer " + customerNumber + " Request " + cycles +" Is Granted\n");
            
            displayCurrentlyAvailable();

            displayOnCommandLine("\n");

        return true;

    }

      /**
     * safe Status
     * @param customerNumber - the customer number
     * @param cycles - thread cycles
     */
    public boolean safeStatus(int customerNumber, int cycles){

        if(runProcess(customerNumber, cycles)){

            // Process is safe and enter the safe sequence
            // ISSUE WITH CODE: 
            safeSequencedCustomers[safeIndex] = customerNumber;
            safeIndex++;
    
            displaySafeSequence(customerNumber);

            return true;

        }
        return false;
    }

    private static void displayOnCommandLine(Object o) {

        System.out.print(o);

    }
    
    public void displaySafeSequence(int customerNumber){
        
        displayOnCommandLine("[DISPLAY]: Bank - Safe Sequence\n");

        for (int a : this.safeSequencedCustomers) {
            displayOnCommandLine(a + " ");
        }

        displayOnCommandLine("\n");
    }

    // Display customer resource request
    public void displayCustomerRequest(int customerNumber){

        displayOnCommandLine("\n[DISPLAY]: Customer " + customerNumber + " Is Making A Request\n");

        for (int b : this.customerResource) {
            displayOnCommandLine(b + " ");
        }

        displayOnCommandLine("\n");


    }

    // Display customer allocation
    public void displayAllocation() {
        
        displayOnCommandLine("\n[DISPLAY]: Bank - Allocation: \n");

        for (int j = 0; j < this.allocation.length; j++) {
            for (int k = 0; k < this.allocation[j].length; k++) {
                displayOnCommandLine(this.allocation[j][k] + " ");
            }

            displayOnCommandLine("\n");

        }
    }

    // Display customer resource need
    public void displayNeed() {
        
        displayOnCommandLine("\n[DISPLAY]: Bank - Need: \n");

        for (int j = 0; j < this.need.length; j++) {
            for (int k = 0; k < this.need[j].length; k++) {
                displayOnCommandLine(this.need[j][k] + " ");
            }

            displayOnCommandLine("\n");
        }

        displayOnCommandLine("\n");
    }

    // Display bank max
    public void displayMax() {

        displayOnCommandLine("\n[DISPLAY]: Bank - Max:\n");

        for (int i = 0; i < this.maximum.length; i++) {
            for (int j = 0; j < this.maximum[i].length; j++) {
                displayOnCommandLine(this.maximum[i][j] + " ");
            }
            displayOnCommandLine("\n");
        }
    }

    // Display initial available resource
    public void displayAvailable() {
       
        displayOnCommandLine("\n[DISPLAY]: Bank - Initial Resources Available:\n");

        for (int a : this.available) {
            displayOnCommandLine(a + " ");
        }

        displayOnCommandLine("\n");
    }

    // Display current availalbe work resource
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