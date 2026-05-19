class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        // Edge cases
        if (s == null || s.length() == 0 ||
            words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        // Store frequency of words
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word,
                    wordMap.getOrDefault(word, 0) + 1);
        }

        // Try all possible offsets
        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int count = 0;

            HashMap<String, Integer> windowMap = new HashMap<>();

            // Move right pointer in steps of word length
            for (int right = i;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Valid word
                if (wordMap.containsKey(word)) {

                    windowMap.put(word,
                            windowMap.getOrDefault(word, 0) + 1);

                    count++;

                    // If frequency exceeds required frequency
                    while (windowMap.get(word) > wordMap.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLen);

                        windowMap.put(leftWord,
                                windowMap.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    // Found valid substring
                    if (count == totalWords) {

                        result.add(left);

                        // Slide window forward
                        String leftWord =
                                s.substring(left, left + wordLen);

                        windowMap.put(leftWord,
                                windowMap.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                } else {
                    // Invalid word -> reset window
                    windowMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}