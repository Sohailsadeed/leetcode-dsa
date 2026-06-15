class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int r = 0, l = 0, requiredSize = 0, formed = 0;
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> required = new HashMap<>();
        for(int i = 0 ; i < p.length() ; i ++){
            required.put(p.charAt(i), required.getOrDefault(p.charAt(i), 0) + 1);
        }
        while(r < s.length()){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            while( (r - l + 1) > p.length()){
                char ch = s.charAt(l);
                window.put(ch, window.get(ch) - 1);
                if(window.get(ch) == 0)
                    window.remove(ch);
                l++;
            }
            if(((r - l + 1) == p.length()) && window.equals(required))
                res.add(l);
            r++;
        }
        return res;
    }
}