class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int r = 0, l = 0;
        boolean valid = false;
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i ++){
            required.put(s1.charAt(i), required.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while(r < s2.length()){
            window.put(s2.charAt(r), window.getOrDefault(s2.charAt(r), 0) + 1);
            
            while((r - l + 1 )> s1.length())
            {
                window.put(s2.charAt(l), window.get(s2.charAt(l)) - 1);
                if(window.get(s2.charAt(l)) == 0)
                    window.remove(s2.charAt(l));
                l++;
            }
            if(window.equals(required))
                 valid = true;
            r++;
        }
        return valid;
    }
}