class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0], mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            int maxPairs = findPairs(nums, mid);
            if (maxPairs >= p)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private int findPairs(int[] nums, int value) {
        int gap = 0;
        int pairCount = 0;
        for (int i = 1; i < nums.length;) {
            gap = nums[i] - nums[i - 1];
            if (gap <= value) {
                pairCount++;
                i += 2;
            } else
                i++;
        }
        return pairCount;
    }
}