class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, maxLen = 0, zCount = 0, oCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zCount++;
        }
        if(zCount == 0 || zCount == 1)
            return nums.length - 1;
        zCount = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                zCount++;
            }
            while(zCount > 1){
                if(nums[l] == 0)
                    zCount--;
                l++;
            }
            if(zCount == 0)
                maxLen = Integer.max(maxLen, r - l + 1);
            if(zCount == 1)
            {
                maxLen = Integer.max(maxLen, r - l);
            }
            r++;
        }
        return maxLen;
    }
}