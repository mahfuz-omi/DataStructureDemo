/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class CircularQueue {
    
    private int data[];
    private int count;
    private int front;
    private int rear;

    public CircularQueue() {
        data = new int[10];
        count = 0;
        front = 0;
        rear = 0;
    }
    
    
    public void push(int data)
    {
        if(rear == 10) // if(count == 10)
        {
            rear = 0;
        }
        this.data[rear] = data;
        rear++;
        count++;
        
    }
    
    public int pop()
    {
        int data = this.data[front];
        front++;
        count--;
        if(front == 10)
        {
            front = 0;
        }
        
        return data;
    }
    
    
    
}
