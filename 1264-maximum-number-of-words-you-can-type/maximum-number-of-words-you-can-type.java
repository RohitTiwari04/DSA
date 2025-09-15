class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");

        int brokenWord = 0;
        for(String word : words){
            for(char c : word.toCharArray()){
                if(brokenLetters.indexOf(c) != -1){
                    brokenWord += 1;
                    break;
                }
            }
        }

        return words.length - brokenWord;
    }
}