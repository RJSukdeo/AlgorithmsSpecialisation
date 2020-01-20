package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphInput {

    private GraphInput() {
    }

    ;

    //  getGraphInputs produces the input to be used by GraphManager, graph represented below.
//
//  1-----2
//  | \   |
//  |  \  |
//  |   \ |
//  4-----3
    public static Map<Integer, List<Integer>> getGraphInputs() {
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

}
