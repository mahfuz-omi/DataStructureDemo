/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.HuffmanNode;
import java.util.ArrayList;

/**
 *
 * @author omi
 */
public class PriorityQueueForHuffmanByHeap {
    
    /// min queue...the minimum is at root
    
    private HuffmanNode [] nodes;
    private int currentIndex;
    private int MAX_SIZE;
    
    
    public PriorityQueueForHuffmanByHeap(int size)
    {
        this.MAX_SIZE = size;
        this.nodes = new HuffmanNode[size];
        this.currentIndex = 0;
    }
    
    private void swap(int childIndex,int parentIndex)
    {
        HuffmanNode temp;
        temp = this.nodes[parentIndex];
        this.nodes[parentIndex] = this.nodes[childIndex];
        this.nodes[childIndex] = temp;    
    }
    
    private void trickle_up(int child)
    {
        swap(child,(child-1)/2);
        child = (child-1)/2;
        if(child == 0)
            return;
        if(this.nodes[child].frequency < this.nodes[(child-1)/2].frequency)
        {
            this.trickle_up(child);    
        }    
    }
    
    public void printHuffmanTree()
    {
        for(int i=0;i<this.currentIndex;i++)
        {
            if(this.nodes[i] != null)
                System.out.println(i+":"+this.nodes[i].ch);
                System.out.println(i+":"+this.nodes[i].frequency);
                System.out.println("");
        }
        
    }
    
    public void pushFullList(ArrayList<HuffmanNode> lists)
    {
        for(HuffmanNode node:lists)
        {
            this.push(node);
        }
    }
    
    
    
    
    public void push(HuffmanNode node)
    {
        if(this.currentIndex == this.MAX_SIZE)
        {
            System.out.println("no place for new data...heap full");
            return;   
        }
        //HuffmanNode node = new HuffmanNode(data);
        this.nodes[this.currentIndex] = node;
        if(this.currentIndex == 0)
        {
            this.currentIndex++;
            return;
        }
        
        // if child is at x index, it's parent is at (x-1)/2 index.
        //for a node in x index, it's left child is at 2x+1 and right child is at 2x+2 index.
        if(this.nodes[this.currentIndex].frequency < this.nodes[(this.currentIndex-1)/2].frequency)
        {
            this.trickle_up(this.currentIndex);   
        }
        this.currentIndex++;
             
    }
    
    
    
    
    
    
    public HuffmanNode pop()
    {
        // delete the min node....here it is root
        System.out.println("deleting: "+this.nodes[0].ch+":"+this.nodes[0].frequency);
        HuffmanNode node = this.nodes[0];
        this.currentIndex--;
        this.nodes[0] = this.nodes[this.currentIndex];
        this.trickle_down(0);
        return node;
    }
    
    public void trickle_down(int index)
    {
        int smallerChildIndex =0;
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = leftChildIndex + 1;
        if(this.currentIndex <= 2*index+1) // this node has no child
            return;
        if(this.nodes[leftChildIndex].frequency < this.nodes[rightChildIndex].frequency )
            smallerChildIndex = leftChildIndex;
        else
            smallerChildIndex = rightChildIndex;
        if(this.nodes[smallerChildIndex].frequency > this.nodes[index].frequency)
            return;    // end of trickle
        swap(index,smallerChildIndex);
        trickle_down(smallerChildIndex);    
    }
    
    
    public  HuffmanNode[] heapSort(HuffmanNode[] array)
    {
        HuffmanNode[] sortedArray = new HuffmanNode[array.length];
        for(int i=0;i<array.length;i++)
        {
            this.push(array[i]);  
        }
        for(int j=0;j<sortedArray.length;j++)
        {
            sortedArray[j] = this.pop();
        }
        
        return sortedArray;
        
        ///print 
        
    }
    
}
