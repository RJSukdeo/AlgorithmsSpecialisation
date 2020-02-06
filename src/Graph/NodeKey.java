package Graph;

import java.util.*;

final class NodeKey {

    private final List<Integer> nodeIds;

    public NodeKey(final int... nodeIds) {
        this.nodeIds = new ArrayList<>(nodeIds.length);
        for (int nodeId : nodeIds) {
            this.nodeIds.add(nodeId);
        }
    }

    public List<Integer> getNodeIds() {
        return nodeIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeKey key = (NodeKey) o;
        return Objects.equals(nodeIds, key.nodeIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeIds);
    }

}
