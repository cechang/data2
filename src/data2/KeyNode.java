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
public class KeyNode<T extends Comparable<T>> implements FiniteBag<T> {
        
    FiniteBag<T> left;
    T key;
    int mult;
    FiniteBag<T> right;
    
    KeyNode(FiniteBag<T> left, T key, int mult, FiniteBag<T> right){
        this.left = left;
        this.key = key;
        this.mult = mult;
        this.right = right;       
    }
    
    public String toString() {
        return this.left.toString() + " " +
                this.key.toString() + "(" + 
                this.mult + ") " +
                this.right.toString();
    }
    
    public int getMult(T thing) {
        if (thing.compareTo(key) == 0) {
            return mult;
        } else if (thing.compareTo(key) < 0) {
            return this.left.getMult(thing);
        } else {
            return this.right.getMult(thing);
        }
    }
    
    /**
     * @return a fresh empty bag
     */
    public FiniteBag<T> empty(){
        return new EmptyNode();
    }
    
    public boolean isEmptyHuh(){
        return false;
    }
    
    public int cardinality(){
        return this.getMult(key) + this.left.cardinality() + this.right.cardinality();
    }
    
    public boolean member(T thing){
        if(this.key.equals(thing)){
            return true;
        }
        else{
            return this.left.member(thing) || this.right.member(thing) ;
        }
    }
    

    public FiniteBag<T> add(T thing){
        if(this.key.equals(thing)){
            return new KeyNode(this.left, this.key, this.mult + 1, this.right);
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.add(thing));
        }
        else{
            return new KeyNode(this.left.add(thing), this.key, this.mult, this.right);
        }
    }
    
    public FiniteBag<T> add(T thing, int n){
        if(this.key.equals(thing)){
            return new KeyNode(this.left, this.key, this.mult + n, this.right);
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.add(thing, n));
        }
        else{
            return new KeyNode(this.left.add(thing, n), this.key, this.mult, this.right);
        }
    }
    
    public FiniteBag<T> union(FiniteBag<T> otherBag){
        
        FiniteBag<T> newBag = otherBag.add(this.key, this.mult);
        return (this.right.union(this.left)).union(newBag);
    }
    
    public FiniteBag<T> remove(T thing){
        if(this.key.equals(thing)){
            if(this.mult == 0){                
                return this.left.union(this.right);
            }
            else{
                return new KeyNode(this.left, this.key, this.mult - 1, this.right);
            }
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.remove(thing));
        }
        else{
            return new KeyNode(this.left.remove(thing), this.key, this.mult, this.right);
        }
    }
    
    public FiniteBag<T> remove(T thing, int n){
        if(thing.equals(this.key)){
            if(this.mult - n == 0){                
                return this.left.union(this.right);
            }
            else{
                return new KeyNode(this.left, this.key, this.mult - n, this.right);
            }
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.remove(thing,n));
        }
        else{
            return new KeyNode(this.left.remove(thing,n), this.key, this.mult, this.right);
        }
    }
    
    public FiniteBag<T> inter(FiniteBag<T> otherBag){
        if(otherBag.member(this.key)){
            if(otherBag.getMult(key) > this.getMult(key)){
                return new KeyNode(this.left.inter(otherBag), this.key, this.getMult(key), this.right.inter(otherBag));
            }
            else{
                return new KeyNode(this.left.inter(otherBag), this.key, otherBag.getMult(key), this.right.inter(otherBag));
            }
        }
        else{
            return this.remove(this.key).inter(otherBag);                    
        }
    }
    
    public FiniteBag<T> diff(FiniteBag<T> otherBag){
        if(this.getMult(key) >= otherBag.getMult(key)){
            return (this.remove(this.key)).diff(otherBag.remove(this.key));
        }
        else{
            FiniteBag<T> removed = otherBag.remove(this.key, this.getMult(this.key));
            return (left.union(right)).diff(removed);
        }
    }
        
    public boolean subset(FiniteBag<T> otherBag){
        if(otherBag.member(this.key)){
            return this.left.subset(otherBag) && this.right.subset(otherBag);
        }
        else{
            return false;
        }
    }
    
    public boolean equal(FiniteBag<T> otherBag){
        return (otherBag.subset(this) && this.subset(otherBag));  
    }
    
    
}
