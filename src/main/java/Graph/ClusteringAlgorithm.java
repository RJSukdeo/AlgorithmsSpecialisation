package Graph;

import DataStructures.QuickUnion;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClusteringAlgorithm {

    private final UndirectedGraphGenerator graphGenerator;
    private PriorityQueue<UndirectedEdge> orderedEdges;
    private QuickUnion unionDataStructure;

    public ClusteringAlgorithm(UndirectedGraphInputs inputs) {
        graphGenerator = UndirectedGraphGenerator.getGenerator(inputs);
    }

    public ClusteringAlgorithmResults run(int endClusters) {
        List<UndirectedEdge> edges = graphGenerator.getEdges(true);
        orderedEdges = new PriorityQueue<>(edges.size(), new EdgeComparator());
        orderedEdges.addAll(edges);
        int numNodes = graphGenerator.getNodes(false).size();
        int numClusters = numNodes;
        unionDataStructure = new QuickUnion(numNodes);
        while (numClusters > endClusters) {
            UndirectedEdge edge = orderedEdges.poll();
            List<Node> nodes = edge.getEncompassingNodes();
            if (!unionDataStructure.find(nodes.get(0).getId(), nodes.get(1).getId())) {
                unionDataStructure.unite(nodes.get(0).getId(), nodes.get(1).getId());
                numClusters--;
            }
        }
        return new ClusteringAlgorithmResults(this);
    }

    PriorityQueue<UndirectedEdge> getOrderedEdges() {
        return orderedEdges;
    }

    QuickUnion getUnionDataStructure() {
        return unionDataStructure;
    }

    private class EdgeComparator implements Comparator<UndirectedEdge> {

        @Override
        public int compare(UndirectedEdge edge1, UndirectedEdge edge2) {
            return (int) edge1.getLength() - (int) edge2.getLength();
        }
    }

    private class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.getId() - node2.getId();
        }
    }

}
