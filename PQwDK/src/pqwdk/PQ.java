/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqwdk;

import java.util.PriorityQueue;

/**
 *
 * @author user
 * @param <E>
 */
public class PQ<E> extends PriorityQueue<E>{
    public boolean decreaseKey(E e){
        int i = super.indexOf(e);
        if (i == -1)
            return false;
        else {
            super.removeAt(i);
            return true;

        }
    }
    
}
