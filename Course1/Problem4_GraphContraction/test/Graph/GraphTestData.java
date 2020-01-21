package Graph;

import java.util.*;

final class GraphTestData {

    private GraphTestData() {
    }

    ;

    //  getGraphInputs produces the input to be used by GraphManager, graph represented below.
//
//  1-----2
//  | \   |
//  |  \  |
//  |   \ |
//  4-----3
    public static Map<Integer, List<Integer>> getUndirectedGraphInputs() {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        // Define node 1
        List<Integer> connectedNodes = new ArrayList<>(3);
        connectedNodes.add(2);
        connectedNodes.add(3);
        connectedNodes.add(4);
        graphMap.put(1, connectedNodes);

        // Define node 2
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(1);
        connectedNodes.add(3);
        graphMap.put(2, connectedNodes);

        // Define node 3
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(2);
        connectedNodes.add(4);
        connectedNodes.add(1);
        graphMap.put(3, connectedNodes);

        // Define node 4
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(1);
        connectedNodes.add(3);
        graphMap.put(4, connectedNodes);

        return graphMap;
    }

    public static List<List<Integer>> getReversedDirectedGraphInputs() {
        List<List<Integer>> graphInfo = new ArrayList<>();
        graphInfo.add(getIntegerList(2, 3));
        graphInfo.add(getIntegerList(3, 4));
        graphInfo.add(getIntegerList(4, 2));
        graphInfo.add(getIntegerList(4, 5));
        graphInfo.add(getIntegerList(5, 6));
        graphInfo.add(getIntegerList(6, 1));
        graphInfo.add(getIntegerList(1, 5));
        graphInfo.add(getIntegerList(6, 9));
        graphInfo.add(getIntegerList(9, 7));
        graphInfo.add(getIntegerList(7, 8));
        graphInfo.add(getIntegerList(8, 9));
        return graphInfo;
    }

    public static List<List<Integer>> getDirectedGraphInputs() {
        List<List<Integer>> graphInfo = new ArrayList<>();

        return graphInfo;
    }

    private static List<Integer> getIntegerList(Integer... entries) {
        List<Integer> collection = new ArrayList<>(entries.length);
        return Arrays.asList(entries);
    }

}
