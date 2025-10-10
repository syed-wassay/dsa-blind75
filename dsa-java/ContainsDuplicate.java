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

        boolean duplicate = hasDuplicate(nums);
        System.out.println(duplicate);
    }

    public static boolean hasDuplicate(int[] nums) {
        for (int i=0; i < nums.length -1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}