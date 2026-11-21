class Solution {
    List<Integer>[] adj;
    List<Integer>[] tree;
    int[] newParent;
    int[] ans;
    int[] last;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        adj = new ArrayList[n];
        tree = new ArrayList[n];
        newParent = new int[n];
        ans = new int[n];
        last = new int[26];
        Arrays.fill(last,  -1);
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            adj[parent[i]].add(i);
        }
        newParent = parent.clone();
        dfs1(0, s);
        for(int i=1; i<n; i++){
            tree[newParent[i]].add(i);
        }
        dfs2(0);
        return ans;
    }
    void dfs1(int u, String s){
        int c = s.charAt(u)-'a';
        int prev = last[c];
        if(prev != -1) newParent[u] = prev;
        last[c] = u;
        for(int v : adj[u]) dfs1(v, s);
        last[c] = prev;
    }
    int dfs2(int u){
        ans[u] = 1;
        for(int v : tree[u]){
            ans[u] += dfs2(v);
        }
        return ans[u];
    }
}