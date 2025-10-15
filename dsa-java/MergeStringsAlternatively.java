public class MergeStringsAlternatively {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(mergeAlternately(word1, word2)); // result should be "apbqcr"
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        
        int iterations = word1.length() + word2.length() -1;
        boolean charsRemainingInWord1 = true;
        boolean charsRemainingInWord2 = true;

        /*
         since iterations varable will be an addition of both the string lengths,
         so to avoid index out of bounds error we will check if current value of
         iterations (i) is greater than or equal to the length of these individual words
         if it is then we will not add or try to access the that index for that string,
         here sequence matters word1 is added first and then word2
        */
         for (int i = 0; i < iterations; i++) {
            if (charsRemainingInWord1) {
                if (i >= word1.length()) {
                    charsRemainingInWord1 = false;
                }
                else {
                    result.append(word1.charAt(i));
                }
            }

            if (charsRemainingInWord2) {
                if (i >= word2.length()) {
                    charsRemainingInWord2 = false;
                }
                else {
                    result.append(word2.charAt(i));
                }
            }
        }

        return result.toString();
    }
}