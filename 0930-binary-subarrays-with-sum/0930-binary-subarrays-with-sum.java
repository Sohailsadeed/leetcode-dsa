class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return subArrayWithAtMostSum(nums, goal) - subArrayWithAtMostSum(nums, goal-1);
    }

    public int subArrayWithAtMostSum(int[] nums, int goal){
        if(goal == -1)
        return 0;
        
        int r = 0, l = 0, sum = 0, maxLen = 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            maxLen += r - l + 1;
            r++;
        }
        return maxLen;
    }
}