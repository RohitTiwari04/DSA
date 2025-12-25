class Solution {
    public long maximumHappinessSum(int[] christmasJoy, int gifts) {
        // Sort in descending order
        Arrays.sort(christmasJoy);
        
        long totalJoy = 0;
        int n = christmasJoy.length;
        
        for (int turn = 0; turn < gifts && turn < n; turn++) {
            int currentJoy = christmasJoy[n - 1 - turn] - turn;
            if (currentJoy <= 0) {
                break;
            }
            totalJoy += currentJoy;
        }
        
        return totalJoy;
    }
}
