/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.util.*;
/**
 *
 * @author Cedric
 */
public class Test<T extends Comparable<T>> {
    
    public Test() {
    }

    public FiniteBag randomIntBag(int numAdd, int rangeAdd) {
        FiniteBag randBag = new EmptyNode();
        for (int i = 0; i < numAdd; i++) {
            Random newRandom = new Random();
            int randInt = newRandom.nextInt(rangeAdd);
            randBag = randBag.add(randInt);
        }
        return randBag;
    }

    /*
     Property 1
     member (add t x) y = true <-> x = y \/ member t y = true
     */
    public String testProperty1(int t, int n) {
        for (int i = 0; i < t; i++) {
            int x = (int) ((Math.round(10 * Math.random())));
            int y = (int) ((Math.round(10 * Math.random())));
            Test randTest = new Test();
            FiniteSet tester1 = randTest.randFiniteSet(n);
            FiniteSet tester2 = tester1.add(x);
            if (tester2.member(y)) {
                if (tester1.member(y) || (x == y)) {
                } 
                else {
                    return ("you can't code, " + x + " and " + y + "fails with " + tester1 );
                }
            } 
            else {
                if (tester1.member(y) || (x == y)) {
                    return ("you can't code, " + x + " and " + y + " fails with " + tester1 );
                }
            }
        }
        return "hurray " + t + " tests worked";
    }
    /*
    Property2 
    (t.diff(u)).subset(u) == true
    */
    public String testProperty2(int t, int n) {
        for (int i = 0; i < t; i++){
            Test randTest1 = new Test();
            FiniteSet tester1 = randTest1.randFiniteSet(n);
            Test randTest2 = new Test();
            FiniteSet tester2 = randTest2.randFiniteSet(n);
            if( ! (tester1.diff(tester2)).subset(tester2)){
                return ("you can't code, " + tester1 + " and " + tester2 + " fail");
            }                                      
        }
        return "hurray " + t + " tests worked";
    }
    
    /*
    Property3 
    u.inter(t) == t.inter(u)
    */
    public String testProperty3(int t, int n) {
        for (int i = 0; i < t; i++){
            Test randTest1 = new Test();
            FiniteSet tester1 = randTest1.randFiniteSet(n);
            Test randTest2 = new Test();
            FiniteSet tester2 = randTest2.randFiniteSet(n);
            if( ! (tester2.inter(tester1)).equal(tester1.inter(tester2))){
                return ("you can't code, " + tester1 + " and " + tester2 + " fail");
            }                                      
        }
        return "hurray " + t + " tests worked";
    }
    
    /*
    Property4 
    t.empty().cardinality == 0 if t.empty().isEmptyHuh() is true
    */
    public String testProperty4(int t, int n) {
        for (int i = 0; i < t; i++){
            Test randTest1 = new Test();
            FiniteSet tester1 = randTest1.randFiniteSet(n);            
            if((tester1.empty().cardinality() == 0)){
                if( ! tester1.empty().isEmptyHuh()){
                return ("you can't code, " + tester1 + " fails");
                }
            }                                      
        }
        return "hurray " + t + " tests worked";
    }        
}
