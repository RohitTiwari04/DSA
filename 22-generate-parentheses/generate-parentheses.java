class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        int close = n;
        int open = n;
        String op = "";

        solve(open , close , op , s);
        return s;
    }

    void solve(int open , int close , String op , List<String>s){
        if(open == 0 && close == 0){
            s.add(op);
            return;
        }

        if (open > 0) {
            solve(open - 1, close, op + "(", s);
        }

        // Add ')'
        if (close > open) {
            solve(open, close - 1, op + ")", s);
        }
    }
}