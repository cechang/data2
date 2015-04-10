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
	if (this.left.isEmptyHuh()){
	    return this.right.here();
	} else {
	    return this.left.here();
	}
    }
    public boolean isEmptyHuh(){
	return this.left.isEmptyHuh() && this.right.isEmptyHuh();
    }
    public Sequence<T> next(){
	if (this.left.isEmptyHuh()){
	    return new MakeSeq<T>(this.left, this.right.next());
	} else {
	    return new MakeSeq<T>(this.left.next(), this.right);
	}
    }
    public Sequence<T> seq(){
	return this;
    }
    
}
