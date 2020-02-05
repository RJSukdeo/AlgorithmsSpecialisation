package Graph;

import java.util.ArrayList;
import java.util.List;

public final class DirectedGraphInputs {

    private final List<List<Integer>> organisedInputs;

    private DirectedGraphInputs(List<List<Integer>> structuredInput) {
        this.organisedInputs = structuredInput;
    }

    List<List<Integer>> getOrganisedInputs() {
        return organisedInputs;
    }

    public static class InputBuilder {

        private final List<List<Integer>> organisedInputs;

        public InputBuilder() {
            this.organisedInputs = new ArrayList<>();
        }

        public InputBuilder addEntry(Integer tailNodeId, Integer headNodeId) {
            List<Integer> entries = new ArrayList<>(2);
            entries.add(tailNodeId);
            entries.add(headNodeId);
            organisedInputs.add(entries);
            return this;
        }

        public InputBuilder addEntries(List<List<Integer>> entries) {
            entries.forEach(entry -> organisedInputs.add(entry));
            return this;
        }

        public DirectedGraphInputs build() {
            return new DirectedGraphInputs(organisedInputs);
        }
    }
}
