/*
** @author Suman Shakya
** 01-05-2015

** Simple Binary Search Tree implementation to find the lowest common ancestor of two nodes
*/

public class BST{
    private Node root;
    
    public BST(){
        this.root = null;
    }
    
    /*
    ** Inserts node into BST
    */
    public void insert(int value){
        this.root = insert(this.root, value);
    }
    
    private Node insert(Node node, int value){
        if(node == null)
            return new Node(value);
        
        if(value > node.value)
            node.right = insert(node.right, value);
        else
            node.left = insert(node.left, value);
        return node;
    }
    
    /*
    ** Returns the lowest common ancestor of two nodes in BST
    */
    public int lowestCommonAncestor(int val1, int val2){
        return lowestCommonAncestor(this.root, val1, val2);
    }
    
    private int lowestCommonAncestor(Node node, int val1, int val2){
        if(node == null) return -1;
        
        if(Math.max(val1, val2) < node.value)
            return lowestCommonAncestor(node.left, val1, val2);
        else if(Math.min(val1, val2) > node.value)
            return lowestCommonAncestor(node.right, val1, val2);
        else
            return node.value;
    }
    
    /*
    ** Class representing node of BST
    */
    private class Node{
        private int value;
        private Node left;
        private Node right;
        
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}