class Solution {
    public int findPeakElement(int[] arr) {
        int low = 1, high = arr.length - 2, mid = 0;
        if (arr.length == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            // if (mid > 0 && mid < arr.length - 1)
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
            if (arr[mid] > arr[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}