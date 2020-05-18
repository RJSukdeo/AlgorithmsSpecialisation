package Graph;

import java.util.List;

public final class DirectedGraphInputs {

    private final EdgeInputContainer edgeInputContainer;

    private DirectedGraphInputs(final InputBuilder builder) {
        this.edgeInputContainer = builder.edgeInputContainer;
    }

    EdgeInputContainer getEdgeInputContainer() {
        return edgeInputContainer;
    }

    public static class InputBuilder {

        private final EdgeInputContainer edgeInputContainer;

        public InputBuilder() {
            this.edgeInputContainer = new EdgeInputContainer();
        }

        public InputBuilder addEntry(Integer tailNodeId, Integer headNodeId, Integer length) {
            edgeInputContainer.addEntry(tailNodeId, headNodeId, length);
            return this;
        }

        public InputBuilder addEntry(Integer tailNodeId, Integer headNodeId) {
            addEntry(tailNodeId, headNodeId, 0);
            return this;
        }

        public InputBuilder addEntries(List<List<Integer>> entries) {
            for (List<Integer> entry : entries) {
                if (entry.size() == 2) {
                    edgeInputContainer.addEntry(entry.get(0), entry.get(1), 0);
                }
                if (entry.size() == 3) {
                    edgeInputContainer.addEntry(entry.get(0), entry.get(1), entry.get(2));
                }
            }
            return this;
        }

        public DirectedGraphInputs build() {
            return new DirectedGraphInputs(this);
        }
    }
}
