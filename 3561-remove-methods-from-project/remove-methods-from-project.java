// class Solution {
//     public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
//         List<Integer> result = new ArrayList<>();
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++)
//             adj.add(new ArrayList<>());

//         for (int[] edge : invocations) {
//             int a = edge[0];
//             int b = edge[1];
//             adj.get(a).add(b);
//         }

//         Set<Integer> set = new HashSet<>();
//         dfs(adj, set, k);
//         boolean remove = true;
//         for (int[] edge : invocations) {
//             if (!set.contains(edge[0]) && set.contains(edge[1])) {
//                 remove = false;
//                 break;
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             if (!set.contains(i) || !remove)
//                 result.add(i);
//         }
//         return result;
//     }

//     void dfs(List<List<Integer>> adj, Set<Integer> set, int i) {
//         if (set.contains(i))
//             return;
//         set.add(i);
//         for (int node : adj.get(i))
//             dfs(adj, set, node);
//     }
// }


// class Solution {
//     public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
//         List<List<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] node:invocations){
//             int u=node[0];
//             int v=node[1];
//             adj.get(u).add(v);
//         }
//         Queue<Integer> q=new LinkedList<>();
//         boolean[] susp=new boolean[n];
//         q.offer(k);
//         susp[k]=true;
//         while(!q.isEmpty()){
//             int u=q.poll();
//             for(int v:adj.get(u)){
//                 if(!susp[v]){
//                     q.offer(v);
//                     susp[v]=true;
//                 }
//             }
//         }
//         for(int[] node:invocations){
//             int u=node[0];
//             int v=node[1];
//             if(!susp[u]&&susp[v]){
//                 List<Integer> ans=new ArrayList<>();
//                 for(int i=0;i<n;i++){
//                     ans.add(i);
//                 }
//                 return ans;
//             }
//         }
//         List<Integer> ans=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             if(!susp[i]){
//              ans.add(i);
//             }
//         }
//         return ans;
//     }
// }

class Solution{
    public List<Integer> remainingMethods(int n, int k, int[][] invocations){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] node : invocations){
            int u = node[0];
            int v = node[1];
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] susp = new boolean[n];
        q.offer(k);
        susp[k] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                if(!susp[v]){
                    q.offer(v);
                    susp[v] = true;
                }
            }
        }
        for(int[] node : invocations){
            int u = node[0];
            int v = node[1];
            if(!susp[u] && susp[v]){
                List<Integer> ans = new ArrayList<>();
                for(int i=0; i<n; i++) ans.add(i);
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!susp[i]) ans.add(i);
        }
        return ans;
    }
}