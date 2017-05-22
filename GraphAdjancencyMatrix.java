/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.GenericLinkListQueue;
import datastructuredemo.home_not_updated.Vertex;
import java.util.ArrayList;


/**
 *
 * @author omi
 */
public class GraphAdjancencyMatrix {
    private Vertex [] vertices;
    private int current;
    private int [][] edgesArray;
    
    public GraphAdjancencyMatrix(int numOfVertices)
    {
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
    
    public void addEdge(Vertex a,Vertex b)
    {
        int aPosition = 0,bPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i] == a)
                aPosition = i;
            if(this.vertices[i] == b)
                bPosition = i;
            
        }
        this.edgesArray[aPosition][bPosition] = 1;
        this.edgesArray[bPosition][aPosition] = 1;
    }
    
    public void addEdge(Vertex a,Vertex b,int weight)
    {
        int aPosition = 0,bPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i] == a)
                aPosition = i;
            if(this.vertices[i] == b)
                bPosition = i;
            
        }
        this.edgesArray[aPosition][bPosition] = weight;
        this.edgesArray[bPosition][aPosition] = weight;
    }
    
    
    
    public void addEdge(String a,String b)
    {
        int aPosition = 0,bPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i].name.equalsIgnoreCase(a))
                aPosition = i;
            if(this.vertices[i].name.equalsIgnoreCase(b))
                bPosition = i;
            
        }
        this.edgesArray[aPosition][bPosition] = 1;
        this.edgesArray[bPosition][aPosition] = 1;
        
    }
    
    public void addEdge(String a,String b,int weight)
    {
        int aPosition = 0,bPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i].name.equalsIgnoreCase(a))
                aPosition = i;
            if(this.vertices[i].name.equalsIgnoreCase(b))
                bPosition = i;
            
        }
        this.edgesArray[aPosition][bPosition] = weight;
        this.edgesArray[bPosition][aPosition] = weight;
        
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
    
    public boolean haveEdge(Vertex a,Vertex b)
    {
        int aPosition = 0,bPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i] == a)
                aPosition = i;
            if(this.vertices[i] == b)
                bPosition = i;
            
        }
        if(this.edgesArray[aPosition][bPosition] != 0)
            return true;
        else
            return false;
     
    }
    
    public boolean haveEdge(String a,String b)
    {
        int aPosition = 0,bPosition = 0;
        for(int i=0;i<this.vertices.length;i++)
        {
            if(this.vertices[i].name.equalsIgnoreCase(a))
                aPosition = i;
            if(this.vertices[i].name.equalsIgnoreCase(b))
                bPosition = i;
            
        }
        if(this.edgesArray[aPosition][bPosition] != 0)
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
    
    
    public void DFS_Travers()
    {
        this.preOrder(this.vertices[0]);
    }
    
    
    private void preOrder(Vertex a)
    {
        if(a != null)
        {
            System.out.println(a.name+" ");
            a.isVisited = true; // stackoverflow exception
            for(Vertex v:this.getAdjacentVertices(a))
            {
                if(v.isVisited == false)
                    preOrder(v);
            }
        }
    }
    
    
    public void BFS_Travers()
    {
        this.bfs(this.vertices[0]);
    }
    
    
    public void bfs(Vertex a)
    {
        GenericLinkListQueue<Vertex> q = new GenericLinkListQueue<>();
        q.push(a);
        while(!q.isEmpty())
        {
            Vertex u = q.pop();
            System.out.println(u.name+" ");
            u.isVisited = true;
            for(Vertex v:this.getAdjacentVertices(u))
            {
                if(v != null && v.isVisited == false)
                    q.push(v);
            }
        }
    }
    
    public void MST_UNWEIGHTED()
    {
        this.mst_unweighted(this.vertices[0]);
    }
    
    public void MST_WEIGHTED()
    {
        for(Vertex v:vertices)
        {
            v.isVisited = false;
        }
        this.mst_weighted(this.vertices[0]);
    }
    
    private void mst_weighted(Vertex parent)
    {
        if(parent != null)
        {
            GenericLinkListQueue<Vertex> queue = new GenericLinkListQueue<>();
            
            //GrapfAdjacencyMatrixWeighted e kora ache... :)
            
            
        }
        
    }
    
    
    
    private void mst_unweighted(Vertex parent) /// just like dfs....only to remember the parent or path
    {
        if(parent != null)
        {
            parent.isVisited = true; // stackoverflow exception safety
            for(Vertex v:this.getAdjacentVertices(parent))
            {
                if(v.isVisited == false)
                {
                    System.out.println(parent.name+"-"+v.name);
                    mst_unweighted(v);
                }
                    
            }
        }   
    }
    
   
      
}

