class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int r = 0, l = 0;
        List<Integer> res = new ArrayList<>();
        int[] required = new int[26];
        int[] window = new int[26];
        for(int i = 0 ; i < p.length() ; i ++){
           required[p.charAt(i) - 'a']++;
        }
        while(r < s.length()){
            window[s.charAt(r) - 'a']++;
            while( (r - l + 1) > p.length()){
                char ch = s.charAt(l);
                window[ch - 'a']--;
                l++;
            }
            if(((r - l + 1) == p.length()) && Arrays.equals(window, required))
                res.add(l);
            r++;
        }
        return res;
    }
}