/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.GenericLinkListStack;

/**
 *
 * @author omi
 */
public class ExpressionTree {
    
    private ExpressionNode root;
    private int value;
    
    
    public int getValue()
    {
        return this.root.getValue();
    }
    
    
   
    
    
    public void showTree()
    {
        this.showTree(this.root);
    }
    
    private void showTree(ExpressionNode root)
    {
        if(root != null)
        {
            System.out.println(root.data);
            //System.out.println(root.getValue());
            showTree(root.left);
            showTree(root.right);
        }
    }
    
    
    public void buildExpressionTreeFromInfix(String expression)
    {
        // expression is infix notation....so fully parenthesized
        // we can convert infix to prefix or postfix from that
        GenericLinkListStack<ExpressionNode> stack = new GenericLinkListStack<>();
        for(int i=0;i<expression.length();i++)
        {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch))
            {
                // is a variable...push it
                ExpressionNode node = new ExpressionNode();
                node.data = String.valueOf(ch);
                node.isInternal = false; // it must be external node
                node.left = node.right = null;  // as it is external node...means leaf node
                node.value = Integer.parseInt(String.valueOf(ch));
                
                stack.push(node);
            }
            else if(ch == '*' || ch == '/' || ch == '+' || ch == '-')
            {
                // it is operator
                ExpressionNode node = new ExpressionNode();
                node.data = String.valueOf(ch);
                node.isInternal = true; // it must be internal node
                //ekhane value set kora hobe na....
                
                stack.push(node);
     
            }
            else if(ch == ')')
            {
                ExpressionNode right = stack.pop();
                ExpressionNode root = stack.pop();
                ExpressionNode left = stack.pop();
                
                root.left = left;
                root.right = right;
                stack.push(root);
            }
        }
        
        this.root = stack.pop();
        
        
        
    }
    
    //only infix e parenthesis thakte hobe...onnogulote noy !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    
    
    public void buildExpressionTreeFromPostfix(String expression)
    {
        // expression is postfix notation....so no parenthesized
        // we can convert infix to prefix or postfix from that
        GenericLinkListStack<ExpressionNode> stack = new GenericLinkListStack<>();
        for(int i=0;i<expression.length();i++)
        {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch))
            {
                ExpressionNode node = new ExpressionNode();
                node.data = String.valueOf(ch);
                node.isInternal = false; // it must be external node
                node.left = node.right = null;  // as it is external node...means leaf node
                node.value = Integer.parseInt(String.valueOf(ch));
                
                stack.push(node);
            }
            
            if(ch == '*' || ch == '/' || ch == '+' || ch == '-')
            {
                ExpressionNode right = stack.pop();
                ExpressionNode left = stack.pop();
                // it is operator
                ExpressionNode node = new ExpressionNode();
                node.data = String.valueOf(ch);
                node.isInternal = true; // it must be internal node
                //ekhane value set kora hobe na....
                node.left = left;
                node.right = right;
                stack.push(node);
            }
            
        }
        
        this.root = stack.pop();
        
        
        
    }
    
    
    
}
