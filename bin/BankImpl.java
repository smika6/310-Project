public class BankImpl implements Bank {

    int numberOfThreads;
    int numberOfRecources;

    
    int minAvailable = 1;
    int maxAvailable = 10;
    int[] available;

    int[][] maximum;

    public BankImpl(int m, int n) {
        this.numberOfRecources = m;
        this.numberOfThreads = n;

        //populate available array with the max available for each recource
        available = new int[this.numberOfRecources];

        for(int i = 0; i < this.numberOfRecources; i++){
            int allocationOfResource = (int) Math.round(Math.random() * (this.maxAvailable - minAvailable) + minAvailable);
            available[i] = allocationOfResource;
        }

        for(int a:available){
            System.out.print(" " + a);
        }

        // create the max recource matrix in available
        maximum = new int[numberOfRecources][numberOfThreads];
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