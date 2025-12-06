class Solution {
    public char getMaxOccuringChar(String s) {
        // code here
        int n = s.length();
        
        int maxFreq = -1;
        char ans = s.charAt(0);
        
        for(int i = 0 ; i < n;  i++){
            int freq = 1;
            char ch = s.charAt(i);
            for(int j = i+1 ; j < n ; j++){
                if(s.charAt(j) == ch) freq++;
            }
            if(maxFreq < freq){
                maxFreq = freq;
                ans = ch;
            }else if(maxFreq == freq){
                if(ans > ch){
                    ans = ch;
                }
            }
        }
        return ans;
    }
}