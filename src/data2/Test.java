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

/**
 * 
 * creates randomly generated tests
 *  
 */
public class Test<T extends Comparable<T>> {
    
    public Test() {
    }

    /*
    public FiniteBag randomIntBag(int numAdd, int rangeAdd) {
        FiniteBag randBag = new EmptyNode();
        for (int i = 0; i < numAdd; i++) {
            Random newRandom = new Random();
            int randInt = newRandom.nextInt(rangeAdd);
            randBag = randBag.add(randInt);
        }
        return randBag;
    }
*/
    /**
     * 
     * @param n number of random integers generated in the bag
     * @return FiniteBag with n number of randomly generated integers
     */
    public static FiniteBag randIntBag(int n) {
        FiniteBag testBag = new EmptyNode();
        for (int i = 0; i < n; i++) {
            int rand = (int) ((Math.round(100 * Math.random())));
            testBag = testBag.add(rand);
        }
        return testBag;
    }
    
    /**
     *"Property 1: member (add t x) y = true &lt;-&gt; x = y \/ member t y = true"
     * 
     * @param t number of tests run
     * @param n number of integers in each bag
     * @return a message indicating where the tests failed if any. otherwise success
     */
    public String intTestProperty1(int t, int n) {
        for (int i = 0; i < t; i++) {
            int x = (int) ((Math.round(10 * Math.random())));
            int y = (int) ((Math.round(10 * Math.random())));
            Test randTest = new Test();
            FiniteBag tester1 = randTest.randIntBag(n);
            FiniteBag tester2 = tester1.add(x);
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
    public String intTestProperty2(int t, int n) {
        for (int i = 0; i < t; i++){
            Test randTest1 = new Test();
            FiniteBag tester1 = randTest1.randIntBag(n);
            Test randTest2 = new Test();
            FiniteBag tester2 = randTest2.randIntBag(n);
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
    public String intTestProperty3(int t, int n) {
        for (int i = 0; i < t; i++){
            Test randTest1 = new Test();
            FiniteBag tester1 = randTest1.randIntBag(n);
            Test randTest2 = new Test();
            FiniteBag tester2 = randTest2.randIntBag(n);
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
    public String intTestProperty4(int t, int n) {
        for (int i = 0; i < t; i++){
            Test randTest1 = new Test();
            FiniteBag tester1 = randTest1.randIntBag(n);            
            if((tester1.empty().cardinality() == 0)){
                if( ! tester1.empty().isEmptyHuh()){
                return ("you can't code, " + tester1 + " fails");
                }
            }                                      
        }
        return "hurray " + t + " tests worked";
    }    
    
    public static FiniteBag randStrBag(int n) {
        FiniteBag stringBag = new EmptyNode();
        String[] stringArray;
        stringArray = new String[26];
        stringArray[0] = "a";
        stringArray[1] = "b";
        stringArray[2] = "c";
        stringArray[3] = "d";
        stringArray[4] = "e";
        stringArray[5] = "f";
        stringArray[6] = "g";
        stringArray[7] = "h";
        stringArray[8] = "i";
        stringArray[9] = "j";
        stringArray[10] = "k";
        stringArray[11] = "l";
        stringArray[12] = "m";
        stringArray[13] = "n";
        stringArray[14] = "o";
        stringArray[15] = "p";
        stringArray[16] = "q";
        stringArray[17] = "r";
        stringArray[18] = "s";
        stringArray[19] = "t";
        stringArray[20] = "u";
        stringArray[21] = "v";
        stringArray[22] = "w";
        stringArray[23] = "x";
        stringArray[24] = "y";
        stringArray[25] = "z";
        for (int i = 0; i < n; i++) {
            Random newRandom = new Random();
            int randInt = newRandom.nextInt(25);
            stringBag = stringBag.add(stringArray[randInt]);
        }
        return stringBag;
    }
    
    public String strTestProperty1(int t, int n) {
        for (int i = 0; i < t; i++) {
            int x = (int) ((Math.round(10 * Math.random())));
            int y = (int) ((Math.round(10 * Math.random())));
            Test randTest = new Test();
            FiniteBag tester1 = randTest.randStrBag(n);
            FiniteBag tester2 = tester1.add(x);
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
   
}
