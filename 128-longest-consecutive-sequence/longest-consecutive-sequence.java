class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int num : nums){
            set.add(num);
        }
        int c = 0;
        int max = Integer.MIN_VALUE;

        for(int i : set){
            if(!set.contains(i-1)){
                for(int j = i ; j < Math.pow(10,9) ; j++){
                    if(set.contains(j)){
                        c++;
                    }else{
                        break;
                    }
                }
                max = Math.max(max , c);
                c= 0;
            }
        }
        return max<1?1:max;
    }
}