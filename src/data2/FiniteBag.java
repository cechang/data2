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
public interface FiniteBag<T extends Comparable<T>> extends Sequenced<T>{
    
    public String toString();
    
    /**
     * Checks to see if the bag is empty
     * @return boolean if the bag is empty
     */
    public boolean isEmptyHuh();
    
    /** 
     * Calculates the number of non-unique elements in the bag
     * @return integer that represents the number of elements in the bag
     */
    public int cardinality();   
    
    /** 
     * Gets the multiplicity of a given element
     * @param thing is the key you are getting the multiplicity of
     * @return integer that represents the multiplicity of the key
     */
    public int getMult(T thing);
    
    /**
     * Empties out the given bag
     * @return a fresh empty bag
     */
    public FiniteBag<T> empty();
    
    /**
     * Finds the height of the bag
     * @return the height of the bag
     */
    public int depth();
    
    /**
     * Gives a boolean for if a given element is contained at least once in a bag
     * @param thing the element T that is being tested
     * @return boolean if thing is in the bag
     */   
    public boolean member(T thing);
    
    /**
     * Adds an element to a bag once
     * @param thing the element T that is being added
     * @return new bag with thing added once
     */  
    public FiniteBag<T> add(T thing);
    
    /**
     * Adds an element to a bag multiple times
     * @param thing the element T that is being added
     * @param n multiplicity of added number
     * @return new bag with thing added once
     */      
    public FiniteBag<T> add(T thing, int n);
    
    /**
     * Removes one instance of the element from a bag
     * @param thing the element T that is being removed
     * @return new bag with thing removed once
     */
    public FiniteBag<T> remove(T thing);    
       
    /**
     * Removes multiple instances of an element from a bag
     * @param thing the element T that is being removed
     * @param n multiplicity of added number
     * @return new bag with thing removed once
     */
    public FiniteBag<T> remove(T thing, int n);   
            
    /**
     * Combines two bags together
     * @param otherBag the FiniteBag that is being united
     * @return a new bag that is the union of bag and this
     */         
    public FiniteBag<T> union (FiniteBag<T> otherBag);
    
    /**
     * Returns a bag that only contains the elements that are contained in two given bags
     * @param otherBag the FiniteBag that is being intersected
     * @return a new bag that is the intersection of bag and this
     */  
    public FiniteBag<T> inter (FiniteBag<T> otherBag);
    
    /**
     * Removes the elements in one bag from another
     * @param otherBag the FiniteBag that is being tested
     * @return a new bag that is the difference of bag and this
     */  
    public FiniteBag<T> diff (FiniteBag<T> otherBag);
    
    /**
     * Checks if two bags are identical
     * @param otherBag the FiniteBag that is being tested
     * @return a boolean if bag and this are equal
     */  
    public boolean equal (FiniteBag<T> otherBag);
    
    /**
     * Checks if all of the elements of one bag are contained in the other
     * @param otherBag the FiniteBag that is being tested
     * @return a boolean if bag is a subset of this
     */  
    public boolean subset (FiniteBag<T> otherBag);
    
    /**
     * Rotates the FiniteBag to the right. The left child becomes the new head 
     * the head, becomes the right child 
     * along with everything that was contained the right child previously.
     *
     * @return a new FiniteBag with the same objects as the old one but rotated to the right
     */
    public FiniteBag<T> rotateR();
    
    /** 
     * Performs the same function as rotateRight except it rotates the bag
     * to the left
     *
     * @return a new FiniteBag with the same elements as the old one but rotated to the left
     */
    public FiniteBag<T> rotateL();
    
    /**
     * Checks each node in the tree from bottom up to insure that at any key the difference 
     * between the height of its left and right children is never 
     * greater than 1. In cases of larger differences, rotateR() or
     * rotateL() are called, depending on which branch is longer.
     *
     * @return a balanced AVL tree
     */
    public FiniteBag<T> makeAVL();
}
