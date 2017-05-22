/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.PriorityQueueForVertex;
import datastructuredemo.home_not_updated.GenericPriorityQueue;
import datastructuredemo.home_not_updated.Vertex;
import datastructuredemo.home_not_updated.Edge;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omi
 */
public class GraphAdjacencyMatrixWeighted {
    
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private int time = 1;
    
    public ArrayList<Vertex> getVertices()
    {
        return this.vertices;
    }
    
    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }
  
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
    
    
    public List<Edge> mst(Vertex v) // kruskal algm
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
        
        while(!isEveryVertexCovered()) // is this edge doesn't produce cycle....
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
    
    public boolean haveEdge_directed(Vertex a,Vertex b)
    {
        for(Edge edge:this.edges)
        {
            if(edge.v1 == a && edge.v2 == b)
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
    
    public ArrayList<Vertex> getAdjacentVertices_directed(Vertex a)
    {
        ArrayList<Vertex> vertices = new ArrayList<>();
        for(Vertex v:this.vertices)
        {
            if(this.haveEdge_directed(a, v))
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
    
    
    private void initialize_vertices()
    {
        for(Vertex v:this.vertices)
        {
            v.isVisited = false;
        }
        
    }
    
    public Vertex getNextUnvisitedVertex()
    {
        for(int i=0;i<this.vertices.size();i++)
        {
            if(this.vertices.get(i).isVisited == false)
                return this.vertices.get(i);
        }
        return null;
    }
    
    
    public void getStronglyConnectedComponents()
    {
        this.initialize_vertices();
        while(!this.isEveryVertexCovered())
        {
            Vertex v = this.getNextUnvisitedVertex();
            if(v != null)
            {
                //System.out.println("next components: ");
                this.preOrder_time_directed(v);     
            }       
        }
        System.out.println("all times here:");
        for(Vertex c:this.vertices)
        {
            
            System.out.println(c.name+":"+c.startTime+":"+c.endTime);
            
        }
        System.out.println("end of time");
        //this.DFS_WITH_TIME();
        this.transposeEdges();
        PriorityQueueForVertex pQueue = new PriorityQueueForVertex();
        for(Vertex v:this.vertices)
        {
            pQueue.push(v);
        }
        this.initialize_vertices();
        while(!this.isEveryVertexCovered())
        {
            Vertex v = pQueue.getNextUnvisitedVertex();
            System.out.println("components: ");
            this.preOrder_directed(v);    
        }
        
    }
    
    
    public void transposeEdges()
    {
        for(Edge edge:this.edges)
        {
            Vertex temp;
            temp = edge.v1;
            edge.v1 = edge.v2;
            edge.v2 = temp;
        } 
    }
    
    
    
    public void printGraph()
    {
        for(Vertex u:this.vertices)
        {
            System.out.println(u.name+": "+u.distanceFromSource+u.startTime+":"+u.endTime);
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
    
    public void DFS_WITH_TIME()
    {
        this.preOrder_time(this.vertices.get(0));
    }
    public void DFS_WITHOUT_TIME()
    {
        this.preOrder(this.vertices.get(0));
    }
    
    private void preOrder(Vertex a)
    {
        if(a != null)
        {
            System.out.println(a.name+" "+a.startTime+":"+a.endTime);
            a.isVisited = true; // stackoverflow exception
            for(Vertex v:this.getAdjacentVertices(a))
            {
                if(v.isVisited == false)
                    preOrder(v);
            }
        }
    }
    
    private void preOrder_directed(Vertex a)
    {
        if(a != null)
        {
            a.isVisited = true; // stackoverflow exception
            for(Vertex v:this.getAdjacentVertices_directed(a))
            {
                if(v.isVisited == false)
                    preOrder_directed(v);
            }
            System.out.println(a.name+" :"+a.startTime+":"+a.endTime);
        }
    }
    
    private void preOrder_time(Vertex a)
    {
        if(a != null)
        {
            //System.out.println(a.name+" ");
            a.isVisited = true; // stackoverflow exception
            a.startTime = time;
            time++;
            for(Vertex v:this.getAdjacentVertices(a))
            {
                if(v.isVisited == false)
                    preOrder_time(v);
            }
            a.endTime = time;
            time++;
        }
    }
    
    private void preOrder_time_directed(Vertex a)
    {
        if(a != null)
        {
            //System.out.println(a.name+" ");
            a.isVisited = true; // stackoverflow exception
            a.startTime = time;
            time++;
            for(Vertex v:this.getAdjacentVertices_directed(a))
            {
                if(v.isVisited == false)
                    preOrder_time_directed(v);
            }
            a.endTime = time;
            time++;
        }
    }
    
    public int[][] transpose(int [][]a)
    {
        if(a == null || a.length == 0)
            return null;
        
        int row = a.length;
        int column = a[0].length;
        
        int [][] answer = new int[column][row];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                answer[j][i] = a[i][j];
            }
        }
        return answer;
    }
    
    
    
    
}
