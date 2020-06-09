package Graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TwoSATTestCases {

    @Test
    public void testExample1() {
        TwoSATAlgorithm algorithm = new TwoSATAlgorithm(getGraphInputsExample1());
        TwoSATAlgorithmResults results = algorithm.run();
        assertFalse(results.isSatisfiable());
    }

    @Test
    public void testExample2() {
        TwoSATAlgorithm algorithm = new TwoSATAlgorithm(getGraphInputsExample2());
        TwoSATAlgorithmResults results = algorithm.run();
        assertTrue(results.isSatisfiable());
    }

    @Test
    public void testExample3() {
        TwoSATAlgorithm algorithm = new TwoSATAlgorithm(getGraphInputsExample3());
        TwoSATAlgorithmResults results = algorithm.run();
        assertTrue(results.isSatisfiable());
    }

    @Test
    public void testExample4() {
        TwoSATAlgorithm algorithm = new TwoSATAlgorithm(getGraphInputsExample4());
        TwoSATAlgorithmResults results = algorithm.run();
        assertTrue(results.isSatisfiable());
    }

    @Test
    public void testExample5() {
        TwoSATAlgorithm algorithm = new TwoSATAlgorithm(getGraphInputsExample5());
        TwoSATAlgorithmResults results = algorithm.run();
        assertFalse(results.isSatisfiable());
    }

    private String[] getGraphInputsExample1() {
        String[] inputs = new String[3];
        inputs[0] = "-1 2";
        inputs[1] = "-2 -1";
        inputs[2] = "1 1";
        return inputs;
    }

    private String[] getGraphInputsExample2() {
        String[] inputs = new String[3];
        inputs[0] = "1 2";
        inputs[1] = "1 2";
        inputs[2] = "2 -3";
        return inputs;
    }

    private String[] getGraphInputsExample3() {
        String[] inputs = new String[3];
        inputs[0] = "1 -2";
        inputs[1] = "-1 -2";
        inputs[2] = "2 -3";
        return inputs;
    }

    private String[] getGraphInputsExample4() {
        String[] inputs = new String[4];
        inputs[0] = "1 2";
        inputs[1] = "-1 3";
        inputs[2] = "3 4";
        inputs[3] = "-2 -4";
        return inputs;
    }

    private String[] getGraphInputsExample5() {
        String[] inputs = new String[6];
        inputs[0] = "1 -2";
        inputs[1] = "-1 2";
        inputs[2] = "-2 4";
        inputs[3] = "-2 -4";
        inputs[4] = "2 4";
        inputs[5] = "2 -4";
        return inputs;
    }


}
