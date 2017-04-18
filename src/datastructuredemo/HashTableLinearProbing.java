/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

/**
 *
 * @author omi
 */
public class HashTableLinearProbing {
    private HashData[] datas;// jotogulo value rakhte chai...ei array ta tar double hobe.....
    private int numOfData;

    public HashTableLinearProbing() {
        this.datas = null;
        this.numOfData = 0;
    }

    public HashTableLinearProbing(HashData[] datas) {
        this.datas = datas;
        this.numOfData = datas.length;
    }
    
    public HashTableLinearProbing(int number) {
        this.datas = new HashData[number];
        this.numOfData = number;
        
    }
    
    public void put(HashData data)
    {
        String key = data.name;
        int arrayIndex = this.hash(key) % this.numOfData; 
        while(this.datas[arrayIndex] != null)
        {
            arrayIndex++;
            arrayIndex %= this.numOfData;
            
        }
        this.datas[arrayIndex] = data;
        
    }
    
    
    public HashData get(String key)
    {
        int arrayIndex = this.hash(key) % this.numOfData;
        while(this.datas[arrayIndex] != null)
        {
            if(this.datas[arrayIndex].name.equals(key))
            {
                return this.datas[arrayIndex];    
            }
            arrayIndex++;
            arrayIndex %= this.numOfData;
        }
        return null;
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
    
    
}
