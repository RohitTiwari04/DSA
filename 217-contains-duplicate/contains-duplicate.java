class Solution {
    public boolean containsDuplicate(int[] nums) {
       int n = nums.length;
    // nested loop --> TLE
    //    for(int i = 0 ; i < n ; i++){
    //     for(int j = i+1 ; j< n ; j++){
    //         if(nums[i] == nums[j]){
    //             return true;
    //         }
    //     }

    //    }
    //    return false; 

    // Two pointer-->not able to make a solid logic
    // 
        // HashSet<Integer> set = new HashSet<>();

        // for(int num : nums){
        //     if(set.contains(num)){
        //         return true;
                
                
        //     }
        //     set.add(num);
        // }
        // return false;

        // with no extra space-->
        Arrays.sort(nums);

        for(int i = 1 ; i < n ; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}