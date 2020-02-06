package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UndirectedGraphInputs {

    private final Map<Integer, List<Integer>> nodeToNodesMap;
    private final EdgeInputContainer edgeInputs;

    private UndirectedGraphInputs(InputBuilder builder) {
        this.nodeToNodesMap = builder.nodeToNodesMap;
        this.edgeInputs = builder.edgeInputs;
    }

    Map<Integer, List<Integer>> getNodeToNodesMap() {
        return nodeToNodesMap;
    }

    EdgeInputContainer getEdgeInputsContainer() {
        return edgeInputs;
    }

    public static class InputBuilder {

        private final Map<Integer, List<Integer>> nodeToNodesMap;
        private final EdgeInputContainer edgeInputs;

        public InputBuilder() {
            this.nodeToNodesMap = new HashMap<>();
            this.edgeInputs = new EdgeInputContainer();
        }

        public InputBuilder addEntry(final Integer nodeId, final List<Integer> connectingNodeIds) {
            this.nodeToNodesMap.put(nodeId, connectingNodeIds);
            connectingNodeIds.forEach(id -> edgeInputs.addEntry(nodeId, id, 0));
            return this;
        }

        public InputBuilder addEntries(final Map<Integer, List<Integer>> entries) {
            for (Integer nodeId : entries.keySet()) {
                addEntry(nodeId, entries.get(nodeId));
            }
            return this;
        }

        public InputBuilder addEntry(final int firstNodeId, final int secondNodeId, final double lengthBetweenNodes) {
            edgeInputs.addEntry(firstNodeId, secondNodeId, lengthBetweenNodes);
            if (!nodeToNodesMap.containsKey(firstNodeId)) {
                List<Integer> connectingNodeIds = new ArrayList<>();
                nodeToNodesMap.put(firstNodeId, connectingNodeIds);
                return this;
            }
            nodeToNodesMap.get(firstNodeId).add(secondNodeId);
            return this;
        }

        public UndirectedGraphInputs build() {
            return new UndirectedGraphInputs(this);
        }
    }

}
