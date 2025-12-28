// class Solution {
//     public int countNegatives(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int count = 0;

//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j  < m ; j++){
//                 if(grid[i][j] < 0){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }
//------------------------------------------------------------------------------------------

// Approach-2: Binary Search (Upper Bound)

// Time: O(m * log n)
// Space: O(1)


// class Solution {
//     public int countNegatives(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int result = 0;

//         for (int i = 0; i < m; i++) {
//             int idx = upperBound(grid[i], 0);
//             result += (n - idx);
//         }

//         return result;
//     }

//     // finds first index where element < target (upper_bound for descending array)
//     private int upperBound(int[] arr, int target) {
//         int low = 0, high = arr.length;

//         while (low < high) {
//             int mid = low + (high - low) / 2;
//             if (arr[mid] < target) {
//                 high = mid;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return low;
//     }
// }

//-------------------------------------------------------------------------------------------
// Using Sorted Property (Most Optimal)

// Time: O(m + n)
// Space: O(1)

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int col = 0;
        int result = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                result += (n - col);
                row--;
            } else {
                col++;
            }
        }

        return result;
    }
}
