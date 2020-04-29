package GreedyAlgorithms;

final class IntermediateNode implements IHuffmanNode {

    private final IHuffmanNode[] children = new IHuffmanNode[2];
    private IntermediateNode parent;

    public void addChildNode(IHuffmanNode node, HuffmanChildType nodeType) {
        if (nodeType.equals(HuffmanChildType.LEFT)) {
            children[0] = node;
            return;
        }
        children[1] = node;
    }

    public IHuffmanNode getChildNode(HuffmanChildType type) {
        return type.equals(HuffmanChildType.LEFT) ? children[0] : children[1];
    }

    public Character leftOrRightNode(IHuffmanNode node) {
        if (node.equals(children[0])) {
            return 0;
        }
        if (node.equals(children[1])) {
            return 1;
        }
        return null;
    }

    @Override
    public void addParentNode(IntermediateNode node) {
        parent = node;
    }

    @Override
    public IntermediateNode getParentNode() {
        return parent;
    }

    @Override
    public HuffmanNodeType getType() {
        return HuffmanNodeType.INTERMEDIATE;
    }

}
