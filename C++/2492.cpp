#include<iostream>
#include<unordered_map>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    void dfs(int src, unordered_map<int,vector<pair<int,int>>> &graph, vector<bool> &vis, int &ans){
        vis[src] = true;
        for(auto i: graph[src]){
            ans = min(ans,i.second);
            if(!vis[i.first]){
                dfs(i.first,graph,vis,ans);     
            }
        }
    }
    int minScore(int n, vector<vector<int>>& roads) {
        unordered_map<int,vector<pair<int,int>>> graph;
        for(auto i: roads){
            graph[i[0]].push_back({i[1],i[2]});
            graph[i[1]].push_back({i[0],i[2]});
        }
        vector<bool> vis(n+1,false);
        vis[1]=true;
        int ans = 1e9+7;
        dfs(1,graph,vis,ans);
        return ans;
    }
};