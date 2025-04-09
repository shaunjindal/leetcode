class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0,j=0;
        while(i<popped.length && j<popped.length) {
            st.push(pushed[i]);
            i++;
            while (!st.isEmpty() && st.peek()==popped[j]) {
                j++;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
