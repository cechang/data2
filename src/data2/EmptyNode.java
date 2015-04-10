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
 * EmptyNode represents the empty node at any end of bag
 * @param <T> The generic datatype that the FiniteBag will hold.
 */
public class EmptyNode<T extends Comparable<T>> implements FiniteBag<T>{
    
    // constructor for EmptyNode  
    EmptyNode(){        
    }
    
    /**
     * @return a fresh empty bag
     */
    public FiniteBag<T> empty(){
        return new EmptyNode();
    }
    
    /**
     * @return true since EmptyNodes are always empty
     */
    public boolean isEmptyHuh() {
        return true;
    }
    
    /** 
     * @param thing is the key you are getting the multiplicity of
     * @return 0 since thing was not found in the bag
     */
    public int getMult(T thing){
        return 0;
    }
    
    public String toString() {
        return "";
    }
    
    /**
     * @return 0 since EmptyNodes don't contain anything
     */
    public int cardinality(){
        return 0;
    }
    
    /**
     * @return false since EmptyNodes don't contain anything
     */
    public boolean member(T thing){
        return false;
    }
    
    /**
     * @param thing the element that is being tested
     * @return a new bag with a KeyNode replacing the EmptyNode it hit. The new key is thing
     */
    public FiniteBag<T> add(T thing){
        FiniteBag<T> newEmpty = new EmptyNode();
        FiniteBag<T> newBag = new KeyNode<T>(newEmpty, thing, 1, newEmpty);
        return newBag;                
    }
    
    /**
     * @param thing the element that is being tested
     * @param n multiplicity of added number
     * @return a new bag with a KeyNode replacing the EmptyNode it hit. The new key is thing
     */
    public FiniteBag<T> add(T thing, int n){
        FiniteBag<T> newEmpty = new EmptyNode();
        FiniteBag<T> newBag = new KeyNode<T>(newEmpty, thing, n, newEmpty);
        return newBag;                
    }
    
    /**
     * @param otherBag the FiniteBag that is being united
     * @return otherBag since EmptyNodes don't contain anything
     */
    public FiniteBag<T> union(FiniteBag<T> otherBag){
        return otherBag;
    }
    
    /**
     * @param thing the element T that is being removed
     * @return this since EmptyNodes don't contain anything
     */
    public FiniteBag<T> remove(T thing){
        return this;
    }
    
    /**
     * @param thing the element T that is being removed
     * @param n multiplicity of added number
     * @return this since EmptyNodes don't contain anything
     */
    public FiniteBag<T> remove(T thing,int n){
        return this;
    }
    
    /**
     * @param otherBag the FiniteBag that is being intersected
     * @return this since EmptyNodes don't contain anything
     */  
    public FiniteBag<T> inter(FiniteBag<T> otherBag){
        return this;
    }
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return otherBag since EmptyNodes don't contain anything
     */  
    public FiniteBag<T> diff(FiniteBag<T> otherBag){
        return otherBag;
    }
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return true since EmptyNodes are in all bags
     */  
    public boolean subset(FiniteBag<T> otherBag){
        return true;
    }
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return true since EmptyNodes are all the same
     */  
    public boolean equal(FiniteBag<T> otherBag){
        return true;
    }
    
}
