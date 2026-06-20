class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, mid = 0, high = 0;
        for(int weight: weights){
            low = Integer.max(low, weight);
            high += weight;
        }
        while(low <= high){
            mid = low + (high - low) / 2;
            int totalDays = checkCapacity(weights, mid);
            if( totalDays <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    private int checkCapacity(int[] weights, int mid){
        int load = 0;
        int totalDays = 1;
        for(int weight: weights){
            if(load + weight > mid)
            {
                totalDays++;
                load = weight;
            }
            else{
                load = load + weight;
            }
        }
        return totalDays;
    }
}