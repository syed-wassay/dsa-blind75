import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static void main(String[] args) {
        
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // initialize a hashMap to store numbers as keys and values as their index
        int[] result = new int[2]; // initialize an array of size 2 for returning the two indexes
        int difference = 0;

        for (int i = 0; i < nums.length; i++) {
            difference = target - nums[i]; // calculate the difference between the target and the value at current index

            /* 
            if the hashMap contains the key for the difference then return the value (which is set to index) for the difference
            and the index of the current itteration because these will return the required indexes of the two numbers which add
            to give the target value
            */
            if (map.containsKey(difference)) {
                result[0] = map.get(difference);
                result[1] = i;
                break;
            }

            map.put(nums[i], i);

        }

        return result;
    }
}
