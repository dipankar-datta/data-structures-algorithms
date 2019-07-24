package com.example.topic.datastructures;

import java.util.*;

public class GraphApp {

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);

        graph.showConnections();
    }
}

class MyGraph {
   /* int[][] edgeList = {{0, 2}, {2, 3}, {2, 1}, {1, 3}};

    int[][] adjucentList = {{2}, {2, 3}, {0, 1, 3}, {1, 3}};

    int[][] matrix = {
            {0, 0, 1, 0},
            {0, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
    };*/

    Map<Integer, List<Integer>> adjucentList;

    int length;

    public MyGraph() {
        adjucentList = new HashMap<Integer, List<Integer>>();
        length = 0;
    }

    public void addVertex(Integer point) {
        adjucentList.put(point, new ArrayList<>());
        length++;
    }

    public void addEdge(Integer point1, Integer point2) {
        adjucentList.get(point1).add(point2);
        adjucentList.get(point2).add(point1);
    }

    public void showConnections() {
        for (Map.Entry<Integer, List<Integer>> entry : adjucentList.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ---> ");
            System.out.print(entry.getValue().toString());
            System.out.println();
        }
    }
}
