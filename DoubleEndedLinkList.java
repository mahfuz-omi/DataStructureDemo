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
public class DoubleEndedLinkList {
    
    private Link first;
    private Link last;
    
    public DoubleEndedLinkList()
    {
        this.first = null;
        this.last = null;
    }
    
    public void addElement(int data)
    {
        Link p = new Link();
        p.data = data;
        p.next = null;
        if(first == null)
        {
            first = last = p;   
        }
        else
        { // last is not null so
            last.next = p;
            last = p;
               
        }
    }
    
    public void show()
    {
        Link p = first;
        while(p != null)
        {
            System.out.print(p.data);
            p = p.next;
            
        }
    }
    
    
    
}
