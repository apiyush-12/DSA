// class Solution {
//     HashMap <Integer, List<Integer>> hmap;
//     boolean[] visited;
//     public int countCompleteComponents(int n, int[][] edges) {
//         hmap = new HashMap<>();
//         visited = new boolean[n];
//         for(int[] edge : edges){
//             int src = edge[0], dest = edge[1];
//             if(!hmap.containsKey(src)) hmap.put(src, new ArrayList<>());
//             if(!hmap.containsKey(dest)) hmap.put(dest, new ArrayList<>());
//             hmap.get(src).add(dest);
//             hmap.get(dest).add(src);
//         }
//         int ans = 0;
//         for(int i=0; i<n; i++){
//             if(!visited[i]){
//                 int[] temp = dfs(i);
//                 int ncount = temp[0], e = temp[1];
//                 if((ncount * (ncount-1) == e) || ncount ==1) ans++;
//             }
//         }
//         return ans;
//     }
//     int[] dfs(int node){
//         int[] ret = new int[2];
//         visited[node] = true;
//         ret[0] += 1;
//         List<Integer> list = hmap.get(node);
//         if(list == null) return ret;
//         ret[1] += list.size();
//         for(int i=0; i<list.size(); i++){
//             if(visited[list.get(i)]) continue;
//             int[] t = dfs(list.get(i));
//             ret[0] += t[0];
//             ret[1] += t[1];
//         }
//         return ret;
//     }
// }


class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);

                int nodes = component.size();
                int degreeSum = 0;

                for (int node : component) {
                    degreeSum += graph[node].size();
                }

                int edgesCount = degreeSum / 2;

                if (edgesCount == nodes * (nodes - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int node, ArrayList<Integer>[] graph, boolean[] visited,
             ArrayList<Integer> component) {

        visited[node] = true;
        component.add(node);

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited, component);
            }
        }
    }
}