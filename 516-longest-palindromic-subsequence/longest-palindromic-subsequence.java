class Solution {
    int lcs(String a , String b , int i , int j ,int[][] dp){
        if(i >= a.length() || j >= b.length()){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];
 
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j]= 1+lcs(a , b, i+1 , j+1 , dp);
        }else{
           return dp[i][j] = Math.max(lcs(a , b , i , j+1 , dp) , lcs(a , b , i+1 , j ,dp));
        }
    }
    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int m = s.length();

        int[][] dp = new int[1001][1001];
        for(int i =0 ; i < s.length() ; i++){
            for(int j = 0 ; j < s1.length() ; j++){
                dp[i][j] = -1;
            }
        }

        return lcs(s , s1 , 0 , 0 , dp);
    }
}