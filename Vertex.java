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
public class Vertex implements Comparable<Vertex> {
    public String name;
    public boolean isVisited;
    public int distanceFromSource;
    public int startTime;
    public int endTime;
    
    public Vertex(String name)
    {
        this.name = name;
        this.isVisited = false;
        this.distanceFromSource = -1;
    }

//    @Override
//    public int compareTo(Vertex o) {
//        return this.distanceFromSource-o.distanceFromSource;
//    }
    
    @Override
    public int compareTo(Vertex o) {
        return o.endTime-this.endTime; // for decreasing order...for strongly connected components
    }
    
}
