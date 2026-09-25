class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    private long sumMin(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                  (i == n || nums[stack.peek()] >= nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum += (long) nums[mid] * leftCount * rightCount;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return sum;
    }

    private long sumMax(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                  (i == n || nums[stack.peek()] <= nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum += (long) nums[mid] * leftCount * rightCount;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return sum;
    }
}