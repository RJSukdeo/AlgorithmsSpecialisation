package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public final class HuffmanGraph {

    private long weight;
    private IntermediateNode rootNode;
    private List<IHuffmanNode> nodes = new ArrayList<>();
    private List<LeafNode> leafNodes = new ArrayList<>();

    public HuffmanGraph(List<HuffmanGraph> graphs, IntermediateNode rootNode) {
        this.rootNode = rootNode;
        nodes.add(rootNode);
        HuffmanChildType childType = HuffmanChildType.LEFT;
        for (HuffmanGraph graph : graphs) {
            if (graph.getRootNode() == null) {
                graph.getNodes().get(0).addParentNode(rootNode);
                nodes.add(graph.getNodes().get(0));
                leafNodes.add((LeafNode) graph.getNodes().get(0));
                rootNode.addChildNode(graph.getNodes().get(0), childType);
            } else {
                graph.getRootNode().addParentNode(rootNode);
                rootNode.addChildNode(graph.getRootNode(), childType);
                for (IHuffmanNode node : graph.getNodes()) {
                    nodes.add(node);
                    if (node.getType().equals(HuffmanNodeType.LEAF)) {
                        leafNodes.add((LeafNode) node);
                    }
                }
            }
            childType = childType.equals(HuffmanChildType.LEFT) ? HuffmanChildType.RIGHT : HuffmanChildType.LEFT;
        }
        recalculateWeight();
    }

    public HuffmanGraph(LeafNode node) {
        nodes.add(node);
        leafNodes.add(node);
        recalculateWeight();
    }

    public IntermediateNode getRootNode() {
        return rootNode;
    }

    public List<IHuffmanNode> getNodes() {
        return nodes;
    }

    public List<LeafNode> getLeafNodes() {
        return leafNodes;
    }

    public long getWeight() {
        return weight;
    }

    private void recalculateWeight() {
        weight = 0;
        for (LeafNode node : leafNodes) {
            weight += node.getWeight();
        }
    }

}
