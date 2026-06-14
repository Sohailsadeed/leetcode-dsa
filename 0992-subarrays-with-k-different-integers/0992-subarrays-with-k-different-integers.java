class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrayWithDistinct(nums, k) - subArrayWithDistinct(nums, k - 1);
    }

    private int subArrayWithDistinct(int[] nums, int k){
        if(k < 0)
            return 0;
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            maxLen +=  r - l + 1;
            r++;
        }
        return maxLen;
    }
}