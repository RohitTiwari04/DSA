class Solution {
    public static void swap(int[] nums , int i , int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;

    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                swap(nums , i , j);
                j++;
            }
        }
    }
}