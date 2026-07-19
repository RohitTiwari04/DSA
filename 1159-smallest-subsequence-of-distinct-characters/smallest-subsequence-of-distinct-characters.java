class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (taken[idx]) continue;

            while (!st.isEmpty() &&
                   s.charAt(i) < st.peek() &&
                   lastIndex[st.peek() - 'a'] > i) {
                taken[st.pop() - 'a'] = false;
            }

            st.push(s.charAt(i));
            taken[idx] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}