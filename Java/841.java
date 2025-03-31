class Solution {
    boolean[] vis;
    private void visCheck(List<List<Integer>> rooms, int curr) {
        vis[curr] = true;
        for (int i: rooms.get(curr)) {
            if (!vis[i]) {
                visCheck(rooms, i);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        vis = new boolean[rooms.size()];
        vis[0] = true;
        visCheck(rooms, 0);
        for (boolean b: vis) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}