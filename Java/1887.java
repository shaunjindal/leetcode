class Solution1 {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> mp = new TreeMap<>(Comparator.reverseOrder());
        for (int i: nums) {
            if (!mp.containsKey(i)) {
                mp.put(i, 0);
            }
            mp.put(i, mp.get(i) + 1);
        }
        int ans = 0;
        int lastAddedVal =0;
        // 1 -> 2
        // 2 ->
// 1 2 3 4 5 6 7 8 9 10
// ans = 1
// ans = 1 + 2 = 3
// ans = 3 + 3


// 1 2 3 4 5 6 7 8 8 8

//         1 1 1 1 1 1 1 1 1 1
//         1 1 1 1 1 1 1 3 2 1


        int prevSum = 0;
        for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            prevSum = prevSum + entry.getValue();
            ans += prevSum;
        }
        return ans - prevSum;
    }
}

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int up = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                up++;
            }

            ans += up;
        }

        return ans;
    }
}


