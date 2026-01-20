class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
            int ansX = Integer.MAX_VALUE;
            int ansY = Integer.MAX_VALUE;
            int maxF = 0;
            int dis = 0;
            for (int[] i: towers) {
                dis = Math.abs(center[0]-i[0]) + Math.abs(center[1]-i[1]);
                if (maxF <= i[2] && dis <= radius) {
                    if (ansX > i[0] || (ansX == i[0] && ansY > i[1]) || maxF != i[2]) {
                        ansX = i[0];
                        ansY = i[1];
                    }
                    maxF = i[2];
                }
            }
            return ansX == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{ansX, ansY};
        }
}
