class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(low == high)
                return nums[low];
            if(mid % 2 == 1)
                mid--;
            if(nums[mid] == nums[mid + 1])
                low = mid + 2;
            else
                high = mid;
        }
        return -1;
    }
}