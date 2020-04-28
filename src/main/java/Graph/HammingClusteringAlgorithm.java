package Graph;

import DataStructures.QuickUnion;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class HammingClusteringAlgorithm {

    private final List<String> entries;
    private int numberOfClusters;

    public HammingClusteringAlgorithm(List<String> entries) {
        this.entries = entries;
        System.out.println("Number of Entries: " + entries.size());
    }

    public HammingClusteringAlgorithmResult run() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputs());
        List<UndirectedEdge> edges = graphGenerator.getEdges(true);
        QuickUnion union = new QuickUnion(entries.size());
        PriorityQueue<UndirectedEdge> orderedEdges = new PriorityQueue<>(edges.size(), new EdgeComparator());
        orderedEdges.addAll(edges);
        numberOfClusters = entries.size();
        while (orderedEdges.peek() != null) {
            UndirectedEdge edge = orderedEdges.poll();
            List<Node> encompassingNodes = edge.getEncompassingNodes();
            if (!union.find(encompassingNodes.get(0).getId(), encompassingNodes.get(1).getId())) {
                union.unite(encompassingNodes.get(0).getId(), encompassingNodes.get(1).getId());
                numberOfClusters--;
            }
        }
        return new HammingClusteringAlgorithmResult(this);
    }

    private UndirectedGraphInputs getGraphInputs() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        for (int i = 0; i < entries.size(); i++) {
            for (int j = i + 1; j < entries.size(); j++) {
                int hammingDistance = HammingDistanceUtil.getHammingDistance(entries.get(i), entries.get(j), 3);
                if (hammingDistance <= 2) {
                    builder.addEntry(i, j, hammingDistance);
                }
            }
        }
        return builder.build();
    }

    int getNumberOfClusters() {
        return numberOfClusters;
    }

    private class EdgeComparator implements Comparator<UndirectedEdge> {
        @Override
        public int compare(UndirectedEdge edge1, UndirectedEdge edge2) {
            return (int) edge1.getLength() - (int) edge2.getLength();
        }
    }

}
