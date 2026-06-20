class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, mid = 0;
        int high = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int num: nums)
            high = Integer.max(high, num);
        while(low <= high){
            mid = low + (high - low) / 2;
            int valueCount = check(nums, threshold, mid);
            if(valueCount <= threshold){
                ans = Integer.min(ans, mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private int check(int[] nums, int threshold, int mid){
        int value = 0;
        for(int num: nums){
            value += Math.ceil((double)num / mid);
        }
            return value;
    }
}