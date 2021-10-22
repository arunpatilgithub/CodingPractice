import java.util.*;

public class GraphDataStructure {

    static class Graph {

        private Map<Integer, Set<Integer>> adjacencyList;

        public Graph(int k) {
            this.adjacencyList = new HashMap();

            for (int i=0; i<k; i++) {
                adjacencyList.put(i, new HashSet<>());
            }
        }
    }

    private static void addVertex(Graph graph, int v) {
        graph.adjacencyList.putIfAbsent(v, new HashSet<>());
    }

    private static void deleteVertex(Graph graph, int v) {
        Set<Integer> vEdges = graph.adjacencyList.get(v);
        vEdges.forEach(ve -> graph.adjacencyList.get(ve).remove(v));
        graph.adjacencyList.remove(v);
    }

    private static void removeEdge(Graph graph, int v1, int v2) {
        graph.adjacencyList.get(v1).remove(v2);
        graph.adjacencyList.get(v2).remove(v1);
    }

    private static void addEdge(Graph graph, int v1, int v2) {

        Set<Integer> v1Adjacency = graph.adjacencyList.get(v1);

        if (v1Adjacency == null) {
            graph.adjacencyList.put(v1, new HashSet<>());
        }
        graph.adjacencyList.get(v1).add(v2);

//        Set<Integer> v2Adjacency = graph.adjacencyList.get(v2);
//
//        if (v2Adjacency == null) {
//            graph.adjacencyList.put(v2, new HashSet<>());
//        }
//
//        graph.adjacencyList.get(v2).add(v1);

    }

    private static boolean hasCycle(Graph graph) {

        Map<Integer, Set<Integer>> adjacency = graph.adjacencyList;

        for (Integer key : adjacency.keySet()) {
            boolean[] visited = new boolean[graph.adjacencyList.size()];
            boolean[] recStack = new boolean[graph.adjacencyList.size()];

            if (dfs(graph, key, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(Graph graph, Integer k, boolean[] visited, boolean[] recStack) {

        //Has cycle since we already visited this node.
        if (recStack[k]) {
            return true;
        }

        if (visited[k]) {
            return false;
        }

        visited[k] = true;
        recStack[k] = true;

        for (Integer connection : graph.adjacencyList.get(k)) {
            if (dfs(graph, connection, visited, recStack)) {
                return true;
            }
            recStack[k] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(5,new int[][]{{0,1},{0,2},{1,2},{2,3},{2,4}}));
    }

    public static boolean hasCycle(int n, int[][] edges) {

        Graph graph = new Graph(n);

        for (int i=0; i<edges.length; i++) {
            addEdge(graph,edges[i][0], edges[i][1]);
        }
        System.out.println(graph.adjacencyList);
        return hasCycle(graph);
    }

}
