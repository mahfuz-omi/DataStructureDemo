/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.Vertex;

/**
 *
 * @author omi
 */

/// for undirected weighted graph
public class Edge implements Comparable<Edge>{
    
    public int weight;
    public Vertex v1,v2;
    public boolean isVisited;
    
    public Edge()
    {
        this.weight = 0;
        this.v1 = null;
        this.v2 = null;
        this.isVisited = false;
    }
    
    public Edge(int weight,Vertex v1,Vertex v2)
    {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public Edge(int weight)
    {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) 
    {
       return this.weight-o.weight; // for ascending order
    }

    @Override
    public String toString() {
        return (weight+"");
    }
    
    
    
}
