class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = position[position.length - 1] - position[0], mid = 0;
        while(low < high){
            mid = low + (high - low + 1) / 2;
            int maxBalls = findBalls(position, mid);
            if(maxBalls >= m)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    private int findBalls(int[] position, int force){
        int ballCount = 1, currentBall = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - currentBall >= force){
                ballCount++;
                currentBall = position[i];
            }
        }
        return ballCount;
    }
}