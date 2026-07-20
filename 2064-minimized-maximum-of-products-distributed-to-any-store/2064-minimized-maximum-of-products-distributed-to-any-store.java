class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = Integer.MIN_VALUE, mid = 0;
        for(int quantity : quantities)
            high = Integer.max(high, quantity);
        while(low < high){
            mid = (low + high) >> 1;
            int maxStores = findStores(quantities, mid);
            if(maxStores <= n)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private int findStores(int[] quantities, int threshold){
        int storeCount = 0;
        for(int i = 0; i < quantities.length; i++){
            storeCount += (quantities[i] + threshold - 1) / threshold;
        }
        return storeCount;
    }
}