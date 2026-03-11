// class Solution {
//     public int[] findRedundantConnection(int[][] edges) {
//         int[] parent=new int[edges.length+1];
//         for(int i=1; i<edges.length; i++){
//             parent[i]=i;
//         }
//         for(int[] edge : edges){
//             int node1=edge[0];
//             int node2=edge[1];

//             int root1=find(parent, node1);
//             int root2=find(parent, node2);

//             if(root1==root2){
//                 return edge;
//             }
//             parent[root2]=root1;
//         }
//         return new int[0];
//     }
//     private int find(int[] parent, int node){
//         while(node!=parent[node]){
//             parent[node]=parent[parent[node]];
//             node=parent[node];
//         }
//         return node;
//     }
// }

class Solution{
    public int[] findRedundantConnection(int[][] edges){
        int[] parent= new int[edges.length+1];
        for(int i=0; i<edges.length; i++){
            parent[i]=i;
        }
        for(int[] edge : edges){
            int node1=edge[0];
            int node2=edge[1];

            int root1=find(parent, node1);
            int root2=find(parent, node2);

            if(root1==root2){
                return edge;
            }
            parent[root2]=root1;   
        }
        return new int[0];
    }
    private int find(int[] parent, int node){
        while(node!=parent[node]){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
}

// class Solution {
//     int[] parent;
//     public int find(int x){
//         if(parent[x] != x){
//             parent[x] = find(parent[x]); // path compression
//         }
//         return parent[x];
//     }
//     public boolean union(int a, int b){
//         int rootA = find(a);
//         int rootB = find(b);
//         if(rootA == rootB){
//             return false; // cycle detected
//         }
//         parent[rootA] = rootB;
//         return true;
//     }
//     public int[] findRedundantConnection(int[][] edges) {
//         int n = edges.length;
//         parent = new int[n + 1];
//         for(int i = 1; i <= n; i++){
//             parent[i] = i;
//         }
//         for(int[] edge : edges){
//             if(!union(edge[0], edge[1])){
//                 return edge;
//             }
//         }
//         return new int[0];
//     }
// }


// piyush
// class Solution{
//     int[] parent;
//     private int find(int x){
//         if(parent[x]!=x){
//             parent[x]=find(parent[x]);
//         }
//         return parent[x];
//     }
//     private boolean union(int a, int b){
//         int rootA=find(a);
//         int rootB=find(b);
//         if(rootA==rootB){
//             return false;
//         }
//         parent[rootB]=rootA;
//         return true;
//     }
//     public int[] findRedundantConnection(int[][] edges){
//         int n= edges.length;
//         parent=new int[n+1];
//         for(int i=0; i<n+1; i++){
//             parent[i]=i;
//         }
//         for(int[] edge : edges){
//             if(!union(edge[0], edge[1])){
//                 return edge;
//             }
//         }
//         return new int[0];
//     }
// }