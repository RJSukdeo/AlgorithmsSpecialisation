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

    public static UndirectedGraphInputs.InputBuilder getUndirectedGraphInputsWithLength() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, 1);
        builder.addEntry(2, 3, 3);
        builder.addEntry(3, 4, 1);
        builder.addEntry(1, 4, 4);
        builder.addEntry(1, 3, 2);
        return builder;
    }

    public static UndirectedGraphInputs.InputBuilder getUndirectedGraphInputsWithLength2() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(0,1, 4);
        builder.addEntry(1,7, 11);
        builder.addEntry(0,7, 8);
        builder.addEntry(1,2, 8);
        builder.addEntry(2,8, 2);
        builder.addEntry(7,8, 7);
        builder.addEntry(7,6, 1);
        builder.addEntry(8,6, 6);
        builder.addEntry(6,5, 2);
        builder.addEntry(2,5, 4);
        builder.addEntry(2,3, 7);
        builder.addEntry(3,4, 9);
        builder.addEntry(5,4, 10);
        builder.addEntry(3,5, 14);
        return builder;
    }

    public static List<List<Integer>> getReversedDirectedGraphInputs() {
        List<List<Integer>> graphInfo = new ArrayList<>(11);
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

    public static List<List<Integer>> getDirectedGraphInputs1() {
        List<List<Integer>> graphInfo = new ArrayList<>(11);
        graphInfo.add(getIntegerList(1, 7));
        graphInfo.add(getIntegerList(7, 4));
        graphInfo.add(getIntegerList(4, 1));
        graphInfo.add(getIntegerList(7, 9));
        graphInfo.add(getIntegerList(9, 6));
        graphInfo.add(getIntegerList(6, 3));
        graphInfo.add(getIntegerList(3, 9));
        graphInfo.add(getIntegerList(6, 8));
        graphInfo.add(getIntegerList(8, 5));
        graphInfo.add(getIntegerList(5, 2));
        graphInfo.add(getIntegerList(2, 8));
        return graphInfo;
    }

    public static List<List<Integer>> getDirectedGraphInputs2() {
        List<List<Integer>> graphInfo = new ArrayList<>(5);
        graphInfo.add(getIntegerList(1, 2));
        graphInfo.add(getIntegerList(2, 3));
        graphInfo.add(getIntegerList(3, 1));
        graphInfo.add(getIntegerList(1, 4));
        graphInfo.add(getIntegerList(5, 4));
        return graphInfo;
    }

    public static List<List<Integer>> getDirectedGraphInputs3() {
        List<List<Integer>> graphInfo = new ArrayList<>(5);
        graphInfo.add(getIntegerList(3, 4));
        graphInfo.add(getIntegerList(0, 3));
        graphInfo.add(getIntegerList(1, 0));
        graphInfo.add(getIntegerList(0, 2));
        graphInfo.add(getIntegerList(2, 1));
        return graphInfo;
    }

    public static List<List<Integer>> getDirectedGraphInputs4() {
        List<List<Integer>> graphInfo = new ArrayList<>(8);
        graphInfo.add(getIntegerList(5, 6));
        graphInfo.add(getIntegerList(2, 5));
        graphInfo.add(getIntegerList(5, 7));
        graphInfo.add(getIntegerList(1, 2));
        graphInfo.add(getIntegerList(3, 1));
        graphInfo.add(getIntegerList(2, 4));
        graphInfo.add(getIntegerList(6, 7));
        graphInfo.add(getIntegerList(4, 3));
        return graphInfo;
    }

    public static List<List<Integer>> getDirectedGraphInputs5() {
        List<List<Integer>> graphInfo = new ArrayList<>(14);
        graphInfo.add(getIntegerList(2, 3));
        graphInfo.add(getIntegerList(6, 7));
        graphInfo.add(getIntegerList(5, 1));
        graphInfo.add(getIntegerList(3, 4));
        graphInfo.add(getIntegerList(8, 7));
        graphInfo.add(getIntegerList(3, 7));
        graphInfo.add(getIntegerList(2, 5));
        graphInfo.add(getIntegerList(1, 2));
        graphInfo.add(getIntegerList(5, 6));
        graphInfo.add(getIntegerList(2, 6));
        graphInfo.add(getIntegerList(4, 8));
        graphInfo.add(getIntegerList(4, 3));
        graphInfo.add(getIntegerList(8, 4));
        graphInfo.add(getIntegerList(7, 6));
        return graphInfo;
    }

    public static List<List<Integer>> getDirectedGraphInputs6() {
        List<List<Integer>> graphInfo = new ArrayList<>();
        graphInfo.add(getIntegerList(2, 6));
        graphInfo.add(getIntegerList(3, 7));
        graphInfo.add(getIntegerList(3, 8));
        graphInfo.add(getIntegerList(1, 5));
        graphInfo.add(getIntegerList(5, 1));
        graphInfo.add(getIntegerList(9, 9));
        graphInfo.add(getIntegerList(8, 4));
        graphInfo.add(getIntegerList(5, 6));
        graphInfo.add(getIntegerList(1, 2));
        graphInfo.add(getIntegerList(2, 1));
        graphInfo.add(getIntegerList(3, 2));
        graphInfo.add(getIntegerList(6, 7));
        graphInfo.add(getIntegerList(7, 6));
        graphInfo.add(getIntegerList(8, 7));
        graphInfo.add(getIntegerList(4, 3));
        graphInfo.add(getIntegerList(9, 4));
        graphInfo.add(getIntegerList(9, 8));
        return graphInfo;
    }

    private static List<Integer> getIntegerList(Integer... entries) {
        return Arrays.asList(entries);
    }

}
