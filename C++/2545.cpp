#include<vector>
#include<algorithm>
#include<iostream>
#include<map>
using namespace std;
class Solution {
public:
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        int n = score.size();
        int m = score[0].size();
        map<int,int> mp;
        vector<vector<int>> ans;
        for(int i=0;i<n;i++){
            mp[score[i][k]] = i;
        }
        for(auto i:mp){
            ans.push_back(score[i.second]);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};