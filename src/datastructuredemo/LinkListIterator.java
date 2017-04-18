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
public class LinkListIterator<T> implements Iterator<T>{
    
    private GenericLink<T> first;
    private GenericLink<T> now;

    public LinkListIterator() {
        this.first = null;
        this.now = null;
    }
    
    public LinkListIterator(GenericLink<T> first)
    {
        this.first = first;
        this.now = first;
    }
    
    

    @Override
    public T next() {
        T data = now.data;
        now = now.next;
        return data;
        
    }

    @Override
    public boolean hasNext() {
        if(now.next != null)
            return true;
        return false;
        
    }

    
    
}
