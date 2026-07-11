// Approach-1 (Using DFS)
// T.C : O(V+E)
// S.C : O(V+E)
class Solution {
    private void dfs(int i, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        visited[i] = true;
        info[0]++;
        info[1] += adj.getOrDefault(i, new ArrayList<>()).size();
        
        for (int ngbr : adj.getOrDefault(i, new ArrayList<>())) {
            if (!visited[ngbr]) {
                dfs(ngbr, adj, visited, info);
            }
        }
    }
    
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int result = 0;
        
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int[] info = new int[2];
            dfs(i, adj, visited, info);
            
            if (info[0] * (info[0] - 1) == info[1]) {
                result++;
            }
        }
        
        return result;
    }
}

// Approach-2 (Using BFS)
// T.C : O(V+E)
// S.C : O(V+E)
class SolutionBFS {
    private void bfs(int i, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        visited[i] = true;
        
        while (!que.isEmpty()) {
            int curr = que.poll();
            info[0]++;
            info[1] += adj.getOrDefault(curr, new ArrayList<>()).size();
            
            for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[ngbr]) {
                    visited[ngbr] = true;
                    que.add(ngbr);
                }
            }
        }
    }
    
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int result = 0;
        
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int[] info = new int[2];
            bfs(i, adj, visited, info);
            
            if (info[0] * (info[0] - 1) == info[1]) {
                result++;
            }
        }
        
        return result;
    }
}
