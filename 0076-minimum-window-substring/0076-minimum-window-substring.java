class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, maxLen = 0, start = 0;
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for( int i = 0; i < t.length(); i++){
            required.put(t.charAt(i), required.getOrDefault(t.charAt(i), 0) + 1);
            }

        int requiredCount = required.size(), formed = 0, minLength = Integer.MAX_VALUE;

        while(r < s.length()){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            char ch = s.charAt(r);
            if (required.containsKey(ch) &&
                 window.get(ch).equals(required.get(ch))) {
                formed++;
            }

            while(formed == requiredCount){
                if((r - l + 1) < minLength){
                minLength = r - l + 1;
                start = l;
                }
                char temp = s.charAt(l);
                window.put(temp, window.get(temp) - 1);
                if(required.containsKey(temp) && window.getOrDefault(temp, 0) < required.get(temp))
                    formed--;
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE
       ? ""
       : s.substring(start, start + minLength);
    }
}