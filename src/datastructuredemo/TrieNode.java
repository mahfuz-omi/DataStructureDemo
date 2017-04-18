/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;


/**
 *
 * @author omi
 */
public class TrieNode {
    
    public char data;
    public TrieNode[] next;
    public boolean isEnd;
    public int nextIn;

    public TrieNode() {
        this.data = 0;
        this.next = new TrieNode[26];
        this.isEnd = false;
        this.nextIn = 0;
    }
    
    
    
    
    
    
    
    
    
    
}
