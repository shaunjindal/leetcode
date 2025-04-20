class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(Comparator.naturalOrder());
        tasks.sort(Comparator.reverseOrder());
        int ans = 0;
        int[] curr = new int[5];
        for (int i=0;i<processorTime.size();i++) {
            curr[0]=ans;
            curr[1]=processorTime.get(i)+tasks.get(4*i);
            curr[2]=processorTime.get(i)+tasks.get(4*i+1);
            curr[3]=processorTime.get(i)+tasks.get(4*i+2);
            curr[4]=processorTime.get(i)+tasks.get(4*i+3);
            ans = Arrays.stream(curr).max().getAsInt();
        }
        return ans;
    }
}
