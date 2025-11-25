class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int actualSum = n*(n+1)/2;

        int currSum = 0;
        for(int i = 0 ; i < n ; i++){
            currSum += nums[i];
        }

        int missingNum = actualSum - currSum;

        return missingNum;
    }
}