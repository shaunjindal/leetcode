class Solution {
    public int countPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
           for (int j = i+1; j < nums.length; j++) {
               if (checkAlmostEqual(nums[i], nums[j]) || checkAlmostEqual(nums[j], nums[i])) {
                   ans++;
               }
           }
        }
        return ans;
    }
   private boolean checkAlmostEqual(int a, int b) {
        if (a == b) {
            return true;
        }

        String bStr = Integer.toString(b);
        char[] digits = bStr.toCharArray();

        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                // Swap digits
                char temp = digits[i];
                digits[i] = digits[j];
                digits[j] = temp;

                // Check if the new number equals a
                int newB = Integer.parseInt(new String(digits));
                if (newB == a) {
                    return true;
                }

                // Swap back to original
                temp = digits[i];
                digits[i] = digits[j];
                digits[j] = temp;
            }
        }

        return false;
    }
    
}
