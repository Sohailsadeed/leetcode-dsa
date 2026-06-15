class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = p.length(), n2 = s.length();
        int[] window = new int[26];
        int[] required = new int[26];
        List<Integer> res = new ArrayList<>();
        if(n1 > n2)
            return res;
        for(int i = 0;i < n1 ; i++){
            required[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if(matches(required, window))
            res.add(0);

        for(int i = n1 ; i < n2 ; i++){
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - n1) - 'a']--;
            if(matches(required, window))
                res.add(i - n1 + 1);
        }
        return res;
    }

    private boolean matches(int[] required, int[] window){
        for(int i = 0 ; i < 26 ; i ++ )
            if(required[i] != window[i])
                return false;
        return true;
    }
}