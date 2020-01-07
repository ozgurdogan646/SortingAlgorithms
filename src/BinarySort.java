
import java.util.ArrayList;

public class BinarySort  
{ 
  
    // Class containing left and 
    // right child of current  
    // node and key value 
    public class Node  
    { 
        int key; 
        Node left, right; 
  
        public Node(int item)  
        { 
            key = item; 
            left = right = null; 
        } 
    } 
  
    // Root of BST 
    public Node root; 
  
    // Constructor 
    BinarySort()  
    {  
        root = null;  
    } 
  
    // This method mainly 
    // calls insertRec() 
    public void insert(int key) 
    { 
        root = insertRec(root, key); 
    } 
      
    /* A recursive function to  
    insert a new key in BST */
    public Node insertRec(Node root, int key)  
    { 
  
        /* If the tree is empty, 
        return a new node */
        if (root == null)  
        { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur 
        down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the root */
        return root; 
    } 
      
    // A function to do  
    // inorder traversal of BST 
    public void inorderRec(Node root , ArrayList<Integer> arr)  
    {
        if (root != null)  
        {  
            inorderRec(root.left,arr);  
            arr.add(root.key);
            inorderRec(root.right,arr);
        }
        
    } 
    public void treeins(Integer arr[]) 
    { 
        for(int i = 0; i < arr.length; i++) 
        { 
            insert(arr[i]); 
        } 
    }
}