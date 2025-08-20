class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;

        

        for(int i = 0 ; i < n ; i++){
            if(matrix[i][0] <= target && matrix[i][m-1] >= target){
                int low = 0;
                int high = m-1;

                while(low <= high){
                    int mid = (low + high)/2;

                    if(matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] < target){
                        low = mid + 1;

                    }else{
                        high = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}