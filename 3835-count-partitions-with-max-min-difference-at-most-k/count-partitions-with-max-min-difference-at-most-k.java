// // class Solution {
// //     private static final int MOD = 1_000_000_007;

// //     public int countPartitions(int[] nums, int k) {
// //         int n = nums.length;
// //         long[] dp = new long[n + 1];
// //         dp[0] = 1; // base case: empty prefix

// //         Deque<Integer> minq = new ArrayDeque<>();
// //         Deque<Integer> maxq = new ArrayDeque<>();
// //         int j = 0; // left boundary of the valid segment

// //         for (int i = 0; i < n; i++) {
// //             // maintain decreasing max queue
// //             while (!maxq.isEmpty() && nums[i] > maxq.peekLast()) {
// //                 maxq.pollLast();
// //             }
// //             maxq.offerLast(nums[i]);

// //             // maintain increasing min queue
// //             while (!minq.isEmpty() && nums[i] < minq.peekLast()) {
// //                 minq.pollLast();
// //             }
// //             minq.offerLast(nums[i]);

// //             // shrink window from left until max - min <= k
// //             while (!maxq.isEmpty() && !minq.isEmpty() &&
// //                     maxq.peekFirst() - minq.peekFirst() > k) {

// //                 if (nums[j] == maxq.peekFirst()) {
// //                     maxq.pollFirst();
// //                 }
// //                 if (nums[j] == minq.peekFirst()) {
// //                     minq.pollFirst();
// //                 }
// //                 j++;
// //             }

// //             // all partitions ending at i with left boundary >= j
// //             long sum = 0;
// //             for (int t = j; t <= i; t++) {
// //                 sum += dp[t];
// //                 if (sum >= (long) MOD * 2) { // avoid overflow a bit
// //                     sum %= MOD;
// //                 }
// //             }
// //             dp[i + 1] = sum % MOD;
// //         }

// //         return (int) (dp[n] % MOD);
// //     }
// // }




// class Solution {
//     private static final int MOD = 1_000_000_007;

//     public int countPartitions(int[] nums, int k) {
//         int n = nums.length;
//         long[] dp = new long[n + 1];
//         dp[0] = 1; // base case: 1 way to partition empty prefix

//         // dp[i] = number of ways to partition nums[0..i-1]

//         for (int i = 0; i < n; i++) {
//             long waysForEndingAtI = 0;

//             int minVal = nums[i];
//             int maxVal = nums[i];

//             // Try all possible starting points j for the last segment [j..i]
//             for (int j = i; j >= 0; j--) {
//                 // update min and max for subarray nums[j..i]
//                 minVal = Math.min(minVal, nums[j]);
//                 maxVal = Math.max(maxVal, nums[j]);

//                 // Check condition: max - min <= k
//                 if (maxVal - minVal <= k) {
//                     waysForEndingAtI += dp[j];
//                     if (waysForEndingAtI >= MOD) waysForEndingAtI -= MOD;
//                 } else {
//                     // Since range can only get larger if we extend more to the left,
//                     // no need to continue further j--
//                     break;
//                 }
//             }

//             dp[i + 1] = waysForEndingAtI;
//         }

//         return (int) (dp[n] % MOD);
//     }
// }




class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 1; // empty array: 1 way (no partition)

        long[] dp = new long[n + 1];      // dp[i] = ways for prefix nums[0..i-1]
        long[] prefix = new long[n + 1];  // prefix[i] = dp[0] + ... + dp[i]

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> minq = new ArrayDeque<>(); // increasing (indices)
        Deque<Integer> maxq = new ArrayDeque<>(); // decreasing (indices)

        int j = 0; // left boundary of valid segment

        for (int r = 0; r < n; r++) {
            // maintain decreasing max queue (store indices)
            while (!maxq.isEmpty() && nums[r] > nums[maxq.peekLast()]) {
                maxq.pollLast();
            }
            maxq.offerLast(r);

            // maintain increasing min queue (store indices)
            while (!minq.isEmpty() && nums[r] < nums[minq.peekLast()]) {
                minq.pollLast();
            }
            minq.offerLast(r);

            // shrink window from the left until max - min <= k
            while (!maxq.isEmpty() && !minq.isEmpty()
                    && nums[maxq.peekFirst()] - nums[minq.peekFirst()] > k) {

                if (maxq.peekFirst() == j) maxq.pollFirst();
                if (minq.peekFirst() == j) minq.pollFirst();
                j++;
            }

            // dp[r+1] = sum of dp[t] for t = j..r
            long ways;
            if (j == 0) {
                ways = prefix[r]; // sum dp[0..r]
            } else {
                ways = (prefix[r] - prefix[j - 1] + MOD) % MOD; // sum dp[j..r]
            }

            dp[r + 1] = ways;
            prefix[r + 1] = (prefix[r] + dp[r + 1]) % MOD;
        }

        return (int) (dp[n] % MOD);
    }
}
