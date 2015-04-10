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
public interface Sequence<T extends Comparable<T>> {
    
    public T here();

    public boolean isEmptyHuh();

    public Sequence<T> next();
}
