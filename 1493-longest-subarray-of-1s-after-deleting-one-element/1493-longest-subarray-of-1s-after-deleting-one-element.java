class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, maxLen = 0, zCount = 0, oCount = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                zCount++;
            }
            if(zCount > 1){
                if(nums[l] == 0)
                    zCount--;
                l++;
            }
            //now window consists of only one or zero 0's
            //if it doesn't contain any 0's one element(1) is to be deleted
            //if it contains one 0, that 0 shall be deleted. So, 
            //windowsize - 1 = (r - l + 1) - 1 =  r - l
             maxLen = Integer.max(maxLen, r - l);
            r++;
        }
        return maxLen;
    }
}