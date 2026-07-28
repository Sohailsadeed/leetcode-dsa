class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int missingElements = arr[mid] - (mid + 1);
            if (missingElements < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }
}