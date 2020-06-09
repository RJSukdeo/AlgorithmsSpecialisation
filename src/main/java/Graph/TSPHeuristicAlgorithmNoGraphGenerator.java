package Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class TSPHeuristicAlgorithmNoGraphGenerator {

    private final Map<Integer, TwoDimensionPoint> nodeToPointMap;
    private double minimumDistance;

    public TSPHeuristicAlgorithmNoGraphGenerator(Map<Integer, TwoDimensionPoint> nodeToPointMap) {
        this.nodeToPointMap = nodeToPointMap;
    }

    public TSPHeuristicAlgorithmResults run(final int startNodeId) {
        minimumDistance = 0;
        Set<Integer> unvisitedNodeIds = new HashSet<>(nodeToPointMap.keySet());
        unvisitedNodeIds.remove(startNodeId);
        int initialNodeId = startNodeId;
        int destinationNodeId = startNodeId;
        while (!unvisitedNodeIds.isEmpty()) {
            double tempDistance = Double.MAX_VALUE;
            for (final Integer unvisitedNodeId : unvisitedNodeIds) {
                double distance = EuclideanDistance.getEuclideanDistance(nodeToPointMap.get(initialNodeId), nodeToPointMap.get(unvisitedNodeId));
                if (distance < tempDistance) {
                    tempDistance = distance;
                    destinationNodeId = unvisitedNodeId;
                } else if (distance == tempDistance && unvisitedNodeId < destinationNodeId) {
                    destinationNodeId = unvisitedNodeId;
                }
            }
            unvisitedNodeIds.remove(destinationNodeId);
            initialNodeId = destinationNodeId;
            minimumDistance += tempDistance;
        }
        minimumDistance += getFinalEdgeLength(startNodeId, destinationNodeId);
        return new TSPHeuristicAlgorithmResults(this);
    }

    private double getFinalEdgeLength(int startNodeId, int destinationNodeId) {
        return EuclideanDistance.getEuclideanDistance(nodeToPointMap.get(startNodeId), nodeToPointMap.get(destinationNodeId));
    }

    double getMinimumDistance() {
        return minimumDistance;
    }

}
