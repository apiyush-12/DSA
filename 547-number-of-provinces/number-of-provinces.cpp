class Solution {
    private:
    void dfs(int node ,  vector<vector<int>>& isConnected,vector<int> &vis ,
     vector<vector<int>>   &adj  ){
        vis[node]= 1 ;

        for(auto it : adj[node]){
            if(vis[it]!=1){
                dfs(it ,isConnected , vis , adj );

            }
        }


    }
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int count = 0 ;

    int m = isConnected.size();
    int n = isConnected[0].size();
   vector<int> vis(n, 0);
    vector<vector<int>> adj(n, vector<int>(n, 0));
    for( int i = 0 ; i< m ; i++){
        for(int j = 0 ; j<n ; j++){
            if(isConnected[i][j]){
                adj[i].push_back(j);
                adj[j].push_back(i);

            }
        }
    }




    for(int i =0 ; i<m ; i++ ){
        if(!vis[i]){
            count++;
            dfs(i, isConnected, vis, adj );
          
            
        }
    }

return count ;

    }
};