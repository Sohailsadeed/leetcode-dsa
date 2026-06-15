class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int r = 0, l = 0, maxLen = 0;
        int tCount= 0, fCount = 0, count = 0;
        while(r < answerKey.length()){
            if(answerKey.charAt(r) == 'F'){
                fCount++;
            }
            else{
                tCount++;
            }
            while((r - l + 1 - Integer.max(fCount, tCount)) > k){
                if(answerKey.charAt(l) == 'T')
                    tCount--;
                else
                    fCount--;
                l++;
            }
            maxLen = Integer.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}