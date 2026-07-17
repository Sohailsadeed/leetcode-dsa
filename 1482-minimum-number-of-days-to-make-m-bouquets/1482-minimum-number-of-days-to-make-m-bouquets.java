class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m * k)
            return -1;
        int low = 1, mid = 0, count = 0, mCount = Integer.MIN_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int day: bloomDay)
            high = Integer.max(day, high);
        while( low <= high){
            mid = low + (high - low) / 2;
            int totalBoquets = countBoquets(bloomDay, m, k, mid);
            if(totalBoquets >= m){
                ans = Integer.min(ans, mid);
                high = mid - 1;
            }
            else 
                low = mid + 1;
        }
       if(ans == Integer.MAX_VALUE)
        return -1;
    return ans;
    }
    private int countBoquets(int[] bloomDay, int m, int k, int mid){
        int count = 0;
        int totCount = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                count++;
            }
            else{
                totCount += count / k;
                count = 0;
            }
        }
        totCount += count / k;// if the last elements form a boquet
        return totCount;
    }
}