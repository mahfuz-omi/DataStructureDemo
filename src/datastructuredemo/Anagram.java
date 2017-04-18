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
public class Anagram {
    static int count = 1;
    
    public static void doAnagram(String prefix,String word)        
    {
        
        if(word.length() <= 1)
        {
            System.out.println(count+":"+prefix+word);
            count++;
            return;
        }
        for(int i = 0; i < word.length(); i++) 
        {
            String cur = word.substring(i, i + 1);
            String before = word.substring(0, i); // letters before cur
            String after = word.substring(i + 1); // letters after cur
            doAnagram(prefix + cur, before + after);
        }
            
    }
                
}
