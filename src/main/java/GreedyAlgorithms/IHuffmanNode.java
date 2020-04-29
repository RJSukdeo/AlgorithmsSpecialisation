package GreedyAlgorithms;

public interface IHuffmanNode {

    HuffmanNodeType getType();
    void addParentNode(IntermediateNode node);
    IntermediateNode getParentNode();

}
