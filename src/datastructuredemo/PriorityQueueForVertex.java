/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omi
 */
public class PriorityQueueForVertex {
    
    private ArrayList<Vertex> vertices;

    public PriorityQueueForVertex() {
        this.vertices = new ArrayList<>();
    }
    
    public void push(Vertex data)
    {
        this.vertices.add(data);
        Collections.sort(this.vertices);      
    }
    
    public Vertex pop()
    {
        return this.vertices.remove(0);
    }
    
    public void print()
    {
        for(Vertex e:vertices)
        {
            System.out.println(e.distanceFromSource+"");
        }
    }
    
    public void clear()
    {
        this.vertices.clear();
    }

    
   
    
}
