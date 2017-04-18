/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import java.util.Random;

/**
 *
 * @author omi
 */
public class QuickSort {
    
    private int []data;
    private int count;
    
    public QuickSort(int []data)
    {
        this.data = data;
        this.count = this.data.length;
    }
    
    
    private int partition(int first,int last)
    {
        int firstData = this.data[first];
        int i = first;
        int j = last;
        while(true)
        {
            while(this.data[j] > firstData)
                j--;
            while(this.data[i] < firstData)
                i++;
            if(i< j)
                swap(i,j);
            else
                return j;     
        }  
    }
    
    private void sort(int i,int f)
    {
        if(i < f)
        {
            int q = this.partition(i,f);
            sort(i,q);
            sort(q+1,f);
        }   
    }
    
    public void sort()
    {
        this.sort(0,this.count-1);
    }
    
    
    private void swap(int a,int b)
    {
        int temp;
        temp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = temp;    
    }
    
    
    //************************************* Randomized Sort******************************
    
    
    public void randomized_sort()
    {
        this.randomized_sort(0,this.data.length-1);
    }
    
    
    private void randomized_sort(int i,int f)
    {
        if(i < f)
        {
            int q = this.randomized_partition(i,f);
            randomized_sort(i,q);
            randomized_sort(q+1,f);
        }   
    }
    
    private int randomized_partition(int first,int last)
    {
        Random ran = new Random();
        int q = ran.nextInt(last-first+1) + first;
        swap(first,q);
        return this.partition(first, last);
        
    }
    
}
