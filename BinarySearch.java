/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.BinaryNode;
import java.util.Arrays;

/**
 *
 * @author omi
 */
public class BinarySearch {
    
    public int[] data;
    public int n;
    
    
    public BinarySearch(int[] data)
    {
        this.n = data.length;
        this.data = data;
        this.sort();
    }
    
    public void binarySearch(int searchKey)
    {
        int lower = 0;
        int higher = n - 1;
        while(true)
        {
            int mid = (higher + lower)/2;
            if(data[mid] == searchKey)
            {
                System.out.println("found");
                System.out.println("searchKey is in: "+mid+" index");
                return;
                
            }
            else if(lower > higher)
            {
                System.out.println("not found");
                return;    
            }
            else
            {
                if(searchKey < data[mid])
                    higher = mid - 1;
                else
                    lower = mid + 1;
            }
        }
        
    }
    
    
    public void sort()
    {
        Arrays.sort(this.data);
           
    }
    
    public void print()
    {
        for(int i:data)
        {
            System.out.println(i);
        }
    }
    
    public void bubbleSort()
    {
        for(int i=1;i<=n-1;i++)
        {
            for(int j=0;j<n-i;j++)
            {
                if(data[j] > data[j+1])
                {
                    int temp;
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
                
            }
        }
    }
    
    public void selectionSort()
    {
        int min;
        int j;
        
        for(int i=0;i<n-1;i++)
        {
            min = i;
            for(j=i+1;j<n;j++)
            {
                if(data[min] > data[j])
                    min = j;
            }
            int temp;
            temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
        
    }
    
    
    public BinaryNode createBSTFromArray(int start,int end)
    {
        if (start > end) 
        {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode(this.data[mid]);
        node.left = createBSTFromArray(start, mid - 1);
        node.right = createBSTFromArray(mid + 1, end); 
        return node;   
    }
    
}
