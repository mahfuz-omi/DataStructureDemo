/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class StringMatching {
    
    public String text;
    public String pattern;
    public int text_length;
    public int pattern_length;
    

    public StringMatching(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.text_length = text.length();
        this.pattern_length = pattern.length();
    }
    
    public boolean isMatch()
    {
        return this.isMatch(0,0);
        
    }
    
    // substring == fully match==pattern recognition
    
    private boolean isMatch(int i,int j) // i = current index of text, j= current index of pattern
    {
        if(j >= pattern_length)
            return true;
        else
        {
            if(i >= text_length)
                return false;
        }
        
        if(text.charAt(i) != pattern.charAt(j))
        {
            if(j == 0)
                return isMatch(i+1, j);
            else
                return isMatch(i, j-1);       
        }    
        else
            return isMatch(i+1,j+1);
    }
    
}
