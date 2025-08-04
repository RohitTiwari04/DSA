class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int maxArea = 0;

        int i = 0 ;
        int j = n-1;

        while(i < j){
            int w = j-i;
            int h = Math.min(height[i] , height[j]);
            int area = w*h;

            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }

            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
    }
}