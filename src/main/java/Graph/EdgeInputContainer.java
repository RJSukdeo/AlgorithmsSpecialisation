package Graph;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

final class EdgeInputContainer {

    private final Map<NodeKey, IEdgeLength> edgeInputMap;

    EdgeInputContainer() {
        edgeInputMap = new LinkedHashMap<>();
    }

    public void addEntry(final int nodeId1, final int nodeId2, final double edgeLength) {
        NodeKey key = new NodeKey(nodeId1, nodeId2);
        IEdgeLength edgeLengthObject = edgeLength == 0 ? new NoLength() : new Length(edgeLength);
        edgeInputMap.put(key, edgeLengthObject);
    }

    public boolean containsLength(final int nodeId1, final int nodeId2) {
        return edgeInputMap.containsKey(new NodeKey(nodeId1, nodeId2));
    }

    public IEdgeLength getLength(final int nodeId1, final int nodeId2) {
        if (!containsLength(nodeId1, nodeId2)) {
            System.out.println("No length specified for nodes {" + nodeId1 + " , " + nodeId2 + "}.");
            return new NoLength();
        }
        return edgeInputMap.get(new NodeKey(nodeId1, nodeId2));
    }

    public Set<NodeKey> getNodes() {
        return edgeInputMap.keySet();
    }
}
