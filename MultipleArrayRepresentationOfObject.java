/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.MultipleArrayOfObject;
import java.util.List;

/**
 *
 * @author omi
 */
public class MultipleArrayRepresentationOfObject {
    
    List<MultipleArrayOfObject> objects;

    public MultipleArrayRepresentationOfObject(List<MultipleArrayOfObject> objects) {
        this.objects = objects;
    }
    
    
    public void getArrayRepresentation()
    {
        MultipleArrayOfObject [] nexts;
        int [] datas;
        String []names;
        
        nexts = new MultipleArrayOfObject[this.objects.size()];
        datas = new int[this.objects.size()];
        names = new String[this.objects.size()];
        
        int i = 0;
        for(MultipleArrayOfObject object:objects)
        {
            datas[i] = object.data;
            names[i] = object.name;
            nexts[i] = object.next;
            i++;  
        }
        
        for(int j=0;j<nexts.length;j++)
        {
            System.out.println(datas[j]);
            System.out.println(names[j]);
            System.out.println(nexts[j]);
            
        }
        
    }
    
    public void print()
    {
        for(MultipleArrayOfObject object:this.objects)
        {
            System.out.println(object.data);
            System.out.println(object.name);
            System.out.println(object.next);
        }
    }
    
    
    
    
    
}
