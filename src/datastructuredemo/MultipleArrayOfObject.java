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
public class MultipleArrayOfObject {
    public int data;
    public String name;
    public MultipleArrayOfObject next;

    public MultipleArrayOfObject() {
        this.data = 0;
        this.name="";
        this.next = null;
    }

    public MultipleArrayOfObject(int data, String name) {
        this.data = data;
        this.name = name;
    }
    
    
    
}
