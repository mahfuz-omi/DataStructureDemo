/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class ExpressionNode {
    
    public int value;
    public String data; // * / + - or a,b etc
    public boolean isInternal; // for data a,b 
    // for internal...null if external
    public ExpressionNode left;
    public ExpressionNode right;
    
    public int getValue()
    {
        if(data.equals("*"))
            return left.getValue()*right.getValue();
        else if(data.equals("/"))
            return left.getValue()/right.getValue();
        else if(data.equals("+"))
            return left.getValue()+right.getValue();
        else if(data.equals("-"))
            return left.getValue()-right.getValue();
        else
            return value;
    }
    
    
    

    
    
    
}
