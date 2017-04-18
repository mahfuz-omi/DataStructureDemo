/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omi
 */
public class GraphAdjacencyMatrixWeighted {
    
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
  
    public GraphAdjacencyMatrixWeighted()
    {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }
    
    public int getVerticesCount()
    {
        return this.vertices.size();
    }
    
    public int getEdgesCount()
    {
        return this.edges.size();
    }
    
    public void addVertex(Vertex vertex)
    {
        this.vertices.add(vertex);
    }
    
    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
    }
    
    public List<Edge> mst()
    {
        return this.mst(this.vertices.get(0));
    }
    
    
    public List<Edge> mst(Vertex v)
    {
        List<Edge> mstEdges = new ArrayList<>();
        for(Vertex u:this.vertices)
        {
            u.isVisited = false;
        }
        GenericPriorityQueue pQueue = new GenericPriorityQueue();
        for(Edge edge:this.edges)
        {
            pQueue.push(edge);
        }
        
        while(!isEveryVertexCovered())
        {
            Edge edge = pQueue.pop();
            if(doesThisEdgeCovereAnyNewVertex(edge))
            {
                mstEdges.add(edge);
                edge.v1.isVisited = true;
                edge.v2.isVisited = true;
            }  
        }
        
        return mstEdges;  
    }
    
    private boolean isEveryVertexCovered()
    {
        for(Vertex v:this.vertices)
        {
            if(v.isVisited == false)
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean doesThisEdgeCovereAnyNewVertex(Edge edge)
    {
        for(Vertex v:this.vertices)
        {
            if(v.isVisited == false)
            {
                if(v == edge.v1 || v == edge.v2)
                {
                    return true;
                }
            }
        }
        return false;  
    }
    
    
    
    public boolean haveEdge(Vertex a,Vertex b)
    {
        for(Edge edge:this.edges)
        {
            if((edge.v1 == a && edge.v2 == b)||(edge.v1 == b && edge.v2 == a))
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    public ArrayList<Vertex> getAdjacentVertices(Vertex a)
    {
        ArrayList<Vertex> vertices = new ArrayList<>();
        for(Vertex v:this.vertices)
        {
            if(this.haveEdge(a, v))
            {
                vertices.add(v);
            }
        }
        return vertices;    
    }
    
    
    
    private Edge getEdge(Vertex a,Vertex b)
    {
        if(!this.haveEdge(a, b))
            return null;
        for(Edge edge:this.edges)
        {
            if((edge.v1 == a && edge.v2 == b) || (edge.v1 == b && edge.v2 == a))
                return edge;
        }
        return null;
    }
    
    public void dijkstra(Vertex source)   // all pair shortest path
    {
        for(Vertex v:this.vertices)
        {
            v.distanceFromSource = -1;
        }
        ArrayList<Vertex> solved = new ArrayList<>();
        ArrayList<Vertex> unSolved = new ArrayList<>();
        for(Vertex v:this.vertices)
        {
            unSolved.add(v);
        }
        source.distanceFromSource = 0;
        solved.add(source);
        unSolved.remove(source);
        PriorityQueueForVertex pQueue = new PriorityQueueForVertex();
        while(solved.size() != vertices.size())
        {
            for(Vertex u:solved)
            {
                for(Vertex v:unSolved)
                {
                    if(this.haveEdge(u, v))
                    {
                        if(v.distanceFromSource == -1 ||( v.distanceFromSource > u.distanceFromSource + this.getEdge(u, v).weight))
                        {
                            v.distanceFromSource = u.distanceFromSource + this.getEdge(u, v).weight;
                        }
                        pQueue.push(v);
                    }
                }
                   
            }
            Vertex newSolved = pQueue.pop();
            solved.add(newSolved);
            unSolved.remove(newSolved);
            pQueue.clear();
        }
        
        for(Vertex v:solved)
        {
            System.out.println(v.name+" :"+v.distanceFromSource);
        }
        
        
        
    }
    
    
    public void printGraph()
    {
        for(Vertex u:this.vertices)
        {
            System.out.println(u.name+": "+u.distanceFromSource);
            for(Vertex v:this.vertices)
            {
                if(this.haveEdge(u, v))
                {
                    System.out.print("**********   "+v.name+": "+v.distanceFromSource);
                    Edge edge = this.getEdge(u, v);
                    //System.out.print(edge.weight+" ");    
                }
                System.out.println("");
            }
        }
    }
    
    
    
    
}
