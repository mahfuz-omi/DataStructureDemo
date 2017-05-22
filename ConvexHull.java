/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.ConvexHullPoint;
import datastructuredemo.home_not_updated.GenericLinkListStack;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omi
 */
public class ConvexHull {
    
    private ArrayList<ConvexHullPoint> points;
    
    public ConvexHull(ArrayList<ConvexHullPoint> points)
    {
        this.points = points;
    }
    
    
    
    
    private int getOrientation(ConvexHullPoint p, ConvexHullPoint q, ConvexHullPoint r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // colinear
        return (val > 0)? 1: 2; // clock or counterclock wise
        // 2 holei left turn hobe
    }
    
    public void getHull()
    {
        ConvexHullPoint minimumY = this.points.get(0);
        
        for(int i=1;i<this.points.size();i++)
        {
            if(points.get(i).y < minimumY.y)
            {
                minimumY = points.get(i);
                
            }
        }
        points.remove(minimumY);
        
        for(int i=0;i<points.size();i++)
        {
            points.get(i).angle = this.getAngle(minimumY, points.get(i));
        }
        
        Collections.sort(points);
        System.out.println("minimum: "+minimumY.x+":"+minimumY.y+":"+minimumY.angle);
        
        for(int i=0;i<points.size();i++)
        {
            System.out.println(points.get(i).x+":"+points.get(i).y+":"+points.get(i).angle);
        }
        
        GenericLinkListStack<ConvexHullPoint> stack = new GenericLinkListStack<>();
        
        stack.push(minimumY);
        stack.push(points.get(0));
        stack.push(points.get(1));
        
        points.remove(points.get(0));
        points.remove(points.get(1));
        
        for(int i=0;i<points.size();i++)
        {
            //ConvexHullPoint next_to_top = stack.next_to_top();
            //ConvexHullPoint top = stack.top();
            while(this.getOrientation(stack.next_to_top(), stack.top(), points.get(i)) != 2)
            {
                stack.pop();  
            }
            stack.push(points.get(i));
            
        }
        
        System.out.println("all hull points: ");
        
        while (!stack.isEmpty())
        {
            ConvexHullPoint point = stack.pop();
            System.out.println(point.x+":"+point.y);    
        }
            
    }
    
    
    
    private double getAngle(ConvexHullPoint source,ConvexHullPoint dest)
    {
        double dy = dest.y-source.y;
        double dx = dest.x-source.x;
        return Math.atan2(dy, dx);  
    }
    
    
    
    
    
}
