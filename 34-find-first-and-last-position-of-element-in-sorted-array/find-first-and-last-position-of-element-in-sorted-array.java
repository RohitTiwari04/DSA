class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;

        int l = 0;
        int r = n-1;
        int first = -1;
        while(l <= r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                first = mid;
                r = mid - 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        l = 0;
        r = n-1;
        int last = -1;

        while(l <= r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                last = mid;
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid  + 1;
            }
        }

        ans[0] = first;
        ans[1] = last;

        return ans;
    }
}