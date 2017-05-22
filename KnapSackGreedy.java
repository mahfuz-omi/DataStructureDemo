/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.ItemForKnapSack;
import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author omi
 */
public class KnapSackGreedy {
    // 0-1 knapsack doesn't altime provide optimalsolution....but fractional do.
    //So, hereis only the fractional knapsack 
    
    ArrayList<ItemForKnapSack> lists;
    public int sackSize;

    public KnapSackGreedy(ArrayList<ItemForKnapSack> lists, int sackSize) {
        this.lists = lists;
        this.sackSize = sackSize;
    }
    
    
    public ArrayList<ItemForKnapSack> getOptimalResult()
    {
        Collections.sort(lists);
        ArrayList<ItemForKnapSack> optimalResult = new ArrayList<>();
        int sackFilled = 0;
        int i = 0;
        while(sackFilled < this.sackSize)
        {
            ItemForKnapSack item = lists.get(i);
            if(sackFilled + item.weight <= this.sackSize )
            {
                sackFilled = sackFilled + item.weight;
                item.takenWeight = item.weight;
                optimalResult.add(item);    
            }
            else
            {
                // that's why it is called fractional knapsack.... :)
                item.takenWeight = this.sackSize - sackFilled;
                optimalResult.add(item);
                return optimalResult;
                
            }
            i++;
        }
        return optimalResult;
    }
    
    
    
}
