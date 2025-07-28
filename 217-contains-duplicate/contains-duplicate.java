class Solution {
    public boolean containsDuplicate(int[] nums) {

        // O(n^2) -->>
        // for(int i = 0  ; i < nums.length ; i++){
        //     for(int j = i+1  ; j < nums.length ; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //O(nlogn) -->>

        // int n = nums.length;
        // Arrays.sort(nums);

        // if(nums[0] == nums[1]) return true;
        // if(nums[n-1] == nums[n-2]) return true;

        // for(int i = 1 ; i < n-1 ; i++){
        //     if(nums[i] == nums[i+1]){
        //         return true;
        //     }
        // }
        // return false;


        //O(n) -->>

        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}