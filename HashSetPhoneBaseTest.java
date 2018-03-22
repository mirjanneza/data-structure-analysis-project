
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * The test class HashSetContainerTest.
 * It tests the add, select and size methods
 */

public class HashSetPhoneBaseTest
{
    /**
     * A method that checks that 4 elements can be added to the hash
     * set. It also checks that they are removed in the correct order.
     */
    @Test
    public void addHashSet(){

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        //Adding numbers to the hash set
        System.out.println(h.add(987654323l));
        System.out.println(h.add(987654321l));
        System.out.println(h.add(987654322l));
        System.out.println(h.add(987654325l));

        //Creating a test array of expected results
        Long[] test={987654321l,987654322l,987654323l,987654325l};

        //Gettings the result of the toArray class from the class
        Long[] b=new Long[4];
        for(int i=0;i<h.getSize();i++)
            b[i]=h.select(i+1);

        assertArrayEquals(test,b);
    }

    /**
     * A test method to see that the program returns false
     * if the user attempts to add a duplicate element to it
     */
    @Test
    public void testAddDuplicate(){

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        //Adding numbers to the hash set
        h.add(987654323);
        h.add(987654321);
        h.add(987654322);

        //Adding duplicate element
        assertEquals(h.add(987654322),false);

    }

    /**
     * A method that checks that the program return a -1
     * when asked to find k-th with k<=0
     */
    @Test
    public void select0(){

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        //Adding numbers to the hash set
        h.add(987654323);
        h.add(987654321);
        h.add(987654322);

        assertEquals(h.select(0),-1);
    }

    /**
     * A method that checks that the program return a -1
     * when asked to find k-th with k> size of data structure
     */
    @Test
    public void select4(){
        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        //Adding numbers to the hash set
        h.add(987654323);
        h.add(987654321);
        h.add(987654322);

        assertEquals(h.select(4),-1); 

    }

    /**
     * Testing that the program can add 100 numbers and return the 
     * time taken to do so
     */
    @Test
    public void add100(){
        Random rand=new Random();

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        //starting time
        long startTime=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            // System.out.println(i);
            h.add(rand.nextLong());
        }
        //Stopping time
        long stopTime=System.currentTimeMillis();
        System.out.println("Hash Set Add:"+(stopTime-startTime));
    }

    /**
     * Testing that the program can remove 10 numbers and return the 
     * time taken to do so
     */
    @Test
    public void remove10(){
        Random rand=new Random();

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        for(int i=0;i<100;i++){
            // System.out.println(i);
            h.add(100-i);

        }
        Random rand2=new Random();

        //starting time
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            System.out.println( h.select(i+1));
        }
        //Stopping time
        long stopTime=System.currentTimeMillis();
        System.out.println("Hash Set Remove:"+(stopTime-startTime));
    }

    /**
     * A test which checks that the program throws an error when you 
     * try to select from an empty hash set
     */
    @Test
    public void testRemoveEmpty(){

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();
        long flag=0;

        flag= h.select(1);

        assertEquals(flag,-1);
    }

    /**
     * A method that tests the size method to return the correct size
     */
    @Test
    public void testSize(){ 

        //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        //Adding numbers to the hash set
        h.add(987654323);
        h.add(987654321);
        h.add(987654322);
        h.add(987654325);

        assertEquals(h.getSize(),4);

    }

    /**
     * A method that tests the size method to return the correct 
     * for an empty 
     */
    @Test
    public void testSizeEmpty(){ //Creating object of hash set container
        HashSetPhoneBase h=new HashSetPhoneBase();

        assertEquals(h.getSize(),0);
    }
}
