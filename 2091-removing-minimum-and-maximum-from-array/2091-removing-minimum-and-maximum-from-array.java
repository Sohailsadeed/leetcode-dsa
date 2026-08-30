class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 1)
            return 1;
        int maxEle = Integer.MIN_VALUE, minEle = Integer.MAX_VALUE;
        int minIndex = -1, maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxEle) {
                maxEle = nums[i];
                maxIndex = i;
            }
            if (nums[i] < minEle) {
                minEle = nums[i];
                minIndex = i;
            }
        }
        int a = Math.min(minIndex, maxIndex);
        int b = Math.max(minIndex, maxIndex);

        int bothFront = b + 1;
        int bothBack = nums.length - a;
        int oneEach = (a + 1) + (nums.length - b);

        return Math.min(bothFront, Math.min(bothBack, oneEach));
    }
}