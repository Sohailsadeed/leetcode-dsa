class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0, mid = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            high = Integer.max(high, piles[i]);
        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            int maxHours = checkHours(mid, piles);
            if (maxHours <= h) {
                res = Long.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) res;
    }

    private int checkHours(int mid, int[] piles) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            if (mid >= piles[i])
                count++;
            else
                count += Math.ceil((double) piles[i] / mid);
        }
        return count;
    }
}