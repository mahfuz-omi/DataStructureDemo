/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.GenericLinkListQueue;
import datastructuredemo.home_not_updated.BinaryNode;

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
                break;
            }
            else if(node.data > key)
            {
                parent = node;
                node = node.left;
            }
            else
            {
                parent = node;
                node = node.right;
            }    
        }
        if(node == null)
        {
            System.out.println("key not found");
            return;
        }
        
        if(node.left == null && node.right == null)   // node is a leaf node with no child
        {
            if(parent.left == node)
            {
                // node is the left child
                parent.left = null;
            }
            else 
            {
                parent.right = null;
                
            }    
        }
        else if((node.left == null && node.right != null)|| (node.right == null && node.left != null) ) // node has only one child
        {
            if(parent.left == node && node.right == null)
                // LL
            {
                parent.left = node.left;
                
            }
            else if(parent.left == node && node.left == null)
                // LR
            {
                parent.left = node.right;
                
            }
            else if(parent.right == node && node.right == null)
                // RL
            {
                parent.right = node.left;
                
            }
            else if(parent.right == node && node.left == null)
                // RR
            {
                parent.right = node.right;
                
            }    
        }
        else if(node.left != null && node.right != null)  // node has 2 childs
        {
            BinaryNode successorParent = null;
            BinaryNode successor = null;
            
            successorParent = node;
            successor = node.right;
            boolean isRightChild = true; // till now successor is the right child of it's parent
            while(successor.left != null)
            {
                successorParent = successor;
                successor = successor.left;
                isRightChild = false;
            }
            node.data = successor.data;
            if(isRightChild)
            {
                successorParent.right = successor.right; // successor is the right child of successor parent
                
            }
            else
            {
                successorParent.left = successor.right; // successor is the left child of successor parent
                
            }
                        
        }
        
    }
    
    private BinaryNode getInorderSuccessor(BinaryNode parent,BinaryNode node)  // get immediate next bigger key
    {
        parent = node;
        node = node.right;
        while(node.left != null)
        {
            parent = node;
            node = node.left;
        }
        return node;    
    }
    
    
    
    
    
    
    
    
}
