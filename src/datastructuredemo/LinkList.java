/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class LinkList {
    
    private Link first;

    public LinkList() {
        this.first = null;
    }
    
    public Link getFirstLink()
    {
        return this.first;
    }
    
    
    public void addElement(int value)
    {
        if(first == null)
        {
            first = new Link();
            first.data = value;
            first.next = null;
        }
        else
        {
            Link p = first;
            while(p.next != null)
            {
                p = p.next;
            }
            Link q = new Link();
            q.data = value;
            q.next = null;
            p.next = q;   
            
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
