/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.Arrays;

/**
 *
 * @author omi
 */
public class ArrayForBST {
    
    private int[] data;
    private int size;
    
    public ArrayForBST(int []data)
    {
        this.data = data;
        this.size = data.length;
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public ArrayForBST getLeft()
    {
        int mid = this.size/2;
        int []data = Arrays.copyOfRange(this.data, 0, mid);
        return new ArrayForBST(data);   
    }
    
    public ArrayForBST getRight()
    {
        int mid = this.size/2;
        int []data = Arrays.copyOfRange(this.data, mid, this.size);
        return new ArrayForBST(data);   
    }
    
    public int getMiddleData()
    {
        int mid = this.size/2;
        return this.data[mid];
    }
    
}
