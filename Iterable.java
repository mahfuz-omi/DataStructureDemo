/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import datastructuredemo.home_not_updated.Iterator;

/**
 *
 * @author omi
 */
public interface Iterable<T> {
    
    Iterator<T> getIterator();
    
}
