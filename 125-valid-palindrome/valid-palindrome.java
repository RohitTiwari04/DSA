class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder s1 = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                s1.append(Character.toLowerCase(c));
            }
        }

        String news1 = s1.toString();
        String revs1 = s1.reverse().toString();

        return news1.equals(revs1);
    }
}