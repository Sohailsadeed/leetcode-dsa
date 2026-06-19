class Solution {
    public int mySqrt(int x) {
        long low = 1, high = x, mid = 1;
        long res = 0;
        while(low <= high)
        {
            mid = low + ( high - low) / 2;
            if(mid * mid > x){
                high = mid - 1;
            }
            else{
                res = mid;
                low = mid + 1;
            }
        }
        return (int)res;
    }
}