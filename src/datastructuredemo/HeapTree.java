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
public class HeapTree {
    
    // this is max heap.....descendent order
    // eta diye priority queue implement kora hoy....
    
    public HeapNode []heap;
    public int currentIndex;
    public int MAX_SIZE;
    
    
    public HeapTree(int MAX_SIZE)
    {
        this.heap = new HeapNode[MAX_SIZE];
        this.currentIndex = 0; 
        this.MAX_SIZE = MAX_SIZE;
    }
 
    public void addNode(int data)
    {
        if(this.currentIndex == this.MAX_SIZE)
        {
            System.out.println("no place for new data...heap full");
            return;   
        }
        
        HeapNode node = new HeapNode(data);
        this.heap[this.currentIndex] = node;
        if(this.currentIndex == 0)
        {
            this.currentIndex++;
            return;
        }
        
        // if child is at x index, it's parent is at (x-1)/2 index.
        //for a node in x index, it's left child is at 2x+1 and right child is at 2x+2 index.
        if(this.heap[this.currentIndex].data > this.heap[(this.currentIndex-1)/2].data)
        {
            this.trickle_up(this.currentIndex);   
        }
        this.currentIndex++;
        
                  
    }
    
    
    private void swap(int childIndex,int parentIndex)
    {
        HeapNode temp;
        temp = this.heap[parentIndex];
        this.heap[parentIndex] = this.heap[childIndex];
        this.heap[childIndex] = temp;    
    }
    
    private void trickle_up(int child)
    {
        swap(child,(child-1)/2);
        child = (child-1)/2;
        if(child == 0)
            return;
        if(this.heap[child].data > this.heap[(child-1)/2].data)
        {
            this.trickle_up(child);    
        }    
    }
    
    public void printHeapTree()
    {
        for(int i=0;i<this.currentIndex;i++)
        {
            if(this.heap[i] != null)
                System.out.println(i+":"+this.heap[i].data);
        }
        
    }
    
    public HeapNode deleteNode()
    {
        // delete the max node....here it is root
        System.out.println("deleting: "+this.heap[0].data);
        HeapNode node = this.heap[0];
        this.currentIndex--;
        this.heap[0] = this.heap[this.currentIndex];
        this.trickle_down(0);
        return node;
    }
    
    public void trickle_down(int index)
    {
        int largerChildIndex =0;
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = leftChildIndex + 1;
        if(this.currentIndex <= 2*index+1) // this node has no child
            return;
        if(this.heap[leftChildIndex].data > this.heap[rightChildIndex].data )
            largerChildIndex = leftChildIndex;
        else
            largerChildIndex = rightChildIndex;
        if(this.heap[largerChildIndex].data < this.heap[index].data)
            return;    // end of trickle
        swap(index,largerChildIndex);
        trickle_down(largerChildIndex);    
    }
    
    
    public  HeapNode[] heapSort(HeapNode[] array)
    {
        HeapNode[] sortedArray = new HeapNode[array.length];
        for(int i=0;i<array.length;i++)
        {
            this.addNode(array[i].data);  
        }
        for(int j=0;j<sortedArray.length;j++)
        {
            sortedArray[j] = this.deleteNode();
        }
        
        return sortedArray;
        
        ///print 
        
    }
    
}