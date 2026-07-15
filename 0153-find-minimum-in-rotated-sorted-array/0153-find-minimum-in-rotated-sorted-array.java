class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            mid = low + (high - low) / 2;
            //since the search space is already sorted
            //then nums[low] will always be the answer
            if(nums[low] <= nums[high])
                {
                    res = Integer.min(res, nums[low]);
                    break;
                }
            if (nums[mid] < nums[high]) {
                res = Integer.min(res, nums[mid]);
                high = mid - 1;
            } else {
                res = Integer.min(res, nums[low]);
                low = mid + 1;
            }
        }
        return res;
    }
}