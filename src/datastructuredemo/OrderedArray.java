/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class OrderedArray {
    
    private int [] data;
    private int numElements;

    public OrderedArray(int size) {
        this.data = new int[size];
        this.numElements = 0;
    }
    
    
    public void insert(int element)
    {
        int i;
        for(i=0;i<numElements;i++)
        {
            if(data[i] > element)
                break;
        }
        for(int j=numElements-1;j>=i;j--)
        {
            data[j+1] = data[j];
            
        }
        data[i] = element;
        this.numElements++;
        
        
    }
    
    public void print()
    {
        for(int i:data)
        {
            System.out.println(i);
        }
    }
    
    public void delete(int element)
    {
        int i;
        for(i=0;i<=numElements-1;i++)
        {
            if(data[i] == element)
                break;
            
        }
        
        for(int j=i+1;j<=numElements;j++)
        {
            data[j-1] = data[j];
        }
    }
    
    
    
}
