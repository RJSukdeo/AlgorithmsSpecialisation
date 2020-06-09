package Graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public final class TSPHeuristicAlgorithmTestCase {

    @Test
    public void testExample() {
        TSPHeuristicAlgorithm algorithm = new TSPHeuristicAlgorithm(getGraphInput());
        TSPHeuristicAlgorithmResults results = algorithm.run(1);
        assertEquals(37.80585655, results.getMinimumDistance(), 1e-8);
    }

    private Map<Integer, TwoDimensionPoint> getGraphInput() {
        String rawString = "12 12,10 12,12 10,3 3,16 4";
        String[] nodeStrings = rawString.split(",");
        Map<Integer, TwoDimensionPoint> nodeIdToPointMap = new HashMap<>(5);
        nodeIdToPointMap.put(1, getPoint(nodeStrings[0]));
        nodeIdToPointMap.put(2, getPoint(nodeStrings[1]));
        nodeIdToPointMap.put(3, getPoint(nodeStrings[2]));
        nodeIdToPointMap.put(5, getPoint(nodeStrings[3]));
        nodeIdToPointMap.put(4, getPoint(nodeStrings[4]));
        return nodeIdToPointMap;
    }

    private TwoDimensionPoint getPoint(String nodeEntry) {
        String[] xyStrings = nodeEntry.split(" ");
        return new TwoDimensionPoint(Double.parseDouble(xyStrings[0]), Double.parseDouble(xyStrings[1]));
    }

}
