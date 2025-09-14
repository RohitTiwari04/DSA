class Solution {

    public void rev(int[] nums , int start , int end){
        while(start < end){
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        rev(nums , 0 , n-1);

        rev(nums , 0 ,  k - 1);

        rev(nums , k , n - 1);

        
    }
}