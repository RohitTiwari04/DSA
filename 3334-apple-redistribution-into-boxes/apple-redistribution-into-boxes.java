class Solution {
    public int minimumBoxes(int[] apple, int[] cap) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        // Convert cap array to Integer[] for reverse sorting
        Integer[] capacity = new Integer[cap.length];
        for (int i = 0; i < cap.length; i++) {
            capacity[i] = cap[i];
        }

        // Sort in descending order
        Arrays.sort(capacity, Collections.reverseOrder());

        int res = 0;
        while (sum > 0) {
            sum -= capacity[res];
            res++;
        }

        return res;
    }
}