class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = n * m - 1, mid = 0;
        while(low <= high){
            mid = low + (high - low ) / 2;
            int row = mid / mat[0].length;
            int col = mid % mat[0].length;
            if(mat[row][col] == x)
                return true;
            else if(mat[row][col] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}