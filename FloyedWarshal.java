/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.GraphAdjacencyMatrixDirected;

/**
 *
 * @author omi
 */
public class FloyedWarshal {
    
    private GraphAdjacencyMatrixDirected graph;
    private int [][] allPairShortestPath;
    int dimension;
    
    
    public FloyedWarshal(GraphAdjacencyMatrixDirected graph)
    {
        this.graph = graph;
        this.allPairShortestPath = graph.getEdgesArray();
        this.dimension = this.graph.getEdgesArray().length;
        //this.allPairShortestPath = new int[dimension][dimension]; // square array it should be
        
    }
    
    public void showGraph()
    {
        System.out.println("");
        System.out.println("");
        this.graph.showGraph();
    }
    
    
    public void floyedWarshal()
    {
        
        for(int k=0;k<dimension;k++)
        {
            for(int j=0;j<dimension;j++)
            {
                for(int i=0;i<dimension;i++)
                {
                    this.allPairShortestPath[i][j] =  min(this.allPairShortestPath[i][j],(this.allPairShortestPath[i][k]+this.allPairShortestPath[k][j]));
                }
                
            }
        }
        
        
        
        
           for(int i=0;i<this.dimension;i++)
            {
                for(int j=0;j<this.dimension;j++)
                {
                    System.out.print(this.allPairShortestPath[i][j]+"                 ");
                }
                System.out.println("");
            }
        
        
        
        
           
    }
    
    public int min(int a,int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
    
    
    
    
    
    
    
    
    
}
