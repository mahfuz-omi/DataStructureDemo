/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.Link;

/**
 *
 * @author omi
 */
public class LinkListQueue {
    
    private Link front;
    private Link rear;
    private int count;
    
    public LinkListQueue()
    {
        this.count = 0;
        Link link = new Link();
        link.next = null;
        this.front = this.rear = link;
    }
    
    
    public void push(int data)
    {
        Link link = new Link();
        link.next = null;
        count++;
        rear.data = data;
        rear.next = link;
        rear = link;
           
    }
    
    public int pop()
    {
        if(front == rear)
        {
            System.out.println("no data");
            return -1;
        }
        
        int data = front.data;
        front = front.next;
        count--;
        return data;   
    }
    
    public boolean isEmpty()
    {
        return (front == rear);
    }
    
}
