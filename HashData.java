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
public class HashData {
     public String name; // this is the key
    public int income;

    public HashData() {
        this.name = null;
        this.income = 0;
    }

    public HashData(String name, int income) {
        this.name = name;
        this.income = income;
    }

    @Override
    public String toString() {
        return (this.name+this.income); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
