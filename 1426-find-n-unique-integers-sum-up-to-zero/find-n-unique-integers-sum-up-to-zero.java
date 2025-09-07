class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        int i = 0;
        int j = n-1;

        int ele = 1;

        while(i < j){
            ans[i] = ele;
            ans[j] = -ele;

            i++;
            j--;
            ele++;
            
        }
        return ans;
    }
}