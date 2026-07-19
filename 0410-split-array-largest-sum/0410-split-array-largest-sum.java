class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0, mid = 0;
        int res = Integer.MAX_VALUE;
        for(int num : nums){
            low = Integer.max(low, num);
            high += num;
        }
        while(low <= high){
            mid = (low + high) >> 1;
            int maxSplits = findMaxSplits(nums, mid);
            if(maxSplits <= k){
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return res;
    }

    private int findMaxSplits(int[] nums, int threshold){
        int curSplit = 1, sum = 0;
        for(int num : nums){
            sum += num;
            if(sum > threshold){
                curSplit++;
                sum = num;
            }
        }
        return curSplit;
    }
}