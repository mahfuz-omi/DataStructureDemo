/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import datastructuredemo.home_not_updated.TrieNode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author omi
 */
public class Trie {
    
    private TrieNode root;
    
    public Trie()
    {
        this.root = new TrieNode();
    }
    
    public Trie(TrieNode root)
    {
        this.root = root;
    }
    
    
    public void addWord(String word)
    {
        int length = word.length();
        TrieNode temp = this.root;
        for(int i=0;i<length;i++)
        {
            char data = word.charAt(i);
            if(this.findPosition(temp, data) == -1)
            {
                temp.next[temp.nextIn] = new TrieNode();
                TrieNode temp2 = temp.next[temp.nextIn];
                temp2.data = data;
                temp.nextIn++;
                temp = temp2;     
            }
            else
            {
                int k = findPosition(temp, data);
                temp = temp.next[k];    
            }    
        }
        temp.isEnd = true;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hBuilder = new HashCodeBuilder();
        hBuilder.append(root);
        return hBuilder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Trie that = (Trie)obj;
        EqualsBuilder eBuilder = new EqualsBuilder();
        eBuilder.append(root,that );
        return eBuilder.isEquals();
    }
    
    
    
    
    
    
    private int findPosition(TrieNode node,char data)
    {
        if(node == null)
            return -1;
        for(int i=0;i<node.nextIn;i++)
        {
            if(node.next[i].data == data)
                return i;
        }
        return -1;
    }
    
    public boolean isExists(String word)
    {
        int length = word.length();
        TrieNode temp = this.root;
        for(int i=0;i<length;i++)
        {
            char data = word.charAt(i);
            if(this.findPosition(temp, data)== -1)
            {
                return false;    
            }
            else
            {
                int k = findPosition(temp, data);
                temp = temp.next[k];    
            }    
        }
        if(temp.isEnd == true)
            return true;
        else
            return false;
    }
    
    
    
    
    
    
    
    
}
