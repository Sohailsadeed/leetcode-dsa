class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubSubArrays(nums, k) - numberOfSubSubArrays(nums, k-1);
    }

    private int numberOfSubSubArrays(int[] nums, int k){
        int r = 0, l = 0, sum = 0, maxLen = 0;
        while(r < nums.length){
            sum += (nums[r] % 2);
            while(sum > k){
                sum -= (nums[l] % 2);
                l++;
            }
            maxLen += r - l + 1;
            r++;
        }
        return maxLen;
    }
}