class Solution {
    public int minimumBoxes(int[] apple, int[] cap) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

    
        Integer[] capacity = new Integer[cap.length];
        for (int i = 0; i < cap.length; i++) {
            capacity[i] = cap[i];
        }

    
        Arrays.sort(capacity, Collections.reverseOrder());

        int res = 0;
        while (sum > 0) {
            sum -= capacity[res];
            res++;
        }

        return res;
    }
}