// class Solution {
//     public int countPartitions(int[] nums) {
//         int n = nums.length;

//         int sum = 0;
//         for (int x : nums) sum += x;

//         int leftSum = 0;
//         int result = 0;

//         for (int i = 0; i < n - 1; i++) {
//             leftSum += nums[i];
//             int rightSum = sum - leftSum;

//             if ((leftSum - rightSum) % 2 == 0) {
//                 result++;
//             }
//         }

//         return result;
//     }
// }



//Approach-2 (Using one pass - Maths)
//T.C : O(n) ( 1 Pass  )
//S.C : O(1)
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums) sum += x;

        // If total sum is even ➝ all partitions work (n-1)
        // If total sum is odd  ➝ no partitions work
        return (sum % 2 == 0) ? (n - 1) : 0;
    }
}