package GreedyAlgorithms;

final class LeafNode implements IHuffmanNode {

    private IntermediateNode parent;
    private final long weight;
    private final long id;

    LeafNode(final long weight, final long id) {
        this.weight = weight;
        this.id = id;
    }

    public long getWeight() {
        return weight;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder();
        IntermediateNode nextParent = parent;
        IHuffmanNode child = this;
        while (nextParent != null) {
            Character character = nextParent.leftOrRightNode(child);
            if (character != null) {
                sb.append(character);
                child = nextParent;
                nextParent = nextParent.getParentNode();
            }
        }
        return sb.reverse().toString();
    }

    @Override
    public IntermediateNode getParentNode() {
        return parent;
    }

    @Override
    public void addParentNode(IntermediateNode node) {
        parent = node;
    }

    @Override
    public HuffmanNodeType getType() {
        return HuffmanNodeType.LEAF;
    }

}
