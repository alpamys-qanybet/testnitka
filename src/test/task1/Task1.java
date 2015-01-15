package test.task1;

public class Task1 {
    private static int height = 0;
    
    public static void main(String[] args) {
        // initializing node
        Node root = new Node();
        
        Node element1 = new Node();
        Node element2 = new Node();
        Node element3 = new Node();
        Node element4 = new Node();
        Node element5 = new Node();
        Node element6 = new Node();
        
        // initializing tree
        element5.getChildren().add(element6);
        element2.getChildren().add(element5);
        root.getChildren().add(element2);
        
        element1.getChildren().add(element3);
        element1.getChildren().add(element4);
        root.getChildren().add(element1);

/*
e - element
(depth, height)
            root(0,3)
         /            \
     e1 (1,1)          e2(1,2)
    /     \              \               
e3 (2,0)   e4(2,0)      e5(2,1)
                           \
                           e6(3,0)
 */
        assignDepth(root, 1);
     
        System.out.println("tree");
        drawTree(root);
        
        System.out.println("height");
        System.out.println(height);
    }
    
    private static void assignDepth(Node parent, int depth) {
        for (Node node: parent.getChildren()) {
            node.setDepth(depth);
            
            assignDepth(node, depth+1);
        }
    }
    
    private static void drawTree(Node parent) {
        for (Node node: parent.getChildren()) {
            System.out.println(node.getDepth());
    
            // maximum depth according to selected root node is its height
            if (node.getDepth() > height)
                height = node.getDepth();
            
            drawTree(node);
        }
    }
}
