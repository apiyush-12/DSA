class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : invocations) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
        }

        Set<Integer> set = new HashSet<>();
        dfs(adj, set, k);
        boolean remove = true;
        for (int[] edge : invocations) {
            if (!set.contains(edge[0]) && set.contains(edge[1])) {
                remove = false;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i) || !remove)
                result.add(i);
        }
        return result;
    }

    void dfs(List<List<Integer>> adj, Set<Integer> set, int i) {
        if (set.contains(i))
            return;
        set.add(i);
        for (int node : adj.get(i))
            dfs(adj, set, node);
    }
}