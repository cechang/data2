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
public class EmptyNode<T extends Comparable<T>> implements FiniteBag<T>{
    
      
    EmptyNode(){        
    }
    
    public FiniteBag<T> empty(){
        return new EmptyNode();
    }
    public boolean isEmptyHuh() {
        return true;
    }
    
    public String toString() {
        return "";
    }
    
    public int cardinality(){
        return 0;
    }
    public boolean member(T thing){
        return false;
    }
    
    public FiniteBag<T> add(T thing){
        FiniteBag<T> newBag = new KeyNode<T>(this, thing, this);
        return newBag;                
    }
    
    public FiniteBag<T> union(FiniteBag<T> otherBag){
        return otherBag;
    }
    
    public FiniteBag<T> remove(T thing){
        return this;
    }
    
    public FiniteBag<T> inter(FiniteBag<T> otherBag){
        return this;
    }
    
    public FiniteBag<T> diff(FiniteBag<T> otherBag){
        return otherBag;
    }
    
    public boolean subset(FiniteBag<T> otherBag){
        return true;
    }
    
    public boolean equal(FiniteBag<T> otherBag){
        return true;
    }
    
}
