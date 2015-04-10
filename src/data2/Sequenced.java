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
public interface Sequenced<T extends Comparable> {
    
    /**
     * @return a new sequence comprised of the elements that are within 
     * whatever it is called upon
     */
    public Sequence seq();
}
