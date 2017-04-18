/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author omi
 */
public class ArrayStack {
    
    private int data[];
    private int top;
    
    public ArrayStack()
    {
        this.data = new int[10];
        this.top = 0;
    }
    
    public void push(int data)
    {
        this.data[top] = data;
        top++;
    }
    
    public int pop()
    {
        top--;
        return data[top];
    }
    
    public boolean isEmpty()
    {
        return (top == 0);
    }
    
}
