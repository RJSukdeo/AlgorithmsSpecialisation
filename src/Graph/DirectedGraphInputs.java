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

        public InputBuilder addEntry(Integer tailNodeId, Integer headNodeId) {
            edgeInputContainer.addEntry(tailNodeId, headNodeId, 0);
            return this;
        }

        public InputBuilder addEntries(List<List<Integer>> entries) {
            entries.forEach(entry -> edgeInputContainer.addEntry(entry.get(0), entry.get(1), 0));
            return this;
        }

        public DirectedGraphInputs build() {
            return new DirectedGraphInputs(this);
        }
    }
}
