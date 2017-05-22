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
public class Recursion {
    
    public void descending(int n)
    {
        if(n == 0)
            return;
        System.out.println(n+" ");
        descending(n-1);    
    }
    
    public void ascending(int n)
    {
        if(n == 0)
            return;
        ascending(n-1);
        System.out.println(n+" ");    
    }
    
}
