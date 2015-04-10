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
public class MakeSeq <T extends Comparable<T>> implements Sequence<T>{
    Sequence<T> left;
    Sequence<T> right;

    MakeSeq(Sequence<T> left, Sequence<T> right){
	this.left = left;
	this.right = right;
    }
    public T here(){
	if (!this.left.isEmptyHuh()){
	    return this.left.here();
	} else {
	    return this.right.here();
	}
    }
    public boolean isEmptyHuh(){
	return this.left.isEmptyHuh() && this.right.isEmptyHuh();
    }
    public Sequence<T> next(){
	if (!this.left.isEmptyHuh()){
	    return new MakeSeq<T>(this.left.next(), this.right);
	} else {
	    return this.right.next();
	}
    }
    public Sequence<T> seq(){
	return this;
    }
    
}
