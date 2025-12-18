class Solution {
    public int maxSubArray(int[] nums) {
        //Brute Force O(n^2)-->
        // int n = nums.length;
        // int maxsum =Integer.MIN_VALUE;

        // for(int st = 0 ;st < n ; st++){
        //     int currsum = 0;
        //     for(int end = st ; end < n ; end++){
        //         currsum += nums[end];
        //         maxsum = Math.max(currsum , maxsum);
        //     }
        // }

        // return maxsum;

        
        //--------------------------------------------------------------------------

        //Kadane's Algo-->

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            currSum += nums[i];
            maxSum = Math.max(currSum , maxSum);

            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}