/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author omi
 */
public class GraphAdjacencyMatrixDirected {   //Directed graph
    private Vertex [] vertices;
    private int current;
    private int [][] edgesArray;
    private Stack<Vertex> stack;
    
    
    public GraphAdjacencyMatrixDirected(int numOfVertices)
    {
        this.stack = new Stack<>();
        this.vertices = new Vertex[numOfVertices];
        this.edgesArray = new int[numOfVertices][numOfVertices];
    }
    public void addvertex(Vertex vertex)
    {
        this.vertices[current] = vertex;
        current++;  
    }
    public int getNumOfvertices()
    {
        return this.vertices.length;
    }
    
    public void addEdge(Vertex from,Vertex to)
    {
        int fromPosition = 0,toPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i] == from)
                fromPosition = i;
            if(this.vertices[i] == to)
                toPosition = i;   
        }
        this.edgesArray[fromPosition][toPosition] = 1;
    }
    
    public void addEdge(String from,String to)
    {
        int fromPosition = 0,toPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i].name.equalsIgnoreCase(from))
                fromPosition = i;
            if(this.vertices[i].name.equalsIgnoreCase(to))
                toPosition = i;   
        }
        this.edgesArray[fromPosition][toPosition] = 1;
    }
    
    public void showGraph()
    {
        for(int i=0;i<this.getNumOfvertices();i++)
        {
            for(int j=0;j<this.getNumOfvertices();j++)
            {
                System.out.print(this.edgesArray[i][j]+"");
            }
            System.out.println("");
        }
    }
    
    public boolean haveEdge(Vertex from,Vertex to)
    {
        int fromPosition = 0,toPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i] == from)
                fromPosition = i;
            if(this.vertices[i] == to)
                toPosition = i;    
        }
        if(this.edgesArray[fromPosition][toPosition] == 1)
            return true;
        else
            return false; 
    }
    
    
    public boolean haveEdge(String from,String to)
    {
        int fromPosition = 0,toPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i].name.equalsIgnoreCase(from))
                fromPosition = i;
            if(this.vertices[i].name.equalsIgnoreCase(to))
                toPosition = i;
            
        }
        if(this.edgesArray[fromPosition][toPosition] == 1)
            return true;
        else
            return false;   
    }
    
    public ArrayList<Vertex> getAdjacentVertices(Vertex a)
    {
        ArrayList<Vertex> vertices = new ArrayList<>();
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.haveEdge(a, this.vertices[i]))
            {
                vertices.add(this.vertices[i]);    
            }
        }
        return vertices;    
    }
    
    
    public boolean hasCycle()
    {
        return this.hasCycle(this.vertices[0]);
        
    }
    
    private boolean hasCycle(Vertex u)  // for DAG
    { 
        if(u.isVisited)
            return true;
        u.isVisited = true;
        for(Vertex v:this.getAdjacentVertices(u))
            return hasCycle(v);
        return false;  
    }
    
    public void topological_sort()  // only applicable for DAG == Directed acyclick graph
    {
        this.topo(this.vertices[0]);
        while(!this.stack.isEmpty())
        {
            System.out.println(stack.pop().name);
        }
    }
    
    private void topo(Vertex u)
    {
        if(u != null && u.isVisited == false)
        {
            u.isVisited = true;
            for(Vertex v:this.getAdjacentVertices(u))
            {
                topo(v);
            }
            stack.push(u);
        }
    }
    
}
