class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        ArrayList<Integer> L2R = new ArrayList<>(n);
        for(int i =0 ; i < n ; i++){
            L2R.add(1);
        }

        ArrayList<Integer> R2L = new ArrayList<>(n);
        for(int i =0 ; i < n ; i++){
            R2L.add(1);
        }

        for(int i = 1 ; i < n ; i++){
            if(ratings[i] > ratings[i-1]){
                L2R.set(i , Math.max(L2R.get(i) , L2R.get(i-1) + 1));
            }
        }

        for(int i = n-2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1]){
                R2L.set(i , Math.max(R2L.get(i) , R2L.get(i+1) + 1));
            }
        }

        int ans = 0;
        for(int i =0 ; i < n ; i++){
            ans += Math.max(R2L.get(i) , L2R.get(i));
        }

        return ans;
    }
}