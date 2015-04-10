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
    
    /**
     * Gives the element in the sequence
     * @return an element T within the sequence
     */
    public T here();

    /**
     * Checks if the the sequence is empty
     * @return false if there is at least one item in the sequence
     *         
     */
    public boolean isEmptyHuh();
    
    /**
     * Gives the next elements in the sequence
     * @return a sequence made up of the rest of the elements
     */
    public Sequence<T> next();
}
