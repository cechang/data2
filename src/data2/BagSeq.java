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
public class BagSeq<T extends Comparable<T>> implements Sequence<T> {
    MakeSeq<T> s;
    T iden;
    int mult;

    BagSeq (MakeSeq<T> s, T iden, int multi) {
	this.s = s;
	this.iden = iden;
	this.mult = mult;
    }
    public T here() {
        return this.iden;
    }
    public boolean isEmptyHuh() {
        return false;
    }
    public Sequence next() {
	if (this.mult > 1){
	    return new BagSeq(this.s, this.iden, this.mult - 1);
	} else {
	    return this.s;
	}
    }
    public Sequence seq(){
	return this;
    }

}
