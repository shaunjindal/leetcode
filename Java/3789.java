class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 <= costBoth) {
            return (((long)cost1) *((long)need1)) + (((long) cost2)*((long) need2));
        } else if (costBoth < cost1 && costBoth < cost2) {
            return (long) costBoth * Math.max(need1, need2);
        } else {
            if (need1 < need2) {
                return (long) need1 *costBoth + ((long) (need2 - need1) * (Math.min(costBoth, cost2)));
            } else {
                return (long) need2 * costBoth + ((long) (need1 - need2) * (Math.min(cost1, costBoth)));
            }
        }
    }
}
