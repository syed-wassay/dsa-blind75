import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class ContainsDuplicate {

    public static void main(String[] args) {
        // int[] nums = {1,3,2,3,4};
        // boolean duplicate = hasDuplicate(nums);
        // System.out.println(duplicate);
        int[] nums = new int[args.length]; // set Array size to the args length
        for (int i=0; i < args.length; i++) {
            try {
                nums[i] = Integer.parseInt(args[i]); // try parsing string arg at index i to an int
            } catch (NumberFormatException e) {
                System.out.println("could not parse " + args[i] + " to number");
            }
        }

        boolean duplicate = hasDuplicateBruteForce(nums);
        System.out.println(duplicate);

        boolean isDuplicate = hasDuplicateOptimized(nums);
        System.out.println(isDuplicate);
    }

    public static boolean hasDuplicateBruteForce(int[] nums) {
        for (int i=0; i < nums.length -1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasDuplicateOptimized(int[] nums) {
        Map<Integer, Integer> itemCounts = new HashMap<>(); // hashMap to store individual nums uniquely as keys and maintain the times they have occured in their values
        
        for (int num : nums) {
            if (itemCounts.containsKey(num)) {
                itemCounts.replace(num, itemCounts.get(num) + 1); // if key already exists increase it's count
            }
            else {
                itemCounts.put(num, 1); // if key does not exist then assign it value 1
            }
        }
        
        for (int key : itemCounts.keySet()) {
            if (itemCounts.get(key) > 1) {     // iterate over each key in hashMap and find if any key has a value greater than 1, if it does return true else return false after exiting the loop
                return true;
            }
        }

        return false;
    }

    public static boolean hasDuplicateMoreOptimized(int[] nums) {
        HashSet<Integer> seenElements = new HashSet<>(); // set to contain unique values

        for (int num : nums) {
            if (seenElements.contains(num)) { // iterate over each number and check that if it exists already in the set, if it does return true and exit
                return true;
            }
            else {
                seenElements.add(num); // if number does not exist add it to set
            }
        }

        return false; // return false if after iterating through all the elements and no duplicate if found
    }
}