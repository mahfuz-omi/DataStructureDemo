/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class ConvexHullPoint implements Comparable<ConvexHullPoint> {
    public int x;
    public int y;
    public double angle;

    public ConvexHullPoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 0.0;
    }
    
    

    @Override
    public int compareTo(ConvexHullPoint o) {
        return (int)(100*(this.angle-o.angle)); // for increasing order
    }
    
    
    
}
