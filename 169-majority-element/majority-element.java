class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int count = 1;
        int majority = nums[0];

        for(int i = 1 ; i < n ; i++){
            if(count == 0){
                majority = nums[i];
                count = 1;
            }else if(nums[i] == majority){
                count++;
            }else{
                count--;
            }
        }

        return majority;
    }
}