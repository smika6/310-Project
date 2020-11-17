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
        System.out.print("\n[DISPLAY]: Allocation:\n");

        for (int a : available) {
            System.out.print(" " + a);
        }

        // create the max recource matrix in available
        maximum = new int[numberOfThreads][numberOfResources];

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {

                int maxs = (int) Math.round(Math.random() * (this.available[i] - minNeed) + minNeed);
                maximum[i][j] = maxs;

            }
        }

        // Display Banker Max
        System.out.println("\n[DISPLAY]: Banker Max:");

        for (int i = 0; i < maximum.length; i++) {
            for (int j = 0; j < maximum[i].length; j++) {
                System.out.print(" " + maximum[i][j]);
            }
            System.out.println();
        }

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