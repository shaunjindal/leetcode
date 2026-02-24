class Solution {
    public int minimumArrayLength(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        while(i>=0 && nums[0]!=nums[i]){
            i--;
        }
        for (int x : nums)
            if (x % nums[0] > 0)
                return 1;
        if(i<=0) return 1;
        return (i+1)%2 == 1 ? ((i+1)/2) +1 : (i+1)/2;
    }
}
