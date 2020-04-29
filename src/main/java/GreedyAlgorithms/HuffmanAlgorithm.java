package GreedyAlgorithms;

import java.util.*;

public final class HuffmanAlgorithm {

    private final PriorityQueue<HuffmanGraph> sortedGraphs;
    private Map<Long, String> nodeIdToCompressedBinary;

    public HuffmanAlgorithm(HuffmanAlgorithmInput input) {
        sortedGraphs = new PriorityQueue<>(input.getLeafNodes().size(), new HuffmanGraphComparator());
        nodeIdToCompressedBinary = new HashMap<>(input.getLeafNodes().size());
        input.getLeafNodes().forEach(node -> sortedGraphs.add(new HuffmanGraph(node)));
    }

    public HuffmanAlgorithmResults run() {
        while(sortedGraphs.size() > 1) {
            List<HuffmanGraph> graphs = new ArrayList<>(2);
            graphs.add(sortedGraphs.poll());
            graphs.add(sortedGraphs.poll());
            HuffmanGraph mergedGraphs = new HuffmanGraph(graphs, new IntermediateNode());
            sortedGraphs.add(mergedGraphs);
        }
        populateMap(sortedGraphs.poll());
        return new HuffmanAlgorithmResults(this);
    }

    private void populateMap(HuffmanGraph graph) {
        graph.getLeafNodes().forEach(node -> nodeIdToCompressedBinary.put(node.getId(), node.getCode()));
    }

    public Map<Long, String> getNodeIdToBinaryEncoding() {
        return nodeIdToCompressedBinary;
    }

    private class HuffmanGraphComparator implements Comparator<HuffmanGraph>{

        @Override
        public int compare(HuffmanGraph graph1, HuffmanGraph graph2) {
            long difference = graph1.getWeight() - graph2.getWeight();
            if (difference < 0) {
                return -1;
            }
            if (difference > 0) {
                return 1;
            }
            return 0;
        }

    }

}
