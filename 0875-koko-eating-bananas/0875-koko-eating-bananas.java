class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1, high = piles[piles.length - 1], mid = 1;
        int res = Integer.MAX_VALUE;
        while(low <= high){
            mid = low + ( high - low) / 2;
            int temp = check(mid, piles);
            if(temp <= h){
                res = Integer.min(mid, res);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }

    private int check(int mid, int[] piles){
        int totalHours = 0;
        double temp = 0.0;
        for(int i = 0 ; i < piles.length; i++){
            temp =(double) piles[i]/mid;
            totalHours += Math.ceil(temp);
        }
        return totalHours;
    }
}