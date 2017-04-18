/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import java.util.ArrayList;

/**
 *
 * @author omi
 */
public class HuffmanEncoder {
    
    ArrayList<HuffmanNode> lists;

    public HuffmanEncoder() {
        this.lists = new ArrayList<>();
    }
    
    public HuffmanEncoder(ArrayList<HuffmanNode> lists)
    {
        this.lists = lists;
    }    
    
    
    
    public HuffmanNode encode()
    {
        int numOfNodes = this.lists.size();
        PriorityQueueForHuffmanByHeap pQueue = new PriorityQueueForHuffmanByHeap(numOfNodes);
        pQueue.pushFullList(this.lists);
        
        for(int i=0;i<numOfNodes-1;i++)
        {
            HuffmanNode parent = null,leftChild = null,rightChild = null;
            parent = new HuffmanNode();
            leftChild = pQueue.pop();
            rightChild = pQueue.pop();
            
            parent.left = leftChild;
            parent.right = rightChild;
            parent.frequency = leftChild.frequency + rightChild.frequency;
            pQueue.push(parent);     
        }
        
        return pQueue.pop();
        
    }
    
    
    
    
    
}
