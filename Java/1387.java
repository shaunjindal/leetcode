class Solution {
    private int calcPow(int n){
        int a=0;
        while (n>1){
            if (n%2==0) n/=2;
            else n=3*n+1;
            a++;
        }
        return a;
    }
    public int getKth(int lo, int hi, int k) {
        Integer[] arr = new Integer[hi-lo+1];
        for (int i=lo;i<=hi;i++) {
            arr[i-lo]=i;
        }
        Arrays.sort(arr, Comparator.comparing((Integer n) -> calcPow(n)).thenComparing(Comparator.naturalOrder()));
        return arr[k-1];
    }
}
