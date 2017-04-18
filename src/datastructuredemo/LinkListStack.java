/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class LinkListStack {
    
    public int count;
    public Link top;
    
    
    public LinkListStack()
    {
        this.count = 0;
        this.top = null;
    }
    
    public void push(int data)
    {
        Link link = new Link();
        link.data = data;
        count++;
        
        if(top == null)
        {
            top = link;
            link.next = null;
            return;
        }
        link.next = top;
        top = link;
    }
    
    public int pop()
    {
        int data = top.data;
        top = top.next;
        return data;
    }
    
    public boolean isEmpty()
    {
        return (top == null);
    }
    
}
