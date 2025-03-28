class Solution {
    private void comb(int[] candidates, int target, List<Integer> ls, List<List<Integer>> ans, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i=start;i<candidates.length;i++) {
            if (target - candidates[i] >=0 ) {
                ls.add(candidates[i]);
                comb(candidates, target-candidates[i], ls, ans,i);
                ls.remove(ls.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(candidates,target,new ArrayList<>(), ans,0);
        return ans;
    }
}