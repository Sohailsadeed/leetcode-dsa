class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int maxRemoval = 0;
        int low = 0, high = removable.length;
        while (low < high) {
            int mid = (low + high + 1 ) >> 1;
            boolean check = isRemovable(s, p, removable, mid);
            if (check)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    private boolean isRemovable(String s, String p, int[] removable, int threshold) {
        boolean[] isRemoved = new boolean[s.length()];
        for (int i = 0; i < threshold; i++)
            isRemoved[removable[i]] = true;
        int n = 0;
        int m = 0;
        while (n < s.length() && m < p.length()) {
            if(isRemoved[n]) {
                n++;
                continue;
            }
            else if(s.charAt(n) == p.charAt(m)) {
                n++;
                m++;
            } 
            else
                n++;
        }
        if (m == p.length())
            return true;
        return false;
    }
}