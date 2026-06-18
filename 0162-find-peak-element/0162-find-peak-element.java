class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        if(nums.length == 1)
            return 0;
        else if(nums[0] > nums[1])
            return 0;
        else if(nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(mid == 0 && nums[mid] > nums[mid + 1])
                return 0;
            if(mid == nums.length - 1 && nums[nums.length - 1] > nums[nums.length - 2])
                return nums.length - 1;
            if((mid > 0 && mid < nums.length - 1) && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            if((mid > 0 && mid < nums.length - 1) && nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1])
            {
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return -1;
    }
}