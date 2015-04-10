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
        return 1 + this.left.cardinality() + this.right.cardinality();
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
        if(this.member(thing)){
            return new KeyNode(this.left, this.key, this.mult + 1, this.right.add(thing));
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.add(thing));
        }
        else{
            return new KeyNode(this.left.add(thing), this.key, this.mult, this.right);
        }
    }
    
    public String toString() {
        return this.left.toString() + ", " +
                this.key +
                " happens " + this.mult + "time(s), "
                this.right.toString();
    }
    
    public FiniteBag<T> union(FiniteBag<T> otherbag){
        FiniteBag<T> newBag = otherbag.add(this.key);
        return (this.right.union(this.left)).union(newBag);
    }
    
    public FiniteBag<T> remove(T thing){
        if(this.member(thing)){
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
    
    public FiniteBag<T> diff(FiniteBag<T> bag){
        return (this.remove(this.key)).diff(bag.remove(this.key));
    }
    
    public boolean subset(FiniteBag<T> bag){
        if(bag.member(this.key) == true){
            return this.left.subset(bag) && this.right.subset(bag);
        }
        else{
            return false;
        }
    }
    
    public boolean equal(FiniteBag<T> bag){
        if(bag.subset(this) && this.subset(bag) == true){
            return true;
        }
        else{
            return false;
        }
    
    }
    
    
}
