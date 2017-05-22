/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.GenericLink;

/**
 *
 * @author omi
 */
public class GenericLinkListQueue<T> {
    
    private GenericLink<T> front;
    private GenericLink<T> rear;
    private int count;
    
    
    public GenericLinkListQueue()
    {
        this.count = 0;
        GenericLink<T> link = new GenericLink<>();
        link.next = null;
        this.front = this.rear = link;
    }
    
    public void push(T data)
    {
        GenericLink<T> link = new GenericLink<>();
        link.next = null;
        count++;
        rear.data = data;
        rear.next = link;
        rear = link;
        
    }
    
    public T pop()
    {
        if(front == rear)
        {
            System.out.println("no data");
            return null;
        }
        
        T data = front.data;
        front = front.next;
        count--;
        return data; 
    }
    
    public boolean isEmpty()
    {
        return (front == rear);
    }
}
