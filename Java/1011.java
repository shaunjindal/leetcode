class Solution {
    public boolean canShip(int cap, int[] weights, int days) {
        int totalWt = 0;
        int d = 1;
        for (int i: weights) {
            totalWt+=i;
            if (totalWt > cap) {
                d++;
                totalWt = i;
                if (d>days) {
                    return false;
                }
            }


        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int right = Arrays.stream(weights).sum();
        int left = Arrays.stream(weights).max().getAsInt();
        int mid = 0;
        while (left<right) {
            mid = left + ((right-left)/2);
            if (canShip(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}