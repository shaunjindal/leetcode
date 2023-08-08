#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    int maxJump(vector<int>& stones) {
        if(stones.size() == 2) {
            return stones[1];
        }
        int n = stones.size();
        int ans = 0;
        for(int i = 2;i<n;i+=2){
            ans = max(ans,stones[i]-stones[i-2]);
        }
        ans = max(ans,stones[n-1]-stones[n-2]);
        for(int i= n%2 ? n-2:n-1;i>=2;i-=2){
            ans = max(ans,stones[i]-stones[i-2]);
        }
        return ans;
    }
};