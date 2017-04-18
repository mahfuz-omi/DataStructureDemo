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
public class SortedLinkList {
    
    private Link first;
    
    
    public SortedLinkList()
    {
        this.first = null;
    }
    
    public void insert(int data)
    {
        Link r = new Link();
        r.data = data;
        Link p,q;
        p = first;
        q = null;
        while(p != null)
        {
            if(p.data > data)
            {
                if(q == null)
                {
                    r.next = p;
                    first = r;
                    return;
                    
                }
                q.next = r;
                r.next = p;
                return;
                
            }
            q = p;
            p = p.next;
        }
        if(q == null)
        {
            r.next = null;
            first = r;
            return;
            
        }
        
        q.next = r;
        r.next = p;
        
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
    
    public void delElement(int value)
    {
        Link p = first;
        Link q = null;
        while(p != null)
        {
            if(p.data == value)
            {
                if(q == null)
                {
                    first = p.next;
                    return;
                    
                }
                q.next = p.next;
                return;
            }
            q = p;
            p = p.next;
            
        }
        System.out.println("no data");
    }
    
}
