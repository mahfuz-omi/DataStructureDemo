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
public class GenericLinkListStack<T>{
    private GenericLink<T> top;
    private int count;
    

    public GenericLinkListStack() {
        top = null;
        count = 0;
        
    }
    
    public void push(T data)
    {
        GenericLink<T> link = new GenericLink<>();
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
    
    public T pop()
    {
        if(top == null)
        {
        
            System.out.println("no data on stack");
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }
    
    public boolean isEmpty()
    {
        return (top == null);
    }
    
    
    
    
    
    
}
