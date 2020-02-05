package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UndirectedGraphInputs {

    private final Map<Integer, List<Integer>> organisedInputs;

    private UndirectedGraphInputs(Map<Integer, List<Integer>> structuredInput) {
        this.organisedInputs = structuredInput;
    }

    Map<Integer, List<Integer>> getOrganisedInputs() {
        return organisedInputs;
    }

    public static class InputBuilder {

        private final Map<Integer, List<Integer>> organisedInputs;

        public InputBuilder() {
            this.organisedInputs = new HashMap<>();
        }

        public InputBuilder addEntry(Integer nodeId, List<Integer> connectingNodeIds) {
            this.organisedInputs.put(nodeId, connectingNodeIds);
            return this;
        }

        public InputBuilder addEntries(Map<Integer, List<Integer>> entries) {
            for (Integer nodeId : entries.keySet()) {
                addEntry(nodeId, entries.get(nodeId));
            }
            return this;
        }

        public UndirectedGraphInputs build() {
            return new UndirectedGraphInputs(organisedInputs);
        }
    }

}
