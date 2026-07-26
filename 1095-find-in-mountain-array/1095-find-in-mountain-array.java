/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArray) {
        int low = 0, high = mountainArray.length() - 2, mid = 0;
        while(low < high){
            mid = low + ( high - low ) / 2;
            if(mountainArray.get(mid) < mountainArray.get(mid + 1))
                low = mid + 1;
            else
                high = mid;
        }
        int peak = low;

        int res = binarySearch(mountainArray, target, 0, peak, true);
        if(res != -1)
            return res;
        return binarySearch(mountainArray, target, peak, mountainArray.length() - 1, false);
    }

    private int binarySearch(MountainArray mountainArray, int target, int low, int high, boolean asc){
        while(low <= high){
            int mid = low + (high - low) / 2;
            int midElement = mountainArray.get(mid);
            if(midElement == target)
                return mid;
            else if(midElement < target)
                if(asc)
                    low = mid + 1;
                else
                    high = mid - 1;
            else
                if(asc)
                    high = mid - 1;
                else   
                    low = mid + 1;
        }
        return -1;
    }
}