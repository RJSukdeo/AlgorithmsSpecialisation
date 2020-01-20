package Graph;

import java.util.HashMap;
import java.util.Map;

public class DirectedGraphInputs {

    private final Map<Integer, Integer> organisedInputs;

    private DirectedGraphInputs(Map<Integer, Integer> structuredInput) {
        this.organisedInputs = structuredInput;
    }

    Map<Integer, Integer> getOrganisedInputs() {
        return organisedInputs;
    }

    public static class InputBuilder {

        private final Map<Integer, Integer> organisedInputs;

        public InputBuilder() {
            this.organisedInputs = new HashMap<>();
        }

        public DirectedGraphInputs.InputBuilder addEntry(Integer tailNodeId, Integer headNodeId) {
            this.organisedInputs.put(tailNodeId, headNodeId);
            return this;
        }

        public DirectedGraphInputs build() {
            return new DirectedGraphInputs(organisedInputs);
        }
    }
}
