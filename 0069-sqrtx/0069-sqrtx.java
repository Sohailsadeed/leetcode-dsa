class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x, mid = 1;
        int res = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(mid <= x / mid){
                res = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return res;
    }
}