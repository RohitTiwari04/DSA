class Solution {
    int solve(int i , int[] nums , int[] dp){
        int n = nums.length;
        if(n <= i) return 0;

        if(dp[i] != -1) return dp[i];

        int rob = nums[i] + solve(i+2 , nums , dp);
        int skip = solve(i+1 , nums , dp);

        return dp[i]=Math.max(rob , skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp  = new int[n+1];
        Arrays.fill(dp, -1);        
        return solve(0 , nums , dp);
    }
}