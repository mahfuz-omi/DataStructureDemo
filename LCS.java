/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class LCS {
    
    private String firstString;
    private String secondString;
    
    private String answerLCS = "";

    public LCS(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }
    
    
    public int lcs()
    {
        return this.lcs(0,0);
    }
    
    
    private int lcs(int i,int j)
    {
        if(i >= firstString.length() || j >=secondString.length())
            return 0;   // base case
            
        if(this.firstString.charAt(i) == this.secondString.charAt(j))
        {
            //System.out.println(firstString.charAt(i));
            return 1 + lcs(i+1,j+1);
        }
        else
        {
            return max(lcs(i,j+1),lcs(i+1,j));
        }
        
    }
    
    public void printLCS()
    {
        this.printLCS(0,0);
    }
    
    private void printLCS(int i,int j)
    {
        if(i >= firstString.length() || j >=secondString.length())
        {
            System.out.println(answerLCS);
            return;
        }
        if(this.firstString.charAt(i) == this.secondString.charAt(j))
        {
            //System.out.println(firstString.charAt(i));
            answerLCS = answerLCS + firstString.charAt(i);
            printLCS(i+1,j+1);
        }
        else
        {
            if( (lcs(i,j+1)) > lcs(i+1,j))
            {
                printLCS(i, j+1);    
            }
            else
            {
                printLCS(i+1, j);
            }
        }
        
    }
    
    private int max(int a,int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    
    
    
}
