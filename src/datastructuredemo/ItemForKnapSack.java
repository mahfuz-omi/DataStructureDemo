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
public class ItemForKnapSack implements Comparable<ItemForKnapSack>{
    
    public String itemName;
    public int weight;
    public int pricePerWeight;
    public int takenWeight;

    public ItemForKnapSack(String itemName, int weight, int pricePerWeight) {
        this.itemName = itemName;
        this.weight = weight;
        this.pricePerWeight = pricePerWeight;
        this.takenWeight = 0; // used by knapsack algm... :)
    }

    @Override
    public int compareTo(ItemForKnapSack o) {
        return o.pricePerWeight-this.pricePerWeight; // for desendant order
        
    }
    
    
    
    
}
