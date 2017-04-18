/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

/**
 *
 * @author omi
 */
public class BinaryTree {
    
    public BinaryNode root;

    public BinaryTree() 
    {
        this.root = null;
    }
    
    public BinaryTree(BinaryNode root)
    {
        this.root = root;
    }
    
    
    
    public void search(int key)
    {
        BinaryNode p = root;
        while(p != null)
        {
            if(p.data == key)
            {
                System.out.println("found");
                return;
            }
            else if(p.data > key)
            {
                p = p.left;
            }
            else
                p = p.right;
        }
        System.out.println("not found");
        
    }
    
    private void preOrderTravers(BinaryNode node)
    {
        if(node != null)
        {
            System.out.println(node.data+" ");
            preOrderTravers(node.left);
            preOrderTravers(node.right);
        }
        
    }
    
    public void DFS_Preorder()
    {
        this.preOrderTravers(this.root);
    }
    
    public void addNode(int key)
    {
        if(this.root == null)
        {
            root = new BinaryNode(key);
            root.left = null;
            root.right = null;
            return;
        }
        BinaryNode p = root;
        BinaryNode q = null;// for parent
        while(p != null)
        {
            if(p.data == key)
            {
                System.out.println("data already exists");
                return;
            }
            else if(p.data > key)
            {
                q = p;
                p = p.left;
            }
            else
            {
                q = p;
                p = p.right;
            }        
        }
        p = new BinaryNode(key);
        p.left = null;
        p.right = null;
        if(q.data > key)
            q.left = p;
        else
            q.right = p;
           
    }
    
    public void BFS_Travers()
    {
        BinaryNode node = this.root;
        GenericLinkListQueue<BinaryNode> queue = new GenericLinkListQueue<>();
        queue.push(node);
        while(!queue.isEmpty())
        {
            BinaryNode p = queue.pop();
            System.out.println(p.data+"");
            if(p.left != null)
                queue.push(p.left);
            if(p.right != null)
                queue.push(p.right);
        }
    }
    
    
    private void inOrderTravers(BinaryNode node)
    {
        if(node != null)
        {
            inOrderTravers(node.left);
            System.out.println(node.data+" ");
            inOrderTravers(node.right);
        }
        
    }
    
    public void printAscendingOrderTree()
    {
        this.inOrderTravers(root);
    }
    
    public int getMinimum()
    {
        BinaryNode node = root;
        BinaryNode temp = null;
        while(node != null)
        {
            temp = node;
            node = node.left;
            
        }
        if(temp != null)
            return temp.data;
        else
            return -1;
        
    }
    
    public int getMaximum()
    {
        BinaryNode node = root;
        BinaryNode temp = null;
        while(node != null)
        {
            temp = node;
            node = node.right;
            
        }
        if(temp != null)
            return temp.data;
        else
            return -1;
        
    }
    
    /// eta baki ache...korte hobe...
    public void delete(int key)
    {
        BinaryNode node = root;
        BinaryNode parent = null;
        while(node != null)
        {
            if(node.data == key)
            {
                System.out.println("found");
                return;
            }
            else if(node.data > key)
            {
                node = node.left;
            }
            else
                node = node.right;
            
        }
        
    }
    
    
    
    
    
    
    
    
}
