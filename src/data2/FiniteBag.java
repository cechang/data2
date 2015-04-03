/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data2;

/**
 *
 * @author Cedric
 */
public interface FiniteBag<T extends Comparable<T>> extends Iterable<T> {
    
    public String toString();
    
    public boolean isEmptyHuh(T thing);
    
    public int cardinality(T thing);
    
    public FiniteBag<T> empty();
    
    public boolean member(T thing);
    
    public FiniteBag<T> add(T thing);
    
    public FiniteBag<T> remove(T thing);
    
    public FiniteBag<T> union (FiniteBag<T> bag);
    
    public FiniteBag<T> inter (FiniteBag<T> bag);
    
    public FiniteBag<T> diff (FiniteBag<T> bag);
    
    public boolean equal (FiniteBag<T> bag);
    
    public boolean subset (FiniteBag<T> bag);
}
