package com.ap;

import java.util.*;

public class CourseSchedule {

    static class Graph {

        Map<Integer, Set<Integer>> adjacencyList;

        public Graph(int vertexCount) {
            this.adjacencyList = new HashMap<>();

            for (int i=0; i<vertexCount; i++) {
                adjacencyList.put(i, new HashSet<>());
            }

        }

        //Insert nodes and its edges here.
        private void insertEdge(int v1, int v2) {
            this.adjacencyList.get(v1).add(v2);
        }

    }

    public static void main(String[] args) {

        System.out.println(canFinish(5,new int[][]{{0,1},{0,2},{1,2},{2,3},{2,4}}));
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(canFinish(2,new int[][]{{0,1},{1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(numCourses);
        Map<Integer, Boolean> dpMap = new HashMap<>();

        for (int i=0; i< prerequisites.length; i++) {
            graph.insertEdge(prerequisites[i][0], prerequisites[i][1]);
            dpMap.put(i,null);
        }

        System.out.println(graph.adjacencyList);

        Map<Integer, Set<Integer>> adjacencyList = graph.adjacencyList;

        for (Integer key : adjacencyList.keySet()) {

            boolean[] visited = new boolean[numCourses];
            boolean[] tracker = new boolean[numCourses];

            if (!dfs(adjacencyList, key, visited, tracker, dpMap)) {
                return false;
            }

        }

        return true;

    }

    private static boolean dfs(Map<Integer, Set<Integer>> adjacencyList,
                               Integer key, boolean[] visited,
                               boolean[] tracker, Map<Integer,
                                Boolean> dpMap) {

        if (tracker[key]) {
            return false;
        }

        if (visited[key]) {
            return true;
        }

        if (dpMap.get(key) != null && dpMap.get(key) == Boolean.TRUE) {
            return true;
        }

        visited[key] = true;
        tracker[key] = true;

        Set<Integer> adjacency = adjacencyList.get(key);

        if (adjacency.isEmpty()) {
            return true;
        }

        for(Integer child : adjacency) {
            if (!dfs(adjacencyList, child, visited, tracker, dpMap)) {
                return false;
            }
            tracker[child] = false;
        }

        dpMap.putIfAbsent(key, Boolean.TRUE);

        return true;

    }
}
