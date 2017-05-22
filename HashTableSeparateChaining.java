/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.Link;
import datastructuredemo.home_not_updated.LinkList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omi
 */
public class HashTableSeparateChaining {
    
    private LinkList []datas; // array of generic type cant be created
    private int numOfData;
    
    public HashTableSeparateChaining(int numOfData)
    {
        datas = new LinkList[numOfData];
        this.numOfData = numOfData;
    }
    
    public void put(Link link)
    {
        String key = String.valueOf(link.data);
        int arrayIndex = this.hash(key) % this.numOfData;
        if(this.datas[arrayIndex] == null)
            this.datas[arrayIndex] = new LinkList();
        this.datas[arrayIndex].addElement(link.data);
               
    }
    
    private int hash(String key)
    {
        int hashing = 0;
        
        for(int i=0;i<key.length();i++)
        {
            int ascii = (int) key.charAt(i);
            hashing += ascii;
            
        }
        return hashing;
    }
    
    public Link get(int data)
    {
        String key = String.valueOf(data);
        int arrayIndex = this.hash(key) % this.numOfData;
        LinkList list = this.datas[arrayIndex];
        if(list == null)
            return null;
        Link current = list.getFirstLink();
        while(current != null)
        {
            if(current.data == data)
                return current;
            current = current.next;
            
        }
        return null;
        
    }
    
    
    
    
    
}
