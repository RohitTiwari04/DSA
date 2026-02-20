class Solution {
    public int[] twoSum(int[] nums, int target) {
    //    int[] ans = new int[2];
    //    int n = nums.length;

    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i+1 ; j < n ; j++){
    //             if(nums[i] + nums[j] == target){
    //                 ans[0]  = i;
    //                 ans[1] = j;
    //             }
    //         }
    //     }
    //     return ans;

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i = 0 ; i < nums.length ; i++){
        int find = target - nums[i];

        if(map.containsKey(find)){
            int[] ans  = new int[2];
            ans[0] = i;
            ans[1] = map.get(find);
            return ans;
        }
        map.put(nums[i] , i);
    }
    return null;
    
    }
}