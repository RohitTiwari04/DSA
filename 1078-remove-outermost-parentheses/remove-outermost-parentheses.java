class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(!st.isEmpty()){
                    res += ch;
                }
                st.push(ch);
            }else{
                st.pop();
                if(!st.isEmpty()){
                    res += ch;
                }
            }
        }
        return res;
    }
}