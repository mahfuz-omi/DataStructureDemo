/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.Edge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author omi
 */
public class GenericPriorityQueue {
    
    private ArrayList<Edge> edges;

    public GenericPriorityQueue() {
        this.edges= new ArrayList<>();
    }
    
    public void push(Edge data)
    {
        this.edges.add(data);
        Collections.sort(this.edges);      
    }
    
    public Edge pop()
    {
        return this.edges.remove(0);
    }
    
    public void print()
    {
        for(Edge e:edges)
        {
            System.out.println(e.weight+"");
        }
    }

    
   
    
    

   
    
}
