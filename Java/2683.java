class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int a = 0;
        for (int i: derived) {
            a^=i;
        }
        return a==0;

    }
}