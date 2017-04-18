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
public class GenericLinkList<T> implements Iterable<T>{
    private GenericLink<T> first;

    public GenericLinkList() {
        this.first = null;
    }
    
    public void show()
    {
        GenericLink<T> p = first;
        while(p != null)
        {
            System.out.print(p.data);
            p = p.next;
            
        }
    }
    
    
    
    public void addElement(T data)
    {
        if(first == null)
        {
            first = new GenericLink<>();
            first.data = data;
            first.next = null;
        }
        else
        {
            GenericLink<T> p = first;
            while(p.next != null)
            {
                p = p.next;
            }
            GenericLink<T> q = new GenericLink<>();
            q.data = data;
            q.next = null;
            p.next = q;   
            
        }
    }
    
    public void delElement(T data)
    {
        GenericLink<T> p = first;
        GenericLink<T>  q = null;
        while(p != null)
        {
            if(p.data == data)
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

    @Override
    public Iterator<T> getIterator() {
        return new LinkListIterator<>(this.first);
    }
    
}
