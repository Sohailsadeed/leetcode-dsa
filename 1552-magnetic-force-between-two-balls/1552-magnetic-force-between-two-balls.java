class Solution {
    public int maxDistance(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0], mid = 0;
        while(low <= high){
            mid = low + ( high - low ) / 2;
            if(isPossible(stalls,mid, k)){
                low = mid + 1;
            }           
            else{
                high = mid - 1;
            }
        }
        return high;
    }
     private boolean isPossible(int[] arr, int curVal, int cows){
        int cowCnt = 1;
        int curCow = arr[0];
        for(int i = 1; i < arr.length; i++){
        
        if(arr[i] - curCow >= curVal){
            cowCnt++;
            curCow = arr[i];
        }
        if(cowCnt == cows)
            return true;
        }
        return false;
    }
}