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
public class HeapNode {
    public int data;
    public HeapNode left;
    public HeapNode right;
    
    public HeapNode(int data)
    {
        this.data= data;
        this.left =  null;
        this.right = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(HeapNode left) {
        this.left = left;
    }

    public void setRight(HeapNode right) {
        this.right = right;
    }
    
    
    
}
