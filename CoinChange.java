/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omi
 */
public class CoinChange 
{
    public int target;
    
    public int []A = {1,3,5,7,9,13,17};
    public int make;
    
    
    public CoinChange(int target)
    {
        this.target = target;
        this.make = target;
    }
    
    public void doChange(List<Integer> prefix,List<Integer> coins)
    {

    }
    
    public void canBeMade()
    {
        this.canBeMade(0,0);
    }
    
    private void canBeMade(int i,int amount)
    {
        if(amount == make)
        {
            //System.out.println("possible");
            System.out.print("i = "+i);
            return;
        }
        if(i == 5)
        {
            //System.out.println("not possible");
            return;
        }
        canBeMade(i+1, amount+A[i]);
        canBeMade(i+1, amount);      
    }
    
    
    private void getCombinationOfCoins(int index,List<Integer> taken)
    {
        //System.out.println(index+":"+taken.toString());
        
        int sum = 0;
        for(Integer i:taken)
        {
            int in = i.intValue();
            sum = sum + in;
        }
        if(sum == make)
        {
            //System.out.println("possible");
            for(Integer i:taken)
            {
                System.out.print(i+" ");
            }
            System.out.println("");
            return;
            
        }
        
        if(index == 7) // length of A
        {
            return;
        }
        
        
        //brut force all possible combination
       
        taken.add(A[index]);
        getCombinationOfCoins(index+1,taken ); // take this coin 
              
        taken.remove(taken.size()-1);
        getCombinationOfCoins(index+1, taken);  //don't take this coin
            
    }
    
    public void getCombinationOfCoins()
    {
        List<Integer> list = new ArrayList<>();
        this.getCombinationOfCoins(0,list );
    }
    
    
       
   
    
}
