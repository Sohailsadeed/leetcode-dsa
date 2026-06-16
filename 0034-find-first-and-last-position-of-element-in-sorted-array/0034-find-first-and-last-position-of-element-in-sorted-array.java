class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = startIndex(nums, target);
        res[1] = endIndex(nums, target);
        return res;
    }
    private int startIndex(int[] nums, int target){
        int low = 0, high = nums.length - 1, mid = 0;
        int res = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                res = mid;
                high = mid - 1;
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

    private int endIndex(int[] nums, int target){
        int low = 0, high = nums.length - 1, mid = 0;
        int res = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                res = mid;
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