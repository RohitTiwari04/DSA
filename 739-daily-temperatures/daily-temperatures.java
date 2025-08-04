class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // int n = temperatures.length;

        // int[] ans = new int[n];

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i+1 ; j < n ; j++){
        //         if(temperatures[j] > temperatures[i] ){
        //             ans[i] = j-i;
        //             break;

        //         }
        //     }
        // }
        // return ans;

        //--------------------------------------------------------------------------------


        int n = temperatures.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];

        for(int i = n-1 ; i >= 0 ; i--){

            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i]  = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}