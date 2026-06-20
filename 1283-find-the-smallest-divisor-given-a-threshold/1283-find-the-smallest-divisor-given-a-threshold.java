class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, mid = 0;
        int high = Integer.MIN_VALUE;
        for(int num: nums)
            high = Integer.max(high, num);
        while(low <= high){
            mid = low + (high - low) / 2;
            int valueCount = check(nums, threshold, mid);
            if(valueCount <= threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    private int check(int[] nums, int threshold, int mid){
        int value = 0;
        for(int num: nums){
            value += (num + mid - 1) / mid;
        }
            return value;
    }
}