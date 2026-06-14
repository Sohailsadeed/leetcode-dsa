class Solution {
    public int characterReplacement(String s, int k) {
        int r = 0, l = 0, len = 0, maxLen = 0, maxFreq = 0, replacementsNeeded = 0;
        int[] hash = new int[26];
        while( r < s.length()){
            hash[s.charAt(r) - 'A']++;
            maxFreq = Integer.max(maxFreq, hash[s.charAt(r) - 'A']);
            replacementsNeeded = r - l + 1 - maxFreq;
            while(replacementsNeeded > k){
                hash[s.charAt(l) - 'A']--;
                l++;
                replacementsNeeded = r - l + 1 - maxFreq;
            }
            maxLen = Integer.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}