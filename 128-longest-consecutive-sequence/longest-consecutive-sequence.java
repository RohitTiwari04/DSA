class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], false);
        }

        for (int ele : map.keySet()) {
            if (map.containsKey(ele - 1) == false) {
                map.put(ele, true);
            }
        }

        int maxCount = 0;

        for (int ele : map.keySet()) {
            int currCount = 1;
            if (map.get(ele) == true) {
                while (map.containsKey(ele + currCount) == true) {
                    currCount++;
                }
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}