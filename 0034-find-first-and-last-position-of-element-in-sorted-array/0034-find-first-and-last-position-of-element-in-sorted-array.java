class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = findIndex(nums, target, true);
        res[1] = findIndex(nums, target, false);
        return res;
    }
    private int findIndex(int[] nums, int target, boolean isStart){
        int low = 0, high = nums.length - 1, mid = 0;
        int res = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                res = mid;
                if(isStart)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
    }
}