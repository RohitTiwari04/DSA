class Solution {
    int solve(int i , int[] dp){
       

        if(i == 0 || i == 1) return 1;

        if(dp[i] != -1) return dp[i];

        int op1 = solve(i-1 , dp);
        int op2 = solve(i-2 , dp);

        return dp[i] = op1+op2;
    }
    public int climbStairs(int n) {
        int[] dp = new int[46];
        Arrays.fill(dp , -1);
        return solve(n , dp);
    }
}