package Graph;

import DataStructures.QuickUnion;

import java.util.List;
import java.util.PriorityQueue;

public class ClusteringAlgorithmResults {

    private double minimumDistance;
    private double totalDistance;
    private ClusteringAlgorithm algorithm;

    public ClusteringAlgorithmResults(ClusteringAlgorithm algorithm) {
        this.algorithm = algorithm;
        populateInstanceVariables(algorithm);
    }

    private void populateInstanceVariables(ClusteringAlgorithm algorithm) {
        PriorityQueue<UndirectedEdge> remainingEdges = algorithm.getOrderedEdges();
        QuickUnion unionDataStructure = algorithm.getUnionDataStructure();
        while (remainingEdges.peek() != null) {
            UndirectedEdge edge = remainingEdges.poll();
            List<Node> encompassingNodes = edge.getEncompassingNodes();
            if (!unionDataStructure.find(encompassingNodes.get(0).getId(), encompassingNodes.get(1).getId())) {
                if (minimumDistance == 0) {
                    minimumDistance = edge.getLength();
                }
                totalDistance += edge.getLength();
            }
        }
    }

    public double getMinDistanceBetweenClusters() {
        return minimumDistance;
    }

    public double getTotalDistanceBetweenClusters() {
        return totalDistance;
    }

}