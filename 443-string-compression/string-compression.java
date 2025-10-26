class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int idx = 0;
        int i = 0;
        while(i < n){
            char ch = chars[i];

            int count = 0;

            while(i < n && chars[i] == ch){
                count++;
                i++;
            }
            if(count == 1)  chars[idx++] = ch;
            else{
                chars[idx++] = ch;
                String str = Integer.toString(count);
                for(char dig : str.toCharArray()){
                    chars[idx++] = dig;
                }
            }
        }
        return idx;
    }
}