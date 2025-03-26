class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        // Single pass: calculate moves from both left and right
        for (int i = 0; i < n; i++) {
            // Left pass
            answer[i] += movesToLeft;
            ballsToLeft += boxes.charAt(i) == '1' ? 1 : 0;
            movesToLeft += ballsToLeft;
            answer[n - 1 - i] += movesToRight;
            ballsToRight += boxes.charAt(n - 1 - i) == '1' ? 1 : 0;
            movesToRight += ballsToRight;
        }

        return answer;

    }
}