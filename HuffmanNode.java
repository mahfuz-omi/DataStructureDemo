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
public class HuffmanNode {
    
    public char ch;
    public int frequency;
    public HuffmanNode left;
    public HuffmanNode right;
    
    public HuffmanNode(char ch,int frequency)
    {
        this.ch = ch;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
    
    public HuffmanNode()
    {
        this.ch ='0';
        this.frequency = 0;
        this.left = null;
        this.right = null;
    }
    
    
}
