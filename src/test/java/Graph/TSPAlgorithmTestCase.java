package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TSPAlgorithmTestCase {

    @Test
    public void testExample1() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample1());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(80.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample2() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample2());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(550.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample3() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample3());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(2.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample4() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample4());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(4.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample5() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample5());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(8.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample6() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample6());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(4.414, results.getShortestDistance(), 1e-3);
    }

    @Test
    public void testExample7() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample7());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(4.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample8() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample8());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(10.24, results.getShortestDistance(), 1e-2);
    }

    @Test
    public void testExample9() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample9());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(12.36, results.getShortestDistance(), 1e-2);
    }

    @Test
    public void testExample10() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample10());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(284, results.getShortestDistance(), 1);
    }

    @Test
    public void testExample11() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample11());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(76, results.getShortestDistance(), 1);
    }

    private static UndirectedGraphInputs getGraphInputsExample1() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, 10);
        builder.addEntry(2, 3, 35);
        builder.addEntry(3, 1, 15);
        builder.addEntry(2, 4, 25);
        builder.addEntry(3, 4, 30);
        builder.addEntry(1, 4, 20);
        return builder.build();
    }

    private static UndirectedGraphInputs getGraphInputsExample2() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, 75.0);
        builder.addEntry(1, 5, 100.0);
        builder.addEntry(2, 3, 50.0);
        builder.addEntry(3, 4, 100.0);
        builder.addEntry(4, 5, 50.0);
        builder.addEntry(2, 5, 125.0);
        builder.addEntry(2, 4, 125.0);
        builder.addEntry(1, 3, 100.0);
        builder.addEntry(1, 4, 300.0);
        builder.addEntry(3, 5, 75.0);
        return builder.build();
    }

    private static UndirectedGraphInputs getGraphInputsExample3() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[]{new TwoDimensionPoint(1, 1), new TwoDimensionPoint(2, 1)};
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample4() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[4];
        points[0] = new TwoDimensionPoint(1.0, 1.0);
        points[1] = new TwoDimensionPoint(2.0, 1.0);
        points[2] = new TwoDimensionPoint(2.0, 2.0);
        points[3] = new TwoDimensionPoint(1.0, 2.0);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample5() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[8];
        points[0] = new TwoDimensionPoint(1.0, 1.0);
        points[1] = new TwoDimensionPoint(2.0, 1.0);
        points[2] = new TwoDimensionPoint(3.0, 1.0);
        points[3] = new TwoDimensionPoint(4.0, 1.0);
        points[4] = new TwoDimensionPoint(1.0, 2.0);
        points[5] = new TwoDimensionPoint(2.0, 2.0);
        points[6] = new TwoDimensionPoint(3.0, 2.0);
        points[7] = new TwoDimensionPoint(4.0, 2.0);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample6() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[5];
        points[0] = new TwoDimensionPoint(1.0, 1.0);
        points[1] = new TwoDimensionPoint(2.0, 1.0);
        points[2] = new TwoDimensionPoint(2.0, 2.0);
        points[3] = new TwoDimensionPoint(1.0, 2.0);
        points[4] = new TwoDimensionPoint(1.5, 1.5);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample7() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[12];
        points[0] = new TwoDimensionPoint(1.0, 1.0);
        points[1] = new TwoDimensionPoint(1.125, 1.0);
        points[2] = new TwoDimensionPoint(1.250, 1.0);
        points[3] = new TwoDimensionPoint(1.5, 1.0);
        points[4] = new TwoDimensionPoint(1.75, 1.0);
        points[5] = new TwoDimensionPoint(2.0, 1.0);
        points[6] = new TwoDimensionPoint(1.0, 2.0);
        points[7] = new TwoDimensionPoint(1.125, 2.0);
        points[8] = new TwoDimensionPoint(1.25, 2.0);
        points[9] = new TwoDimensionPoint(1.5, 2.0);
        points[10] = new TwoDimensionPoint(1.75, 2.0);
        points[11] = new TwoDimensionPoint(2.0, 2.0);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample8() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[3];
        points[0] = new TwoDimensionPoint(0.0, 0.0);
        points[1] = new TwoDimensionPoint(0.0, 3.0);
        points[2] = new TwoDimensionPoint(3.0, 3.0);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample9() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[8];
        points[0] = new TwoDimensionPoint(0.0, 2.05);
        points[1] = new TwoDimensionPoint(3.414213562373095, 3.4642135623730947);
        points[2] = new TwoDimensionPoint(0.5857864376269049, 0.6357864376269047);
        points[3] = new TwoDimensionPoint(0.5857864376269049, 3.4642135623730947);
        points[4] = new TwoDimensionPoint(2.0, 0);
        points[5] = new TwoDimensionPoint(4.05, 2.05);
        points[6] = new TwoDimensionPoint(2.0, 4.10);
        points[7] = new TwoDimensionPoint(3.414213562373095, 0.6357864376269047);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample10() {
        TwoDimensionPoint[] points = new TwoDimensionPoint[15];
        points[0] = new TwoDimensionPoint(0.549963E-07, 0.985808E-08);
        points[1] = new TwoDimensionPoint(-28.8733, -0.797739E-07);
        points[2] = new TwoDimensionPoint(-79.2916, -21.4033);
        points[3] = new TwoDimensionPoint(-14.6577, -43.3896);
        points[4] = new TwoDimensionPoint(-64.7473, 21.8982);
        points[5] = new TwoDimensionPoint(-29.0585, -43.2167);
        points[6] = new TwoDimensionPoint(-72.0785, 0.181581);
        points[7] = new TwoDimensionPoint(-36.0366, -21.6135);
        points[8] = new TwoDimensionPoint(-50.4808, 7.37447);
        points[9] = new TwoDimensionPoint(-50.5859, -21.5882);
        points[10] = new TwoDimensionPoint(-0.135819, -28.7293);
        points[11] = new TwoDimensionPoint(-65.0866, -36.0625);
        points[12] = new TwoDimensionPoint(-21.4983, 7.31942);
        points[13] = new TwoDimensionPoint(-57.5687, -43.2506);
        points[14] = new TwoDimensionPoint(-43.0700, 14.5548);
        return generateGraphInputs(points);
    }

    private static UndirectedGraphInputs getGraphInputsExample11() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, 12);
        builder.addEntry(1, 3, 29);
        builder.addEntry(2, 4, 3);
        builder.addEntry(4, 6, 5);
        builder.addEntry(5, 6, 16);
        builder.addEntry(3, 5, 23);
        builder.addEntry(2, 5, 25);
        builder.addEntry(1, 6, 24);
        builder.addEntry(3, 4, 21);
        builder.addEntry(3, 2, 19);
        builder.addEntry(3, 6, 28);
        builder.addEntry(1, 4, 22);
        builder.addEntry(5, 4, 4);
        builder.addEntry(2, 6, 6);
        builder.addEntry(1, 5, 13);
        return builder.build();
    }

    private static UndirectedGraphInputs generateGraphInputs(TwoDimensionPoint[] points) {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                builder.addEntry(i + 1, j + 1, EuclideanDistance.getEuclideanDistance(points[i].getX(), points[j].getX(), points[i].getY(), points[j].getY()));
            }
        }
        return builder.build();
    }

}
