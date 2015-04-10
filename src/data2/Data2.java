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
public class Data2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EmptyNode mtNode = new EmptyNode();
        
        KeyNode node1 = new KeyNode (mtNode,3,1,mtNode);
        KeyNode node2 = new KeyNode (mtNode,7,3,mtNode);
        KeyNode myTest1 = new KeyNode(node1,6,1,node2);
        
        KeyNode node3 = new KeyNode (mtNode, 4,1, mtNode);
        KeyNode node4 = new KeyNode (mtNode, 7,1, mtNode);
        KeyNode myTest2 = new KeyNode (node3, 5,1, node4);
        
        KeyNode node5 = new KeyNode (mtNode, 4,1, mtNode);
        KeyNode node6 = new KeyNode (mtNode, 7,1, mtNode);
        KeyNode myTest3 = new KeyNode (node5, 5,1, node6);
        
        KeyNode node7 = new KeyNode (mtNode, 4,1,mtNode);
        KeyNode node8 = new KeyNode (node7, 5,1,mtNode);
        KeyNode node9 = new KeyNode (mtNode, 9,1,mtNode);
        KeyNode node10 = new KeyNode (mtNode, 8,1,node9);
        KeyNode myTest4 = new KeyNode (node8, 7,1,node10);
        /* myTest1
                            6
                           / \
                          3   7(3)
        
           myTest2 and myTest3
                            5
                           / \
                          4   7 
                
           myTest4
                            7
                           / \
                          5   8
                         / \ / \
                        4       9
        */
        
        System.out.println("empty myTest1 " +myTest1.empty() + " should be ");
        System.out.println("card of myTest1 is " +myTest1.cardinality() + " should be 5");
        System.out.println("mult of 6 in myTest2 is " +myTest2.getMult(6) + " should be 0 ");
        System.out.println("the number 3 is a member of my Test1: " + myTest1.member(3) + " should be true");
        System.out.println("the number 4 is a member of my Test1: " + myTest1.member(4) + " should be false");
        System.out.println("add 8 to Test1: " + myTest1.add(8) + " should be 3(1) 6(1) 7(3) 8(1)");
        System.out.println("add 3 to Test1: " + myTest1.add(3) + " should be 3(2) 6(1) 7(3)");
        System.out.println("add 6 to Test1: " + myTest1.add(6) + " should be 3(1) 6(2) 7(3)");
        System.out.println("add 7 to Test1: " + myTest1.add(7) + " should be 3(1) 6(2) 7(4)");
        System.out.println("unite Test1 and Test2: " + myTest2.union(myTest1) + " should be 3(1) 4(1) 5(1) 6(1) 7(4)");
        System.out.println("unite Test2 and Test1: " + myTest1.union(myTest2) + " should be 3(1) 4(1) 5(1) 6(1) 7(4)");
        System.out.println("remove 7 from Test1: " + myTest1.remove(7,1) + " should be 3(1) 6(1) 7(2)");
        System.out.println("remove 3 from Test1: " + myTest1.remove(3,1) + " should be 6(1) 7(3)");
        System.out.println("intersect Test1 and Test2: " + myTest1.inter(myTest2) + " should be 7(1)");
        System.out.println("difference between myTest1 from Test2: " + myTest1.diff(myTest2) + " should be 4(1) 5(1)");
        System.out.println("difference between myTest2 from Test1: " + myTest2.diff(myTest1) + " should be 3(1) 6(1) 7(2)");
        System.out.println("Test2 subset of Test4: " + myTest2.subset(myTest4) + " should be true ");
        System.out.println("Test4 subset of Test2: " + myTest4.subset(myTest2) + " should be false ");
        System.out.println("Test2 subset of Test3: " + myTest2.subset(myTest3) + " should be true ");
        System.out.println("Test3 subset of Test2: " + myTest3.subset(myTest2) + " should be true ");
        System.out.println("Test2 equals Test1: " + myTest2.equal(myTest1) + " should be false");
        System.out.println("Test2 equals Test3: " + myTest2.equal(myTest3) + " should be true");
        
    }
    
}
