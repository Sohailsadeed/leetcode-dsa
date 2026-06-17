class Solution {
    public int findMin(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[low] <= nums[mid]){
                res = Integer.min(nums[low], res);
                low = mid + 1;
            }
            else if(nums[mid] <= nums[high]){
                res = Integer.min(nums[mid], res);
                high = mid - 1;
            }
        }
        return res;
    }
}