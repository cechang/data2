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
 * KeyNode represents the node containing a key with some multiplicity
 * @param <T> The generic datatype that the FiniteBag will hold.
 * 
 */
public class KeyNode<T extends Comparable<T>> implements FiniteBag<T>, Sequence<T> {
        
    FiniteBag<T> left;
    T key;
    int mult;
    FiniteBag<T> right;
    
    //KeyNode constructor
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
    
    /** 
     * @param thing is the key you are getting the multiplicity of
     * @return integer that represents the multiplicity of the key
     */
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
    
    /**
     * @return false since KeyNodes always contain an element
     */
    public boolean isEmptyHuh(){
        return false;
    }
    
    /**
     * @return the height of the bag
     */
    public int depth(){
	int depth = 0;
	if (this.right.depth() > this.left.depth()) {
	    depth = 1 + this.right.depth();
	} else {
	    depth = 1 + this.left.depth();
	}
	return depth;
    }
    
    /** 
     * @return integer that represents the number of elements in the bag
     */
    public int cardinality(){
        return this.getMult(key) + this.left.cardinality() + this.right.cardinality();
    }
    
    /**
     * @param thing the element T that is being tested
     * @return boolean if thing is in the bag
     */
    public boolean member(T thing){
        if(this.key.equals(thing)){
            return true;
        }
        else{
            return this.left.member(thing) || this.right.member(thing) ;
        }
    }
    
    /**
     * @param thing the element T that is being added
     * @return new bag with thing added once
     */ 
    public FiniteBag<T> add(T thing){
        if(this.key.equals(thing)){
            return new KeyNode(this.left, this.key, this.mult + 1, this.right);
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.add(thing)).makeAVL();
        }
        else{
            return new KeyNode(this.left.add(thing), this.key, this.mult, this.right).makeAVL();
        }
    }
    
    /**
     * @param thing the element T that is being added
     * @param n multiplicity of added number
     * @return new bag with thing added once
     */
    public FiniteBag<T> add(T thing, int n){
        if(this.key.equals(thing)){
            return new KeyNode(this.left, this.key, this.mult + n, this.right);
        }
        else if(thing.compareTo(key) > 0){
            return new KeyNode(this.left, this.key, this.mult, this.right.add(thing, n)).makeAVL();
        }
        else{
            return new KeyNode(this.left.add(thing, n), this.key, this.mult, this.right).makeAVL();
        }
    }
    
    /**
     * @param otherBag the FiniteBag that is being united
     * @return a new bag that is the union of bag and this
     */  
    public FiniteBag<T> union(FiniteBag<T> otherBag){
        
        FiniteBag<T> newBag = otherBag.add(this.key, this.mult);
        return (this.right.union(this.left)).union(newBag);
    }
    
    /**
     * @param thing the element T that is being removed
     * @return new bag with thing removed once
     */
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
            return new KeyNode(this.left, this.key, this.mult, this.right.remove(thing)).makeAVL();
        }
        else{
            return new KeyNode(this.left.remove(thing), this.key, this.mult, this.right).makeAVL();
        }
    }
    
    /**
     * @param thing the element T that is being removed
     * @param n multiplicity of added number
     * @return new bag with thing removed once
     */
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
            return new KeyNode(this.left, this.key, this.mult, this.right.remove(thing,n)).makeAVL();
        }
        else{
            return new KeyNode(this.left.remove(thing,n), this.key, this.mult, this.right).makeAVL();
        }
    }
    
    /**
     * @param otherBag the FiniteBag that is being intersected
     * @return a new bag that is the intersection of bag and this
     */  
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
            return this.remove(this.key).inter(otherBag).makeAVL();                    
        }
    }
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return a new bag that is the difference of bag and this
     */  
    public FiniteBag<T> diff(FiniteBag<T> otherBag){
        if(this.getMult(key) >= otherBag.getMult(key)){
            return (this.remove(this.key)).diff(otherBag.remove(this.key)).makeAVL();
        }
        else{
            FiniteBag<T> removed = otherBag.remove(this.key, this.getMult(this.key));
            return (left.union(right)).diff(removed).makeAVL();
        }
    }
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return a boolean if bag is a subset of this
     */ 
    public boolean subset(FiniteBag<T> otherBag){
        if(otherBag.member(this.key)){
            return this.left.subset(otherBag) && this.right.subset(otherBag);
        }
        else{
            return false;
        }
    }
    
    /**
     * @param otherBag the FiniteBag that is being tested
     * @return a boolean if bag and this are equal
     */  
    public boolean equal(FiniteBag<T> otherBag){
        return (otherBag.subset(this) && this.subset(otherBag));  
    }
    
    /** 
     * @return a new bag with the same elements as the old one but rotated to the left
     */
    public FiniteBag<T> rotateL() {
        KeyNode newNode = (KeyNode) this.right;
        return new KeyNode(
                new KeyNode(this.left,this.key,this.mult,newNode.left),
                newNode.key,
                newNode.mult,
                newNode.right);
    }

    /** 
     * @return a new bag with the same elements as the old one but rotated to the right
     */
    public FiniteBag<T> rotateR() {
        KeyNode newNode = (KeyNode) this.left;
        return new KeyNode(
                    newNode.left, 
                    newNode.key,
                    newNode.mult,
                    new KeyNode(newNode.right,
                                this.key,
                                this.mult,
                                this.right));
    }
    
    /**
     * @return a balanced AVL tree with the same elements as the original
     */
    public FiniteBag<T> makeAVL(){
	FiniteBag rotated;
        if (this.left.depth() - this.right.depth() > 1){
	    rotated = this.rotateR();
	} else if (this.right.depth() - this.left.depth() > 1) {
	    rotated = this.rotateL();
	} else {
	    rotated = this;
	}
	return rotated;
    }
    
    public Sequence<T> seq() {
        return this;
    }

    public T here() {
        return this.key;
    }

    public Sequence<T> next() {
        return new MakeSeq<T>(left.seq(), right.seq());
    }
    

    
}
