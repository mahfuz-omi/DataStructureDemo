/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class Link {
    
    public int data;
    public Link next;
    
    public Link(int data)
    {
        this.data = data;
    }
    
    public Link()
    {
        
    }

    @Override
    public String toString() {
        return (this.data+""); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
