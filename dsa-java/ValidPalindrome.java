public class ValidPalindrome {

    public static void main(String[] args) {
        // String s = "race a car";
        // System.out.println(isPalindrome(s));

        // s = "amanaplanacanalpanama";
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase(); // covert all characters to lower case for correct comparison
        int firstPointer = 0;
        int lastPointer = s.length() - 1;

        if (s.isBlank()) {
            return true;
        }

        while (firstPointer < lastPointer) {
            /* 
            if any of the pointer is on a blank space or a special character ignore it
            and update the specific pointer
            */
            if (!Character.isLetterOrDigit(s.charAt(firstPointer))) {
                firstPointer++;
                continue; // continue because if the next value after the blank space or special character is also a blank space or special character then it should ignore it as well
            }

            if (!Character.isLetterOrDigit(s.charAt(lastPointer))) {
                lastPointer--;
                continue;
            }

            if (s.charAt(firstPointer) != s.charAt(lastPointer)) {
                return false; // if the alphanumeric values at both the pointers don't match then return false 
            }

            // update the pointers for each iteration
            firstPointer++;
            lastPointer--;
        }

        return true; // return true if all the values at both the pointers matched throughout the itteration
    }
}
