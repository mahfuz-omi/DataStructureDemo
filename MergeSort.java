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
public class MergeSort {
    
    public int [] data;
    
    public MergeSort(int []data)
    {
        this.data = data;
    }
    
    
    public int[] mergeSort()
    {
        return this.mergeSort(this.data);   
    }
    
    
    private int [] mergeSort(int []data)
    {
        if(data.length == 1)
            return data;
        int n = data.length/2;
        
        int []array1 = Arrays.copyOfRange(data, 0, n);
        int []array2 = Arrays.copyOfRange(data, n, data.length);
        
        array1 = mergeSort(array1);
        array2 = mergeSort(array2);
        
        int []array3 = merge(array1,array2);
        return array3;        
    }
    
    private int [] merge(int []array1,int []array2)
    {
        int []result = new int[array1.length + array2.length];
        
        int k = 0;
        int i = 0;
        int j = 0;
        
        while(i < array1.length && j < array2.length)
        {
            if(array1[i] <= array2[j])
            {
                result[k] = array1[i];
                i++;
                k++;   
            }
            else
            {
                result[k] = array2[j];
                j++;
                k++;
            }
        }
        while(i < array1.length)
        {
            result[k] = array1[i];
            i++;
            k++;   
        }
        while(j < array2.length)
        {
            result[k] = array2[j];
            j++;
            k++;   
        }
        
        return result;
        
    }
    
}
