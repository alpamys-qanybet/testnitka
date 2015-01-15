package test.task1;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children = new ArrayList<Node>();
    private int depth = 0;

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}