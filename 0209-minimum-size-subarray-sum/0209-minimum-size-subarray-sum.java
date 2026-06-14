class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, minLength = Integer.MAX_VALUE, sum = 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum >= target){
                minLength = Integer.min(minLength, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        if(minLength == Integer.MAX_VALUE)
            minLength = 0;
        return minLength;
    }
}