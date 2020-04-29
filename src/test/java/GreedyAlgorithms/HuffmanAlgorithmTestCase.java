package GreedyAlgorithms;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public final class HuffmanAlgorithmTestCase {

    @Test
    public void testExample() {
        HuffmanAlgorithm algorithm = new HuffmanAlgorithm(getInputs());
        HuffmanAlgorithmResults results = algorithm.run();
        Map<Long, String> idToCodeMap = results.getNodeIdToBinaryEncoding();
        assertEquals(2, idToCodeMap.get(3L).length());
        assertEquals(2, idToCodeMap.get(4L).length());
        assertEquals(2, idToCodeMap.get(6L).length());
        assertEquals(3, idToCodeMap.get(1L).length());
        assertEquals(4, idToCodeMap.get(2L).length());
        assertEquals(4, idToCodeMap.get(5L).length());
        assertEquals(2, results.getMinimumBitSize());
        assertEquals(4, results.getMaximumBitSize());
    }

    private HuffmanAlgorithmInput getInputs() {
        HuffmanAlgorithmInput input = new HuffmanAlgorithmInput(6);
        input.addEntry(1, 3);
        input.addEntry(2, 2);
        input.addEntry(3, 6);
        input.addEntry(4, 8);
        input.addEntry(5, 2);
        input.addEntry(6, 6);
        return input;
    }

}
