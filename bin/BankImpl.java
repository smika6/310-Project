public class BankImpl implements Bank {

    int numberOfThreads;
    int numberOfResources;

    int minAvailable = 1;
    int maxAvailable = 10;
    int[] available;

    int minNeed = 0;
    int[][] maximum;

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

        // Display Allocation
        displayOnCommandLine("\n[DISPLAY]: Allocation:\n");

        for (int a : available) {
            displayOnCommandLine(" " + a);
        }

        // create the max recource matrix in available
        maximum = new int[numberOfThreads][numberOfResources];

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {

                int maxs = (int) Math.round(Math.random() * (this.available[j] - minNeed) + minNeed);
                maximum[i][j] = maxs;

            }
        }

        // Display Banker Max
        displayOnCommandLine("\n\n[DISPLAY]: Banker Max:\n");

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {
                displayOnCommandLine(" " + maximum[i][j]);
            }
            displayOnCommandLine("\n");
        }
        displayOnCommandLine("\n");

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

    private static void displayOnCommandLine(Object o) {

        System.out.print(o);

    }
}