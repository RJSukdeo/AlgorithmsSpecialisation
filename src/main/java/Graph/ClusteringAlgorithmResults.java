package Graph;

import DataStructures.QuickUnion;

import java.util.List;
import java.util.PriorityQueue;

public class ClusteringAlgorithmResults {

    private double maximumDistance;
    private double totalDistance;

    public ClusteringAlgorithmResults(ClusteringAlgorithm algorithm) {
        populateInstanceVariables(algorithm);
    }

    private void populateInstanceVariables(ClusteringAlgorithm algorithm) {
        maximumDistance = 0;
        totalDistance = 0;
        PriorityQueue<UndirectedEdge> remainingEdges = algorithm.getOrderedEdges();
        QuickUnion unionDataStructure = algorithm.getUnionDataStructure();
        while (remainingEdges.peek() != null) {
            UndirectedEdge edge = remainingEdges.poll();
            List<Node> encompassingNodes = edge.getEncompassingNodes();
            if (!unionDataStructure.find(encompassingNodes.get(0).getId(), encompassingNodes.get(1).getId())) {
                maximumDistance = Math.max(maximumDistance, edge.getLength());
                totalDistance += edge.getLength();
            }
        }
    }

    public double getMaxDistanceBetweenClusters() {
        return maximumDistance;
    }

    public double getTotalDistanceBetweenClusters() {
        return totalDistance;
    }

}