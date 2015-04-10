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

/**
 * FiniteBag represents a polymorphic multiset
 * @param <T> The generic datatype that the FiniteBag will hold.
 */
public interface FiniteBag<T extends Comparable<T>> {
    
    public String toString();
    
    /**
     * @return boolean if the bag is empty
     */
    public boolean isEmptyHuh();
    
    /** 
     * @return integer that represents the number of elements in the bag
     */
    public int cardinality();   
    
    /** 
     * @param thing is the key you are getting the multiplicity of
     * @return integer that represents the multiplicity of the key
     */
    public int getMult(T thing);
    /**
     * @return a fresh empty bag
     */
    public FiniteBag<T> empty();
    
    /**
     * @param thing the element T that is being tested
     * @return boolean if thing is in the bag
     */
    public boolean member(T thing);
    
    /**
     * @param thing the element T that is being added
     * @return new bag with thing added once
     */  
    public FiniteBag<T> add(T thing);
    
    /**
     * @param thing the element T that is being added
     * @param n multiplicity of added number
     * @return new bag with thing added once
     */      
    public FiniteBag<T> add(T thing, int n);
    
    /**
     * @param thing the element T that is being removed
     * @return new bag with thing removed once
     */
    public FiniteBag<T> remove(T thing);    
       
    /**
     * @param thing the element T that is being removed
     * @param n multiplicity of added number
     * @return new bag with thing removed once
     */
    public FiniteBag<T> remove(T thing, int n);   
            
    /**
     * @param otherBag the FiniteBag that is being united
     * @return a new bag that is the union of bag and this
     */         
    public FiniteBag<T> union (FiniteBag<T> otherBag);
    
    /**
     * @param otherBag the FiniteBag that is being intersected
     * @return a new bag that is the intersection of bag and this
     */  
    public FiniteBag<T> inter (FiniteBag<T> otherBag);
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return a new bag that is the difference of bag and this
     */  
    public FiniteBag<T> diff (FiniteBag<T> otherBag);
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return a boolean if bag and this are equal
     */  
    public boolean equal (FiniteBag<T> otherBag);
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return a boolean if bag is a subset of this
     */  
    public boolean subset (FiniteBag<T> otherBag);
}
