class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                res = Integer.min(res, nums[mid]);
                high = mid - 1;
            } else {
                res = Integer.min(res, nums[mid]);
                low = mid + 1;
            }
        }
        return res;
    }
}