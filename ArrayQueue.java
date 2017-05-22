/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class ArrayQueue {
    private int data[];
    private int front;
    private int rear;
    
    public ArrayQueue()
    {
        data = new int[10];
        this.front = 0;
        this.rear = 0;
    }
    
    public void push(int data)
    {
        this.data[rear] = data;
        rear++;
        
    }
    
    public int pop()
    {
        int data = this.data[front];
        front++;
        return data;
    }
    
    public boolean isEmpty()
    {
        return (front == rear);
    }
    
}
