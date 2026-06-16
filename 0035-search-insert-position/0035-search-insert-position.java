class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, mid = 0, high = nums.length - 1, res = -1;
        while( low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] >= target){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        if(res == -1)
        res = nums.length;
        return res;
    }
}