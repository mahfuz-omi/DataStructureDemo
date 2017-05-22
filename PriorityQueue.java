/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.Arrays;

/**
 *
 * @author omi
 */
public class PriorityQueue {
    private int data[];
    private int count;
    
    private int front;
    private int rear;

    public PriorityQueue() {
        this.data = new int[10];
        this.count = 0;
        this.front = 0;
        this.rear = 0;
    }
    
    public int pop()
    {
        int data = this.data[front];
        front++;
        count--;
        return data;
    }
    
    public void push(int data)
    {
        this.data[rear] = data;
        rear++;
        count++;
        Arrays.sort(this.data,0,count);
        
    }
    
    
    
    
    
    
    
}
