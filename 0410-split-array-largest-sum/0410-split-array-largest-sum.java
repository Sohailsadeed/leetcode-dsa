class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0, mid = 0;
        for(int num : nums){
            low = Integer.max(low, num);
            high += num;
        }
        while(low < high){
            mid = (low + high) >> 1;
            int maxSplits = findMaxSplits(nums, mid);
            if(maxSplits <= k){
                high = mid;
            }
            else
                low = mid + 1;
        }
        return low;
    }

    private int findMaxSplits(int[] nums, int threshold){
        int curSplit = 1, sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            if(sum > threshold){
                curSplit++;
                sum = nums[i];
            }
        }
        return curSplit;
    }
}