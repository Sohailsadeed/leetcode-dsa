class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int n1 = s1.length(), n2 = s2.length();
        int[] required = new int[26];
        int[] window = new int[26];
        for(int i = 0 ; i < n1 ; i++){
           required[s1.charAt(i) - 'a']++;
           window[s2.charAt(i) - 'a']++;
        }

        if(matches(required, window))
            return true;

        while(n1 < n2){
            window[s2.charAt(n1) - 'a']++;
            window[s2.charAt(n1 - s1.length()) - 'a']--;//n1 gets increased upto n2 and n1 initially = s1.length() so it is used to traverse s1 from index 0 maintaining a constant window
            if(matches(window, required))
                return true;
            n1++;
        }
        return false;
    }

    private boolean matches(int[] required, int[] window) {
        for (int i = 0; i < 26; i++)
            if (required[i] != window[i])
                return false;
        return true;
    }
}