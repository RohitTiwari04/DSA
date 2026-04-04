class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int l = encodedText.length();
        int columns = l / rows;

        char[][] mat = new char[rows][columns];

        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = encodedText.charAt(idx++);
            }
        }

        StringBuilder originalText = new StringBuilder();

        // Read diagonally
        for (int col = 0; col < columns; col++) {
            int i = 0, j = col;

            while (i < rows && j < columns) {
                originalText.append(mat[i][j]);
                i++;
                j++;
            }
        }

        // Remove trailing spaces
        while (originalText.length() > 0 && 
               originalText.charAt(originalText.length() - 1) == ' ') {
            originalText.deleteCharAt(originalText.length() - 1);
        }

        return originalText.toString();
    }
}