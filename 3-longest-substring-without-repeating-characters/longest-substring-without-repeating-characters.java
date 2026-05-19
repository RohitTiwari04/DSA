class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0 , j = 0 , len = 0;

        boolean[] count = new boolean[250];

        while(j  < n){
            while(count[s.charAt(j)]){
                count[s.charAt(i)] = false;
                i++;
            }
            count[s.charAt(j)] = true;
            len = Math.max(len , j-i+1);
            j++;
        }
        return len;
    }
}